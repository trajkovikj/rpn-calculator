package rpncalculator.backend.singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import rpncalculator.backend.commandAndMemento.CommandsEnum;
import rpncalculator.backend.commandAndMemento.Memento;
import rpncalculator.backend.radDegState.DegState;
import rpncalculator.backend.radDegState.RadDegState;
import rpncalculator.backend.radDegState.RadState;
import rpncalculator.backend.rpnmode.*;
import rpncalculator.backend.trigonometryStrategy.*;

public class Context {

	/* Ova e Contextot na RPN Kalkulatorot.
	 * Vo nego se cuva sostojbata na kalkulatorot (Stack-ot i drugite potrebni promenlivi).
	 * Realiziran e preku Singleton Pattern-ot bidejki e potrebna samo edna negova instanca
	 * */
	
	// Singleton Pattern-ot e realiziran na vakov nacin
	// za da imame spremna instanca uste na samiot start na aplikacijata.
	// Isto taka so ovoj nacin go resavame i problemot so povekje nitki kaj 
	// Singleton Pattern-ot (iako ova svojstvo ne ni e potrebno bidejki kalkulatorot 
	// raboti so samo edna nitka, no ne e na odmet da se ima...)
	private static Context contextInstance = new Context();
	
	private Context() 
	{ 
		this.working = "";
		this.stack = new Stack<Double>();
		this.radDegState = new RadState();
		this.trigonometryStrategy = new NormalTrigonometryFunctions();
		this.registers = new double[10];
		Arrays.fill(registers, 0);	
		this.rpnMode = new BasicMode(); 
		this.progModeCommandList = new ArrayList<CommandsEnum>();
	}
	
	public static Context getInstance()
	{
		return contextInstance;				
	}
	
	
	public static final RadDegState RADIAN_STATE = new RadState();
	public static final RadDegState DEGREES_STATE = new DegState();
	
	public static final RpnModeState BASIC_MODE = new BasicMode();
	public static final RpnModeState PROG_MODE = new ProgMode();
	public static final RpnModeState STO_MODE = new StoMode();
	public static final RpnModeState RCL_MODE = new RclMode();
	
	private String working;
	private Stack<Double> stack;
	private RadDegState radDegState;
	private TrigonometryStrategy trigonometryStrategy;
	private RpnModeState rpnMode;	
	private double[] registers;
	private ArrayList<CommandsEnum> progModeCommandList;
	private String errMassage;

	// Ovoj metod sluzi za da se socuva sostojbata na contextot
	// na kalkulatorot vo memento
	public Memento StoreInMemento()
	{
		Memento memento = new Memento();
		
		memento.setStack(stack);
		memento.setWorking(working);
		memento.setRadDegStrategy(radDegState);
		memento.setTrigonometryStrategy(trigonometryStrategy);
		memento.setRpnMode(rpnMode);
		memento.setRegisters(registers);
		memento.setProgModeCommandList(progModeCommandList);
		memento.setErrMassage(errMassage);		
		
		return memento;
	}
	
	
	// Ovoj metod sluzi za da se "raspakuva" (izvadi) 
	// sostojbata na contextot na kalkulatorot od memento objektot
	public void RestoreFromMemento(Memento memento)
	{
		working = memento.getWorking();
		stack = memento.getStack();
		radDegState = memento.getRadDegStrategy();
		trigonometryStrategy = memento.getTrigonometryStrategy();
		rpnMode = memento.getRpnMode();
		registers = memento.getRegisters();
		progModeCommandList = memento.getProgModeCommandList();
		errMassage = memento.getErrMassage();
	}
	
	
	/// Getters & Setters ///////////
	
	public String getWorkingAsString() {
		return working;
	}

	public void setWorking(String working) {
		this.working = working;
	}
	
	public double getWorkingAsDouble() {
		return Double.parseDouble(working);
	}

	public void setWorking(double working) {
		this.working = String.valueOf(working);
	}

	public Stack<Double> getStack() {
		return stack;
	}

	public void setStack(Stack<Double> stack) {
		this.stack = stack;
	}
	
	public RadDegState getRadDegStrategy() {
		return radDegState;
	}

	public void setRadDegStrategy(RadDegState radDegState) {
		this.radDegState = radDegState;
	}

	public TrigonometryStrategy getTrigonometryStrategy() {
		return trigonometryStrategy;
	}

	public void setTrigonometryVisitor(TrigonometryStrategy trigonometryStrategy) {
		this.trigonometryStrategy = trigonometryStrategy;
	}

	public RpnModeState getRpnMode() {
		return rpnMode;
	}

	public void setRpnMode(RpnModeState rpnMode) {
		this.rpnMode = rpnMode;
	}

	public double[] getRegisters() {
		return registers;
	}

	public void setRegisters(double[] registers) {
		this.registers = registers;
	}

	public ArrayList<CommandsEnum> getProgModeCommandList() {
		return progModeCommandList;
	}

	public void setProgModeCommandList(ArrayList<CommandsEnum> progModeCommandList) {
		this.progModeCommandList = progModeCommandList;
	}

	public String getErrMassage() {
		return errMassage;
	}

	public void setErrMassage(String errMassage) {
		this.errMassage = errMassage;
	}

	
}
