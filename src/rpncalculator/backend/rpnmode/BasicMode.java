package rpncalculator.backend.rpnmode;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.CommandsEnum;
import rpncalculator.backend.commandsFactories.BasicCommandFactory;
import rpncalculator.backend.singleton.Context;

public class BasicMode extends RpnModeState {

	// Isklucuvanje na odredeni komandi koi ne se 
	// izvrsuvaat na klasicen nacin (pr. Undo i Redo)
	// i prosleduvanje na komandata za ponatamosno procesiranje 
	@Override
	public void ProcessCommand(CommandsEnum cmd) {
		
		if(cmd == CommandsEnum.Undo) invoker.Undo();	
		else if(cmd == CommandsEnum.Redo) invoker.Redo();		
		else CommandPressed(cmd);
		
	}

	
	// Metod za izvrsuvanje na komandata
	private void CommandPressed(CommandsEnum cmdEnum)
	{
		Command cmd = CommandMapper(cmdEnum);
		if(cmd == null) 
		{
			Context context = Context.getInstance();
			context.setErrMassage("Invalid Operation");	
			return;
		}
		invoker.ExecuteCommand(cmd);
	}
	
	
	// Metod za mapiranje na enumeracija vo Command objekt
	// koristejki ja soodvetnata fabrika za komandi, 
	// za soodvetnata sostojba na kalkulatorot 
	@Override
	public Command CommandMapper(CommandsEnum cmdEnum) {
		commandFactory = new BasicCommandFactory(); 
		return commandFactory.getCommand(cmdEnum);
	}
		
	
	// Metod za prevzemanje na imeto na sostojbata na kalkulatorot
	// vo slucajov BASIC
	@Override
	public String getModeName() {
		return "BASIC";
	}

}
