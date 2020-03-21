package rpncalculator.backend.commandAndMemento.commands;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.commandAndMemento.RegisterHelper;

public class RCLNumber0 implements Command {

	@Override
	public Memento Execute() {

		int registerIndex = 0;			
		return RegisterHelper.readFromRegister(registerIndex);
		
	}

}