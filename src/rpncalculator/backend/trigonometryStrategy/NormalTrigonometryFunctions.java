package rpncalculator.backend.trigonometryStrategy;

import java.util.Stack;

import rpncalculator.backend.radDegState.RadDegState;
import rpncalculator.backend.singleton.Context;

public class NormalTrigonometryFunctions extends TrigonometryStrategy {

	int numberOfDecimalPlacesToRound = 11;
	
	// Metod koj presmetuva sin funkcijata vrz prviot element na stekot
	@Override
	public void SinPressed() {
		
		Context context = Context.getInstance();

		Stack<Double> stack = context.getStack();
		context.setErrMassage("");
		
		if(!context.getWorkingAsString().isEmpty())
		{
			double working = context.getWorkingAsDouble();
			stack.push(working);
			context.setWorking("");
		}
		
		int operationOperandsCount = 1;
		
		if(stack.size() < operationOperandsCount)
		{
			context.setErrMassage("Too Few Arguments");
			return;
		}
		
		double stackFirstElement = stack.pop();

		// Get RAD/DEG State
		RadDegState radDegState = context.getRadDegStrategy();
				
		double number = radDegState.CalculateAngleInputRepresentation(stackFirstElement);
		double result = Math.sin(number); 
		result = round(result, numberOfDecimalPlacesToRound);
		
		stack.push(result);
	}

	// Metod koj presmetuva cos funkcijata vrz prviot element na stekot
	@Override
	public void CosPressed() {

		Context context = Context.getInstance();

		Stack<Double> stack = context.getStack();
		context.setErrMassage("");
		
		if(!context.getWorkingAsString().isEmpty())
		{
			double working = context.getWorkingAsDouble();
			stack.push(working);
			context.setWorking("");
		}
		
		int operationOperandsCount = 1;
		
		if(stack.size() < operationOperandsCount)
		{
			context.setErrMassage("Too Few Arguments");
			return;
		}
		
		double stackFirstElement = stack.pop();

		// Get RAD/DEG State
		RadDegState radDegState = context.getRadDegStrategy();
				
		double number = radDegState.CalculateAngleInputRepresentation(stackFirstElement);
		double result = Math.cos(number);
		result = round(result, numberOfDecimalPlacesToRound);
		
		stack.push(result);
	}

	// Metod koj presmetuva tng funkcijata vrz prviot element na stekot
	@Override
	public void TngPressed() {

		Context context = Context.getInstance();

		Stack<Double> stack = context.getStack();
		context.setErrMassage("");
		
		if(!context.getWorkingAsString().isEmpty())
		{
			double working = context.getWorkingAsDouble();
			stack.push(working);
			context.setWorking("");
		}
		
		int operationOperandsCount = 1;
		
		if(stack.size() < operationOperandsCount)
		{
			context.setErrMassage("Too Few Arguments");
			return;
		}
		
		double stackFirstElement = stack.pop();

		// Get RAD/DEG State
		RadDegState radDegState = context.getRadDegStrategy();
				
		double number = radDegState.CalculateAngleInputRepresentation(stackFirstElement);
		double result = Math.tan(number);
		result = round(result, numberOfDecimalPlacesToRound);
		
		stack.push(result);
	}

	// Metod koj go vrakja imeto na iskoristenata  
	// strategija za trig. funkcii t.e NORMAL
	@Override
	public String getName() {
		return "NORMAL";
	}

	
	
}