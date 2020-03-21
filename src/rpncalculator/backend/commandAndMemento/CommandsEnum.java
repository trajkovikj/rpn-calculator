package rpncalculator.backend.commandAndMemento;

// Enumeracija na site komandi
public enum CommandsEnum {

	Number0(0),
	Number1(1),
	Number2(2),
	Number3(3),
	Number4(4),
	Number5(5),
	Number6(6),
	Number7(7),
	Number8(8),
	Number9(9),
	Dot(10),
	Enter(11),
	Undo(12),
	Redo(13),
	Swap(14),
	Drop(15),
	AC(16),
	CHS(17),
	Add(18),
	Sub(19),
	Div(20),
	Mul(21),
	RadDeg(22),
	Inv(23),
	Sin(24),
	Cos(25),
	Tng(26),
	STO(27),
	RCL(28),
	PROG(29),
	EXE(30);
	
	
	private final int cmd;
	
	CommandsEnum(int cmd) {	this.cmd = cmd;	}
	
	public int getCommand() { return this.cmd; }
            
}
