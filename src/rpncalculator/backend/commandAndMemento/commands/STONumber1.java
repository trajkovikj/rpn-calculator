package rpncalculator.backend.commandAndMemento.commands;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.commandAndMemento.RegisterHelper;

public class STONumber1 implements Command {

	@Override
	public Memento Execute() {
		
		int registerIndex = 1;			
		return RegisterHelper.writeToRegister(registerIndex);
	}

}
