package rpncalculator.backend.commandAndMemento;

// Genericka klasa za oformuvanje na parovi od objekti od razlicni klasi
public class Pair<T, U> {

	private T First;
	private U Second;
	
	
	public Pair() { }
	
	public Pair(T first, U second) 
	{
		this.First = first;
		this.Second = second;
	}
	
	
	public T getFirst() {
		return First;
	}

	public void setFirst(T first) {
		First = first;
	}

	public U getSecond() {
		return Second;
	}

	public void setSecond(U second) {
		Second = second;
	}

}
