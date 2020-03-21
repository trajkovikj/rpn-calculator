package rpncalculator.backend.commandAndMemento.commands;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.singleton.Context;

public class Number3 implements Command {

	@Override
	public Memento Execute() {
		Context context = Context.getInstance();
		Memento previousContextState = context.StoreInMemento();
		
		context.setErrMassage("");
		
		String working = context.getWorkingAsString();
		working += "3";
		
		context.setWorking(working);
		
		return previousContextState;
	}

}
