package rpncalculator.backend.commandAndMemento.commands;

import java.util.Stack;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.singleton.Context;

public class Chs implements Command {

	@Override
	public Memento Execute() {
		
		Context context = Context.getInstance();
		Memento previousContextState = context.StoreInMemento();

		Stack<Double> stack = context.getStack();
		context.setErrMassage("");
		
		if(!context.getWorkingAsString().isEmpty())
		{
			String working = context.getWorkingAsString();
			
			if(working.charAt(0) == '-') working = working.substring(1);
			else working = "-" + working;
			
			context.setWorking(working);
		}
		else if(stack.size() > 0)
		{
			double stackFirstElement = stack.pop();
			stackFirstElement *= -1;
			stack.push(stackFirstElement);
		}
		else context.setErrMassage("Too Few Arguments");
		
		return previousContextState;
	}

}
