package rpncalculator.backend.commandAndMemento;

import rpncalculator.backend.singleton.Context;

public class RegisterHelper {

	// Metod koj se koristi vo STO sostojba na kalkulatorot.
	// Se koristi za zapisuvanje na prvata vrednost na 
	// stekot na prosledeniot index vo registarot
	public static Memento writeToRegister(int registerIndex)
	{
		Context context = Context.getInstance();
		Memento previousContextState = context.StoreInMemento();
		
		context.setErrMassage("");
		
		double number = context.getStack().peek();
		double[] registers = context.getRegisters();
		
		registers[registerIndex] = number;
		context.setRegisters(registers);
		context.setRpnMode(Context.BASIC_MODE);	
		
		return previousContextState;		
	}
	
	// Metod koj se koristi vo RCL sostojba na kalkulatorot.
	// Se koristi za iscituvanje vrednosta od registarot 
	// spored prosledeniot index i nejzino zapisuvanje na vrvot na stekot
	public static Memento readFromRegister(int registerIndex)
	{
		Context context = Context.getInstance();
		Memento previousContextState = context.StoreInMemento();
		
		context.setErrMassage("");
		
		double number;
		double[] registers = context.getRegisters();
		
		number = registers[registerIndex];
		context.getStack().push(number);
		context.setRpnMode(Context.BASIC_MODE);
		
		return previousContextState;
	}
	
}
