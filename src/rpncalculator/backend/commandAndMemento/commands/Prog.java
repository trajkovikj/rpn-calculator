package rpncalculator.backend.commandAndMemento.commands;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.singleton.Context;

public class Prog implements Command {

	@Override
	public Memento Execute() {

		Context context = Context.getInstance();
		Memento previousContextState = context.StoreInMemento();

		context.setErrMassage("");
		
		context.getProgModeCommandList().clear();
		context.setRpnMode(Context.PROG_MODE);
	
		return previousContextState;
		
	}

}
