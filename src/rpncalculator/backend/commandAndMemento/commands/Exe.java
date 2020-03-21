package rpncalculator.backend.commandAndMemento.commands;

import java.util.ArrayList;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.CommandsEnum;
import rpncalculator.backend.commandAndMemento.Invoker;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.rpnmode.RpnModeState;
import rpncalculator.backend.singleton.Context;

public class Exe implements Command {

	@Override
	public Memento Execute() {

		Context context = Context.getInstance();
		Memento previousContextState = context.StoreInMemento();

		context.setErrMassage("");
		
		ArrayList<CommandsEnum> commands = context.getProgModeCommandList();
		
		Invoker localInvoker = new Invoker();
		
		for (int i = 0; i < commands.size(); i++) {
			RpnModeState rpnMode = context.getRpnMode();
			Command cmd = rpnMode.CommandMapper(commands.get(i));
			localInvoker.ExecuteCommand(cmd);
		}			
		
		return previousContextState;
		
	}	

}
