package rpncalculator.backend.commandAndMemento;

import java.util.ArrayList;
import java.util.Stack;

import rpncalculator.backend.radDegState.RadDegState;
import rpncalculator.backend.rpnmode.RpnModeState;
import rpncalculator.backend.trigonometryStrategy.*;

public class Memento {

	private String working;
	private Stack<Double> stack;
	private RadDegState radDegState;
	private TrigonometryStrategy trigonometryStrategy;
	private RpnModeState rpnMode;
	private double[] registers;
	private ArrayList<CommandsEnum> progModeCommandList;
	private String errMassage;
	
	
	public Memento() {  }
	
	public Memento(String working, Stack<Double> stack) {
		this.working = working;
		this.stack = stack;
	}
		
	
	// Getters & Setters
	
	public String getWorking() {
		return working;
	}
	public void setWorking(String working) {
		this.working = working;
	}
	public Stack<Double> getStack() {
		return (Stack<Double>) stack.clone();
	}
	public void setStack(Stack<Double> stack) {
		this.stack = (Stack<Double>) stack.clone();
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

	public void setTrigonometryStrategy(TrigonometryStrategy trigonometryStrategy) {
		this.trigonometryStrategy = trigonometryStrategy;
	}
	
	public RpnModeState getRpnMode() {
		return rpnMode;
	}

	public void setRpnMode(RpnModeState rpnMode) {
		this.rpnMode = rpnMode;
	}
	
	public double[] getRegisters() {
		return registers.clone();
	}

	public void setRegisters(double[] registers) {
		this.registers = registers.clone();
	}

	public ArrayList<CommandsEnum> getProgModeCommandList() {
		return (ArrayList<CommandsEnum>) progModeCommandList.clone();
	}

	public void setProgModeCommandList(ArrayList<CommandsEnum> progModeCommandList) {
		this.progModeCommandList = (ArrayList<CommandsEnum>) progModeCommandList.clone();
	}
	
	public String getErrMassage() {
		return errMassage;
	}

	public void setErrMassage(String errMassage) {
		this.errMassage = errMassage;
	}
}
