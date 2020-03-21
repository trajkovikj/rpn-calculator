package rpncalculator.backend.commandAndMemento.commands;

import java.util.Stack;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.singleton.Context;

public class Enter implements Command {

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
		else if(stack.size() > 0)
		{
			double stackFirstElement = stack.peek();
			stack.push(stackFirstElement);
		}
		else context.setErrMassage("Too Few Arguments");

		
		return previousContextState;
	}

}
