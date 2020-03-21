package rpncalculator.backend.commandAndMemento.commands;

import java.util.Arrays;
import java.util.Stack;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.singleton.Context;

public class Ac implements Command {

	@Override
	public Memento Execute() {
		Context context = Context.getInstance();
		Memento previousContextState = context.StoreInMemento();
		
		context.setErrMassage("");
		
		context.setWorking("");
		context.setStack(new Stack<Double>());
		Arrays.fill(context.getRegisters(), 0);	
		
		return previousContextState;
	}

}
