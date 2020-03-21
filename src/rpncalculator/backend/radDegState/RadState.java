package rpncalculator.backend.radDegState;

public class RadState implements RadDegState {

	// Kaj site programski jazici (fklucuvajki ja i Java-ta)
	// trigonometriskite funkcii rabotat so radijani.
	
	// Ovoj metod samo go prosleduva agolot ponataka za
	// da se izvrsat trigonometriskite funkcii (sin, cos, tng),
	// bidejki negovata reprezentacija e veke vo radijani	
	@Override
	public double CalculateAngleInputRepresentation(double angle) {
		return angle;
	}

	// Ovoj metod samo go prosleduva izlezot od inverzinite
	// trigonometriski funkcii (arcsin, arccos,...), cija reprezentacija e vo Radijani
	@Override
	public double CalculateAngleOutputRepresentation(double angle) {
		return angle;
	}

	// Metod za zemanje na imeto na strategijata za reprezentacija na aglite
	@Override
	public String getName() {
		return "RAD";
	}
}
