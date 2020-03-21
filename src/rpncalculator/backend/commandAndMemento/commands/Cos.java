package rpncalculator.backend.commandAndMemento.commands;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.singleton.Context;
import rpncalculator.backend.trigonometryStrategy.TrigonometryStrategy;

public class Cos implements Command {
	
	@Override
	public Memento Execute() {
		
		Context context = Context.getInstance();
		Memento previousContextState = context.StoreInMemento();

		context.setErrMassage("");
		
		TrigonometryStrategy trigStrategy = context.getTrigonometryStrategy();
		trigStrategy.CosPressed();	
		
		return previousContextState;
	}
		

}
