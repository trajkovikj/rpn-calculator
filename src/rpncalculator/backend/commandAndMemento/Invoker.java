package rpncalculator.backend.commandAndMemento;

import java.util.Stack;

import rpncalculator.backend.singleton.Context;

/*
 * Invoker klasata e klasata zadolzena da gi izvrsuva komandite, a voedno i da
 * izvrsi Undo, Redo dokolku e toa potrebno.
 * Pokraj toa sto ovaa klasa e reprezent na Invoker klasata od Command Patternot,
 * taa ja pretstavuva vo isto vreme i CareTaker klasata od Memento Patternot, koja e 
 * zadolzena za menadziranjeto na memento objektite.
 * 
 * */

public class Invoker {

	private Stack<Pair<Command, Memento>> UndoStack = new Stack<Pair<Command, Memento>>();		
	private Stack<Pair<Command, Memento>> RedoStack = new Stack<Pair<Command, Memento>>();
	
	// Metod za izvrsuvanje na prosledenata komanda
	public void ExecuteCommand(Command commandObject)
	{
		UndoStack.push(new Pair<Command, Memento>(commandObject, commandObject.Execute()));
		RedoStack.clear();
	}
	
	// Metod za proveka dali e vozmozno Undo
	public boolean UndoPossible() { return !UndoStack.isEmpty(); }
	
	// Metod za proveka dali e vozmozno Redo
	public boolean RedoPossible() { return !RedoStack.isEmpty(); }
	
	// Metod za povtorno izvrsuvanje na komandata koja bila vratena nazad
	public void Redo() 
	{
		if (RedoPossible()) {
			Pair<Command, Memento> pair = RedoStack.pop();
			Command cmd = pair.getFirst();
			UndoStack.push(new Pair<Command, Memento>(cmd, cmd.Execute()));
		}	
	} 
	
	// Metod za vracanje na veke izvrsena komanda
	public void Undo() 
	{
		if (UndoPossible())
		{
			Pair<Command, Memento> pair = UndoStack.pop();
			Command cmd = pair.getFirst();
			Memento mem = pair.getSecond();
			Context context = Context.getInstance();
			context.RestoreFromMemento(mem);
			RedoStack.push(new Pair<Command, Memento>(cmd, mem));
		} 
	}
	
	
}
