package rpncalculator.backend.commandAndMemento.commands;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.singleton.Context;
import rpncalculator.backend.trigonometryStrategy.*;

public class Inv implements Command {

	@Override
	public Memento Execute() {
		
		Context context = Context.getInstance();
		Memento previousContextState = context.StoreInMemento();

		if(context.getTrigonometryStrategy().getName().equalsIgnoreCase("INVERS"))
			context.setTrigonometryVisitor(new NormalTrigonometryFunctions());
		else
			context.setTrigonometryVisitor(new InverseTrigonometryFunctions());
		
		return previousContextState;
	}

}
