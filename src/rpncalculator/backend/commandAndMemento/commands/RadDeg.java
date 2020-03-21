package rpncalculator.backend.commandAndMemento.commands;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.radDegState.DegState;
import rpncalculator.backend.radDegState.RadState;
import rpncalculator.backend.singleton.Context;

public class RadDeg implements Command {

	@Override
	public Memento Execute() {
		
		Context context = Context.getInstance();
		Memento previousContextState = context.StoreInMemento();

		if(context.getRadDegStrategy().getName().equalsIgnoreCase("RAD"))
			context.setRadDegStrategy(new DegState());
		else
			context.setRadDegStrategy(new RadState());
		
		return previousContextState;
	}

}
