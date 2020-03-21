package rpncalculator.backend.commandAndMemento.commands;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.commandAndMemento.RegisterHelper;

public class RCLNumber6 implements Command {

	@Override
	public Memento Execute() {

		int registerIndex = 6;			
		return RegisterHelper.readFromRegister(registerIndex);
		
	}

}
