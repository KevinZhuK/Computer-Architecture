package Converter;

import java.util.Scanner;



//CS 3430 Conversion Program
//MIPS Converter Simulation based on below Web Site:
//https://www.eg.bucknell.edu/~csci320/mips_web/
//Data: Mar 28, 2016
//Version: 1.0


public class MIPS_Converter {
	
	
	public static void main(String[] args)
	{
		Converter C=new Converter();
		Scanner s = new Scanner(System.in); 
        System.out.println("-------Welcome to MIPS Converter-------"); 
        System.out.println("| ToHex translate Instruction to Hex   |"); 
        System.out.println("| ToInstr translate Hex to Instruction |");
        System.out.println("| Exit to exit the program             |");
        System.out.println("---------------------------------------");
        
        while (true) { 
        	    System.out.println("Please choose your mode (ToHex or ToInstr)!");
                String line = s.nextLine(); 
                if (line.equals("exit")) break;
                if(line.equals("ToHex"))
                {
                	System.out.println("Please enter your Instruction!");
                	line=s.nextLine();
                	line=line.replaceAll(","," ");
                	line=line.replaceAll("\\("," ");
                	line=line.replaceAll("\\)"," ");
                  	String Result=C.Instructions_to_Hex(line);
                	System.out.println("Translate to Hex >>>" + Result);
                	System.out.println("Translate to Binary >>>" + C.Hex_to_Binary(Result)); 
                	System.out.println("Now exit ToHex Mode!");
                }
                else if(line.equals("ToInstr"))
                {
                	System.out.println("Please enter your Hex!");
                	line=s.nextLine();
                	String Result=C.Hex_to_Instructions(line);
                	System.out.println("Translate to Instruction >>>" + Result);
                	System.out.println("Translate to Binary >>>" + C.Hex_to_Binary(line)); 
                	System.out.println("Now exit ToInstr Mode!");
                }
                else System.out.println("Wrong Instructions! Try Again!");  
        }
         
        System.out.println("Thanks for using!");
		s.close();
		
		
		//Test
		//R
		//String hexString = "0x014B4820";
		//R 2
		//String hexString = "0x01200008";
		//R 3
		//String hexString ="0x00095400";
		//I
		//String hexString = "0x214900FF";
		//I 2
		//String hexString = "0x8D0A0001";
		//J
		//String hexString = "0x082FFFFF";
		//String Result=C.Hex_to_Instructions(hexString);
		//System.out.println(Result);
		
		//opcode rs rt rd shamt funct
		//R1
		//funct rd rs rt
		//String Instruction = "Add $t1 $t2 $t3";
		//R2
		//funct rs
		//String Instruction = "JR $t1";
		//R3
		//funct rd, rt, shamt
		//String Instruction = "sll $t2 $t1 0x10";
		//I
		//String Instruction = "Addi $t1 $t2 0x00FF";
		//I 2
		//String Instruction = "Lw $t2 0x0001 $t0";
		//I 3
		//String Instruction = "beq $s1 $s2 0x00ff";
		//J 1
		//String Instruction = "J 0x0000000f";
		//String Result2=C.Instructions_to_Hex(Instruction);
		//System.out.println(Result2);
	}

}
