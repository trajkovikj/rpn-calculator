package rpncalculator.backend.rpnmode;

import rpncalculator.backend.commandAndMemento.Command;
import rpncalculator.backend.commandAndMemento.CommandsEnum;
import rpncalculator.backend.singleton.Context;

public class ProgMode extends RpnModeState {

	// Isklucuvanje na odredeni komandi koi ne se 
	// izvrsuvaat na klasicen nacin (pr. PROG)
	// ili poradi potecijalno nastanuvanje na greska (EXE - beskonecen ciklus)
	// i prosleduvanje na komandata za ponatamosno procesiranje 
	@Override
	public void ProcessCommand(CommandsEnum cmd) {
		
		Context context = Context.getInstance();
		context.setErrMassage("");
		
		// Ne smee da se zacuva komandata EXE bidejki moze
		// da nastane problem t.e beskonecen ciklus		
		if(cmd == CommandsEnum.EXE) 
		{
			context.setErrMassage("Invalid Operation");	
			return;
		}
		
		// Dokolku sme pritisnale PROG, a veke se naogjame vo PROG sostojbata,
		// toa znaci deka sme zavrsile so Programiranjeto i 
		// treba da go vratime kalkulatorot vo osnovnata sostojba
		if(cmd == CommandsEnum.PROG)
		{
			context.setRpnMode(Context.BASIC_MODE);
			return;
		}
		
		// Dokolku NE se pritisnati PROG ili EXE tasterot,
		// togas treba da ja socuvame komandata vo listata na komandi za izvrsuvanje
		// koja se naodja vo Contextot
		
		context.getProgModeCommandList().add(cmd);
				
	}

	// Metod za prevzemanje na imeto na sostojbata na kalkulatorot
	// vo slucajov PROG
	@Override
	public String getModeName() {
		return "PROG";
	}

	@Override
	public Command CommandMapper(CommandsEnum cmd) {
		return null;
	}

}
