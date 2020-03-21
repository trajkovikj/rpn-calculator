package rpncalculator.backend.commandAndMemento.commands;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.singleton.Context;

public class Dot implements Command {

	@Override
	public Memento Execute() {
		Context context = Context.getInstance();
		Memento previousContextState = context.StoreInMemento();
		
		context.setErrMassage("");
		
		String working = context.getWorkingAsString();
		
		if(working.isEmpty()) working = "0.";
		else if(working.contains(".")) return previousContextState;
		else working += ".";
		
		context.setWorking(working);
		
		return previousContextState;
	}

}
