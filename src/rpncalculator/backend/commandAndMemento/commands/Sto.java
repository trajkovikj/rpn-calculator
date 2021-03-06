package rpncalculator.backend.commandAndMemento.commands;

import java.util.Stack;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.singleton.Context;

public class Sto implements Command {

	@Override
	public Memento Execute() {

		Context context = Context.getInstance();
		Memento previousContextState = context.StoreInMemento();

		Stack<Double> stack = context.getStack();
		context.setErrMassage("");
		
		if(!context.getWorkingAsString().isEmpty())
		{
			double working = context.getWorkingAsDouble();
			stack.push(working);
			context.setWorking("");
		}
		
		int neededOperationOperandsCount = 1;
		
		if(stack.size() < neededOperationOperandsCount)
		{
			context.setErrMassage("Too Few Arguments");
			return previousContextState;
		}
		
		context.setRpnMode(Context.STO_MODE);
		
		return previousContextState;
		
	}

}