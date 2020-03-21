package rpncalculator.backend.commandAndMemento.commands;

import java.util.Stack;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.singleton.Context;

public class Div implements Command {

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
		
		int operationOperandsCount = 2;
		
		if(stack.size() < operationOperandsCount)
		{
			context.setErrMassage("Too Few Arguments");
			return previousContextState;
		}
		
		if(stack.peek() == 0.0)
		{
			context.setErrMassage("Division\n By Zero");
			return previousContextState;
		}
		
		double stackFirstElement = stack.pop();
		double stackSecondElement = stack.pop();
		double result = stackSecondElement / stackFirstElement;
		stack.push(result);
		
		return previousContextState;
	}

}
