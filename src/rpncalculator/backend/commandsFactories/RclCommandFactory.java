package rpncalculator.backend.commandsFactories;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.CommandsEnum;
import rpncalculator.backend.commandAndMemento.commands.*;

//Fabrika za generiranje na komandi za RCL sostojbata na kalkulatorot
public class RclCommandFactory extends CommandFactory {

	@Override
	public Command getCommand(CommandsEnum cmd) {

		switch(cmd)
		{
			case Number0 : return new RCLNumber0();
			case Number1 : return new RCLNumber1();
			case Number2 : return new RCLNumber2();
			case Number3 : return new RCLNumber3();
			case Number4 : return new RCLNumber4();
			case Number5 : return new RCLNumber5();
			case Number6 : return new RCLNumber6();
			case Number7 : return new RCLNumber7();
			case Number8 : return new RCLNumber8();
			case Number9 : return new RCLNumber9();			
		
			default : return null;
		}
		
	}

	
}
