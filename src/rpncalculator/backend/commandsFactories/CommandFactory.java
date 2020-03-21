package rpncalculator.backend.commandsFactories;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.CommandsEnum;

public abstract class CommandFactory {
	
	public abstract Command getCommand(CommandsEnum cmd);
}
