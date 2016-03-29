package Converter;

import java.math.BigInteger;

public class Parsing {
	Resource_Table Resource=new Resource_Table();
	
	//----------------------Instruction to Hex Part----------------------
	//Get Function from Instruction
	public String Get_Func(String Instruction)
	{
		
		String Func="Instruction Not Valid";
		if(Instruction.contains(" ")){
			   Func= Instruction.substring(0, Instruction.indexOf(" ")); 
			  }
		return Func;
	}
	//Return Instruction Set based on Func code
	public String[] Get_InstrSet(String Func)
	{
		String[][] RT=Resource_Table.HEX_MIPS_TABLE;
		for(int i =0; i<RT.length;i++)
		{
			if(Func.equalsIgnoreCase(RT[i][0]))
			{
				return RT[i];
			}
		}
		return null;
	}
	public String Get_Binary_by_Register(String Reg)
	{
		String hex = null;
		String[][] RT=Resource_Table.REGISTERS;
		for(int i =0; i<RT.length;i++)
		{
			if(Reg.equalsIgnoreCase(RT[i][0]))
			{
				hex= RT[i][1];
				break;
			}
		}
		hex=this.hex_to_binary(hex);
		return hex;
	}
	
	
	//----------------------END----------------------
	//----------------------Hex to Instruction Part----------------------
	
	//Hex code verfication
	public Boolean Hex_Check(String Hex)
	{
		if(Hex.length()<8)
		{
			return false;
		}
		if(Hex.substring(0,2).equals("0x"))
		{
			if(Hex.length()==10)
			{return true;}
			else
			{return false;}
		}
		else{
			if(Hex.length()==8)
			{return true;}
			else
			{return false;}
		}
	}
	//Remove 0x
	public String Remove_X(String S)
	{
		if (S.substring(0,2).equals("0x"))
		{
			return S.substring(2, S.length());
		}
		else
		{
			return S;
		}
	}
	//add Ox
	public String Add_X(String S)
	{
		return "0x"+S;
	}
	public String hex_to_binary(String hex)
	{
		hex=hex.length()%2==1?'0'+hex:hex;
		if (hex == null || hex.length() % 2 != 0)
			return null;
		String bString = "", tmp;
		for (int i = 0; i < hex.length(); i++)
		{
			tmp = "0000"
					+ Integer.toBinaryString(Integer.parseInt(hex
							.substring(i, i + 1), 16));
			bString += tmp.substring(tmp.length() - 4);
		}
		return bString;
	}
	
	public String binary_to_hex(String binary) {
		int i=Integer.parseInt(binary,2);
		String hex=Integer.toHexString(i);
		return hex;
	}
	public String binary_to_Decimal(String binary) {
		Integer i=Integer.parseInt(binary, 2);
		return i.toString();
	}
	//ADD '0x' and '0' if length <7 for J type
	public String binary_to_hex_output(String Type, String binary) {
		BigInteger i=new BigInteger(binary,2);
		String hex=i.toString(16);
		if(Type.equals("I_TYPE"))
		{
			while(hex.length()<4)
			{
				hex='0'+hex;
			}
		}
		else if (Type.equals("J_TYPE"))
		{
			while(hex.length()<7)
			{
				hex='0'+hex;
			}
		}
		else if (Type.equals("ToHex"))
		{
			while(hex.length()<8)
			{
				hex='0'+hex;
			}
		}
		return "0x"+hex;
	}
	//return R / J / I Type from Resources
	public String[] Get_InstrType(String hex)
	{
		String[][] RT=Resource_Table.HEX_MIPS_TABLE;
		for(int i =0; i<RT.length;i++)
		{
			if(hex.equals(RT[i][2]))
			{
				return RT[i];
			}
		}
		return null;
	}
	//return R type with Function from resources
	public String[] Get_R_Instr(String func)
	{
		String[][] RT=Resource_Table.HEX_MIPS_TABLE;
		for(int i =0; i<RT.length;i++)
		{
			if(func.equals(RT[i][3]))
			{
				return RT[i];
			}
		}
		return null;
	}
	public String Get_Register(String hex)
	{
		String[][] RT=Resource_Table.REGISTERS;
		for(int i =0; i<RT.length;i++)
		{
			if(hex.equals(RT[i][1]))
			{
				return RT[i][0];
			}
		}
		return "Register cant mapped";
	}
	//----------------------END----------------------
}
