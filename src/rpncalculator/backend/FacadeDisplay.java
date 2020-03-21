package rpncalculator.backend;

import java.util.Iterator;
import java.util.Stack;

import rpncalculator.backend.singleton.Context;

public class FacadeDisplay {

	// Metod koj sto ja zema porakata za greska 
	// dokolku nastanala takva vo kalkulatorot
	public static String getErrorMassage()
	{
		Context context = Context.getInstance();
		return context.getErrMassage();
	}
	
	// Metod koj sto ja zema listata na vrednosti od registrite
	public static double[] getRegisters()
	{
		Context context = Context.getInstance();
		return context.getRegisters();
	}
	
	// Metod so koj se zema porakata vo koja sostojba
	// se naodja kalkulatorot BASIC, PROG, STO ili RCL
	public static String getRpnModeState()
	{
		Context context = Context.getInstance();
		// return context.getRpnModeState().getName();
		return context.getRpnMode().getModeName();
	}
	
	// Metod so koj se zema porakata za prikaz na 
	// reprezentacijata na aglite Radijani ili Stepeni
	public static String getRadDegState()
	{
		Context context = Context.getInstance();
		return context.getRadDegStrategy().getName();
	}
	
	// Metod so koj se zema porakata za prikaz na 
	// trigonometriskite funkcii koi se aktivni: 
	// inverzni ili normalni
	public static String getInvOrNormalTrigonometryState()
	{
		Context context = Context.getInstance();
		return context.getTrigonometryStrategy().getName();
	}
	
	// Metod za zemanje na sodrzinata od rabotnata linija
	public static String getWorking()
	{
		Context context = Context.getInstance();
		return context.getWorkingAsString();
	}
		
	// Metod na zemanje na stekot na kalkulatorot
	public static Stack<String> getStack()
	{
		Context context = Context.getInstance();
		/*Stack<Double> stack = context.getStack();
		Stack<Double> stackTemp = (Stack<Double>) stack.clone();*/
		Stack<Double> stackTemp = context.getStack();
		
		// Go prevrtuvam Stack-ot za da moze WORKING delot da bide
		// na prvata pozicija na stack-ot, dodeka na vtorata ke bide 
		// prvoto nivo na stackot od RPN kalkulatorot, 
		// na tretot ke bide vtoroto od RPN Kalkulatorot, itn. 
		stackTemp = FlipStack(stackTemp);
		Stack<String> stackStringRepres = new Stack<String>();
		
	
		Iterator<Double> iterator = stackTemp.iterator();		
		while(iterator.hasNext()) stackStringRepres.push(iterator.next().toString());
		
		return stackStringRepres;		
		
	}
	
	// Pomosen metod za prevrtuvanje na stekot.
	// Se koristi vo metodot getStack()
	// IN: 1->2->3]
	// OUT: 3->2->1]
	private static Stack<Double> FlipStack(Stack<Double> stack)
	{
		Stack<Double> stackTemp = new Stack<Double>();
		
		Iterator<Double> iterator = stack.iterator();		
		while(iterator.hasNext()) stackTemp.push(iterator.next());
		
		return stackTemp;
	}
	
}
