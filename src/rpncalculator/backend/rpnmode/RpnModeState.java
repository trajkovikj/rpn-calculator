package rpncalculator.backend.rpnmode;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.CommandsEnum;
import rpncalculator.backend.commandAndMemento.Invoker;
import rpncalculator.backend.commandsFactories.CommandFactory;

public abstract class RpnModeState {
	
	protected static Invoker invoker = new Invoker();
	protected static CommandFactory commandFactory;
	
	public abstract void ProcessCommand(CommandsEnum cmd);	
	public abstract Command CommandMapper(CommandsEnum cmdEnum);
	public abstract String getModeName();
	
}


