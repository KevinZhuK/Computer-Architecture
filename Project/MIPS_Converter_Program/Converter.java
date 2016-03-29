package Converter;

// opcode  rs rt (rd/immediate)
// R type - instr rd, rs, rt
// I type - instr rt, rs, immed OR instr rt, immed(rs)
// J type - instr addr

public class Converter {
	Parsing P=new Parsing();
	//Output from Instruction to Hex
	String Hex_Output;
	//Output from Hex to Instruction
	String Instruction;
	
	String Type;
	String opcode;
	String rs;
	String rt;
	String rd;
	String shamt;
	String funct;
	String immediate;
	public String Instructions_to_Hex(String input)
	{
		String Para1=null;
		String Para2=null;
		String Para3=null;
		funct=P.Get_Func(input);
		String Instruction_Set[];
		String[] Instruction_Parts = input.split("\\s+");
		int len=Instruction_Parts.length;
		Instruction_Set=P.Get_InstrSet(Instruction_Parts[0]);
		if(Instruction_Set==null){return "Error: Invalid Instructions";}
		
		Type=Instruction_Set[1];
		switch(Type)
		{
		case "J_TYPE":
			
			if(len==2)
			{
				Para1=Instruction_Parts[1];
				if(Para1.contains("0x"))
				{
					//not sure length
					Para1=P.hex_to_binary(Para1.substring(2, Para1.length()));
					Para1=Para1.substring(6, Para1.length());
				}
				else
				{
					Hex_Output="Error: Invalid Jump Address!";
				}
			}
			else 
			{Hex_Output="Error: Invalid Instructions";}
			funct=P.hex_to_binary(Instruction_Set[2]).substring(2, 8);
			Hex_Output=String.format(Instruction_Set[5],funct, Para1);
			break;
		case "I_TYPE":
			if(len==4)
			{
				Para1=P.Get_Binary_by_Register(Instruction_Parts[1]).substring(3, 8);
				Para2=Instruction_Parts[2];
				if(Para2.contains("0x"))
				{
					Para2=P.hex_to_binary(Para2.substring(2, Para2.length()));
				}
				else if (Para2.contains("$"))
				{
					Para2=P.Get_Binary_by_Register(Para2).substring(3, 8);
				}
				else
				{Hex_Output="Error: Invalid i-type Address!";	}
				Para3=Instruction_Parts[3];
				if(Para3.contains("0x"))
				{
					Para3=P.hex_to_binary(Para3.substring(2, Para3.length()));
				}
				else if (Para3.contains("$"))
				{
					Para3=P.Get_Binary_by_Register(Para3).substring(3, 8);
				}
				else
				{Hex_Output="Error: Invalid i-type Address!";	}
			}
			else {Hex_Output="Error: Invalid Instructions";}
			funct=P.hex_to_binary(Instruction_Set[2]).substring(2, 8);
			Hex_Output=String.format(Instruction_Set[5],funct, Para1, Para2, Para3);
			break;
		case "R_TYPE":
			if(len==4)
			{
				Para1=P.Get_Binary_by_Register(Instruction_Parts[1]).substring(3, 8);
				Para2=P.Get_Binary_by_Register(Instruction_Parts[2]).substring(3, 8);
				Para3=Instruction_Parts[3];
				if(Para3.contains("$"))
				{
					Para3=P.Get_Binary_by_Register(Para3).substring(3, 8);
				}
				else
				{
					Para3=P.hex_to_binary(Instruction_Parts[3].substring(2, Instruction_Parts[3].length())).substring(3, 8);	
				}
			}
			else if(len==2)
			{
				Para1=P.Get_Binary_by_Register(Instruction_Parts[1]).substring(3, 8);
			}
			else {Hex_Output="Error: Invalid Instructions";}
			funct=P.hex_to_binary(Instruction_Set[3]).substring(2, 8);
			Hex_Output=String.format(Instruction_Set[5],funct, Para1, Para2, Para3);
			break;
		default:
			Instruction="Error: Invalid Instructions!";
			break;
		}

		return P.binary_to_hex_output("ToHex", Hex_Output);
	}
	
	public String Hex_to_Instructions(String Hex)
	{
		//Check Input validation
		if(P.Hex_Check(Hex)!=true)
		{
			return "Please check your Hex number (example:0x014B4820)";
		}
		Hex=P.Remove_X(Hex);
		String Instruction_Set[];
		//converter Hex to Binary
		String BinString =P.hex_to_binary(Hex);
		opcode=BinString.substring(0,6); 
		Instruction_Set=P.Get_InstrType(P.binary_to_hex(opcode));
		Type=Instruction_Set[1];
		switch(Type)
		{
		case "J_TYPE":
			opcode=Instruction_Set[0];
			immediate=P.binary_to_hex_output(Type, BinString.substring(6,32));
			Instruction=String.format(Instruction_Set[4], immediate);
			break;
		case "I_TYPE":
			opcode=Instruction_Set[0];
			rs=P.Get_Register(P.binary_to_hex(BinString.substring(6,11)));
			rt=P.Get_Register(P.binary_to_hex(BinString.substring(11,16)));
			//ERROR
			immediate=(String) P.binary_to_hex_output(Type,BinString.substring(16, 32));
			Instruction=String.format(Instruction_Set[4], rs, rt, immediate);
			break;
		case "R_TYPE":
			Instruction_Set=P.Get_R_Instr(P.binary_to_hex(BinString.substring(26,32)));
			rs=P.Get_Register(P.binary_to_hex(BinString.substring(6,11)));
			rt=P.Get_Register(P.binary_to_hex(BinString.substring(11,16)));
			rd=P.Get_Register(P.binary_to_hex(BinString.substring(16,21)));
			shamt=P.binary_to_hex(BinString.substring(21,26));
			Instruction=String.format(Instruction_Set[4], rs, rt, rd, P.Add_X(shamt));
			break;
		default:
			Instruction="Type Not Exist!";
			break;
		}
		
		return Instruction;	
	}
	public String Hex_to_Binary(String Hex)
	{
		return P.hex_to_binary(P.Remove_X(Hex));
	}

}
