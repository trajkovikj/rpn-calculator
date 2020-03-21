package rpncalculator.backend;

import rpncalculator.backend.commandAndMemento.*;
import rpncalculator.backend.rpnmode.RpnModeState;
import rpncalculator.backend.singleton.Context;

public class FacadeButtons {
	
	// Pomosen metod za prosleduvanje na komandata do 
	// globalnata sostojba (BASIC, PROG, ...)
	private static void CommandPressed(CommandsEnum cmd)
	{
		Context context = Context.getInstance();
		RpnModeState rpnMode = context.getRpnMode();
		rpnMode.ProcessCommand(cmd);
	}
	
	// Sekoj nadolu, sluzi za povikuvanje na komandata
	// pritisnata od soodvetniot tastter na korisnickiot interfejs

	public static void Number0Pressed()
	{
		CommandPressed(CommandsEnum.Number0);
	}
	
	public static void Number1Pressed()
	{
		CommandPressed(CommandsEnum.Number1);
	}
	
	public static void Number2Pressed()
	{
		CommandPressed(CommandsEnum.Number2);
	}
	
	public static void Number3Pressed()
	{
		CommandPressed(CommandsEnum.Number3);
	}
	
	public static void Number4Pressed()
	{
		CommandPressed(CommandsEnum.Number4);
	}
	
	public static void Number5Pressed()
	{
		CommandPressed(CommandsEnum.Number5);
	}
	
	public static void Number6Pressed()
	{
		CommandPressed(CommandsEnum.Number6);
	}
	
	public static void Number7Pressed()
	{
		CommandPressed(CommandsEnum.Number7);
	}
	
	public static void Number8Pressed()
	{
		CommandPressed(CommandsEnum.Number8);
	}
	
	public static void Number9Pressed()
	{
		CommandPressed(CommandsEnum.Number9);
	}
	
	public static void DotPressed()
	{
		CommandPressed(CommandsEnum.Dot);
	}
	
	public static void AddPressed()
	{
		CommandPressed(CommandsEnum.Add);
	}
	
	public static void SubPressed()
	{
		CommandPressed(CommandsEnum.Sub);
	}
	
	public static void MulPressed()
	{
		CommandPressed(CommandsEnum.Mul);
	}
	
	public static void DivPressed()
	{
		CommandPressed(CommandsEnum.Div);
	}
	
	public static void ChsPressed()
	{
		CommandPressed(CommandsEnum.CHS);
	}
	
	public static void SwapPressed()
	{
		CommandPressed(CommandsEnum.Swap);
	}
	
	public static void DropPressed()
	{
		CommandPressed(CommandsEnum.Drop);
	}
	
	public static void AcPressed()
	{
		CommandPressed(CommandsEnum.AC);
	}
	
	public static void EnterPressed()
	{
		CommandPressed(CommandsEnum.Enter);
	}
	
	public static void UndoPressed()
	{
		CommandPressed(CommandsEnum.Undo);
	}
	
	public static void RedoPressed()
	{
		CommandPressed(CommandsEnum.Redo);
	}
	
	public static void StoPressed()
	{
		CommandPressed(CommandsEnum.STO);
	}
	
	public static void RclPressed()
	{
		CommandPressed(CommandsEnum.RCL);
	}
	
	public static void ProgPressed()
	{
		CommandPressed(CommandsEnum.PROG);
	}
	
	public static void ExePressed()
	{
		CommandPressed(CommandsEnum.EXE);
	}
	
	public static void RadDegPressed()
	{
		CommandPressed(CommandsEnum.RadDeg);
	}
	
	public static void InvPressed()
	{
		CommandPressed(CommandsEnum.Inv);
	}
	
	public static void SinPressed()
	{
		CommandPressed(CommandsEnum.Sin);
	}
	
	public static void CosPressed()
	{
		CommandPressed(CommandsEnum.Cos);
	}
	
	public static void TngPressed()
	{
		CommandPressed(CommandsEnum.Tng);
	}
		
}
