package rpncalculator.backend.commandAndMemento;

// Interfejs za polimorfna (uniformna) reprezentacija na komanda
public interface Command {

	public Memento Execute();
	
}
