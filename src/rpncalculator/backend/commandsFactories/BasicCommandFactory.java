package rpncalculator.backend.commandsFactories;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.CommandsEnum;
import rpncalculator.backend.commandAndMemento.commands.*;

// Fabrika za generiranje na komandi za Basic sostojbata na kalkulatorot
public class BasicCommandFactory extends CommandFactory {

	@Override
	public Command getCommand(CommandsEnum cmd) {
				
		switch(cmd)
		{
			case Number0 : return new Number0();
			case Number1 : return new Number1();
			case Number2 : return new Number2();
			case Number3 : return new Number3();
			case Number4 : return new Number4();
			case Number5 : return new Number5();
			case Number6 : return new Number6();
			case Number7 : return new Number7();
			case Number8 : return new Number8();
			case Number9 : return new Number9();
			case Dot : return new Dot();
			case Enter : return new Enter();			
			case Swap : return new Swap();
			case Drop : return new Drop();
			case AC : return new Ac();
			case CHS : return new Chs();
			case Add : return new Add();
			case Sub : return new Sub();
			case Div : return new Div();
			case Mul : return new Mul();
			case RadDeg : return new RadDeg();
			case Inv : return new Inv();
			case Sin : return new Sin();
			case Cos : return new Cos();
			case Tng : return new Tng();
			case STO : return new Sto();
			case RCL : return new Rcl();
			case PROG : return new Prog();
			case EXE : return new Exe();
		
			default : return null;
		}
	}

}
