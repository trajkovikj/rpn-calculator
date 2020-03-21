package rpncalculator.backend.commandsFactories;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.CommandsEnum;
import rpncalculator.backend.commandAndMemento.commands.*;

//Fabrika za generiranje na komandi za STO sostojbata na kalkulatorot
public class StoCommandFactory extends CommandFactory {

	@Override
	public Command getCommand(CommandsEnum cmd) {
		
		switch(cmd)
		{
			case Number0 : return new STONumber0();
			case Number1 : return new STONumber1();
			case Number2 : return new STONumber2();
			case Number3 : return new STONumber3();
			case Number4 : return new STONumber4();
			case Number5 : return new STONumber5();
			case Number6 : return new STONumber6();
			case Number7 : return new STONumber7();
			case Number8 : return new STONumber8();
			case Number9 : return new STONumber9();			
		
			default : return null;
		}
		
	}

}
