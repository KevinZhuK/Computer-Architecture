package Converter;

public class Resource_Table {
	public static final String[][] HEX_MIPS_TABLE =

		{
			/*{name},  {format},   {opcode(hex)}, {funct(hex)}, {format}, {Binary Format}*/
		    {"Add","R_TYPE", "0", "20", "Add  %3$s, %1$s, %2$s","000000%3$s%4$s%2$s00000%1$s"},
		    {"Addi","I_TYPE","8", null,"Addi  %2$s, %1$s, %3$s","%1$s%3$s%2$s%4$s"},
		    {"Addiu","I_TYPE", "9",null,"Addiu  %2$s, %1$s, %3$s","%1$s%3$s%2$s%4$s"},
		    {"Addu","R_TYPE", "0",  "21","Addu  %3$s, %1$s, %2$s","000000%3$s%4$s%2$s00000%1$s"},
		    {"And","R_TYPE", "0",  "24", "And  %3$s, %1$s, %2$s","000000%3$s%4$s%2$s00000%1$s"},
		    {"Addi","I_TYPE", "c", null,"Andi  %2$s, %1$s, %3$s","%1$s%3$s%2$s%4$s"},
		    {"Beq", "I_TYPE",  "4", null,"Beq  %1$s, %2$s, %3$s","%1$s%2$s%3$s%4$s"},
		    {"Bne", "I_TYPE",  "5", null,"Bne  %1$s, %2$s, %3$s","%1$s%2$s%3$s%4$s"},
		    {"J",   "J_TYPE",  "2", null,"J %1$s","%1$s%2$s"},
		    {"Jal", "J_TYPE",  "3", null,"Jal %1$s"},
		    {"Jr", "R_TYPE", "0","8","Jr  %1$s","000000%2$s000000000000000%1$s"},
		    {"Lbu",  "I_TYPE","24", null,"Lbu  %2$s, %3$s(%1$s)","%1$s%4$s%2$s%3$s"},
		    {"Lhu",  "I_TYPE","25", null,"Lhu  %2$s, %3$s(%1$s)"},
		    {"Ll",   "I_TYPE","30", null,"Ll  %2$s, %3$s(%1$s)"},
		    {"Lui",  "I_TYPE", "f", null,"Lui  %2$s, %3$s"},
		    {"Lw",    "I_TYPE", "23", null,"Lw  %2$s, %3$s(%1$s)","%1$s%4$s%2$s%3$s"},
		    {"Nor", "R_TYPE", "0", "27","Nor  %3$s, %1$s, %2$s","000000%3$s%4$s%2$s00000%1$s"},
		    {"Or",  "R_TYPE", "0","25","Or  %3$s, %1$s, %2$s","000000%3$s%4$s%2$s00000%1$s"},
		    {"Ori", "I_TYPE", "d",  null,"Ori  %2$s, %1$s, %3$s","%1$s%3$s%2$s%4$s"},
		    {"Slt",  "R_TYPE","0", "2a","Slt  %3$s, %1$s, %2$s","000000%3$s%4$s%2$s00000%1$s"},
		    {"Slti", "I_TYPE", "a", null,"Slti  %2$s, %1$s, %3$s","%1$s%3$s%2$s%4$s"},
		    {"Sltiu","I_TYPE", "b",null,"Sltiu  %2$s, %1$s, %3$s","%1$s%3$s%2$s%4$s"},
		    {"Sltu",  "R_TYPE", "0", "2b","Sltu  %3$s, %1$s, %2$s","000000%3$s%4$s%2$s00000%1$s"},
		    {"Sll",   "R_TYPE", "0", "0","Sll  %3$s, %2$s, %4$s","00000000000%3$s%2$s%4$s%1$s"},
		    {"Srl",    "R_TYPE", "0", "2","Srl  %3$s, %2$s, %4$s","00000000000%3$s%2$s%4$s%1$s"},
		    {"Sb",  "I_TYPE", "28",  null,"Sb  %2$s, %3$s(%1$s)"},
		    {"Sc",  "I_TYPE", "38", null,"Sc  %2$s, %3$s(%1$s)"},
		    {"Sh",  "I_TYPE", "29", null,"Sh  %2$s, %3$s(%1$s)"},
		    {"Sw",  "I_TYPE", "2b", null,"Sw  %2$s, %3$s(%1$s)"},
		    {"Sub",  "R_TYPE", "0",  "22","Sub  %3$s, %1$s, %2$s","000000%3$s%4$s%2$s00000%1$s"},
		    {"Subu", "R_TYPE",  "0",   "23","Subu  %3$s, %1$s, %2$s","000000%3$s%4$s%2$s00000%1$s"}

		};

		public static final String[][] REGISTERS =

		{

		    /*name      number(hex)*/

		    {"$zero","0"},
		    {"$at",  "1"},
		    {"$v0",  "2"},
		    {"$v1",  "3"},
		    {"$a0",  "4"},
		    {"$a1",  "5"},
		    {"$a2",  "6"},
		    {"$a3",  "7"},
		    {"$t0",  "8"},
		    {"$t1",  "9"},
		    {"$t2",  "a"},
		    {"$t3",  "b"},
		    {"$t4",  "c"},
		    {"$t5",  "d"},
		    {"$t6",  "e"},
		    {"$t7",  "f"},
		    {"$s0",  "10"},
		    {"$s1",  "11"},
		    {"$s2",  "12"},
		    {"$s3",  "13"},
		    {"$s4",  "14"},
		    {"$s5",  "15"},
		    {"$s6",  "16"},
		    {"$s7",  "17"},
		    {"$t8",  "18"},
		    {"$t9",  "19"},
		    {"$k0",  "1a"},
		    {"$k1",  "1b"},
		    {"$gp",  "1c"},
		    {"$sp",  "1d"},
		    {"$fp",  "1e"},
		    {"$ra",  "1f"}
		};


}





