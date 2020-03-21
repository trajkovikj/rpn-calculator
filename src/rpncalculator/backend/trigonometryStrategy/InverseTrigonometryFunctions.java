package rpncalculator.backend.trigonometryStrategy;

import java.util.Stack;

import rpncalculator.backend.radDegState.RadDegState;
import rpncalculator.backend.singleton.Context;

public class InverseTrigonometryFunctions extends TrigonometryStrategy {

	int numberOfDecimalPlacesToRound = 5;
	
	// Metod koj presmetuva arcsin funkcijata vrz prviot element na stekot
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
				
		double result = Math.asin(stackFirstElement); 
		result = radDegState.CalculateAngleOutputRepresentation(result);
		result = round(result, numberOfDecimalPlacesToRound);
		
		stack.push(result);
	}

	// Metod koj presmetuva arccos funkcijata vrz prviot element na stekot
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
				
		double result = Math.acos(stackFirstElement);
		result = radDegState.CalculateAngleOutputRepresentation(result);
		result = round(result, numberOfDecimalPlacesToRound);
		
		stack.push(result);
	}

	// Metod koj presmetuva arctng funkcijata vrz prviot element na stekot
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
				
		double result = Math.atan(stackFirstElement); 
		result = radDegState.CalculateAngleOutputRepresentation(result);
		result = round(result, numberOfDecimalPlacesToRound);
		
		stack.push(result);
	}

	// Metod koj go vrakja imeto na iskoristenata  
	// strategija za trig. funkcii t.e INVERS
	@Override
	public String getName() {
		return "INVERS";
	}
	
	
}
