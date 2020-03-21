package rpncalculator.backend.commandAndMemento.commands;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.commandAndMemento.RegisterHelper;

public class STONumber9 implements Command {

	@Override
	public Memento Execute() {
		
		int registerIndex = 9;			
		return RegisterHelper.writeToRegister(registerIndex);
	}

}
