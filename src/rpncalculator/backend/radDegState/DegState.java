package rpncalculator.backend.radDegState;

public class DegState implements RadDegState {

	// Metod za konverzija na stepenite vo radijani kako bi mozele 
	// da se izvrsat trigonometriskite funkcii (sin, cos, tng).
	// Ova e potrebno bidejki kaj site programski jazici (fklucuvajki ja i Java-ta)
	// trigonometriskite funkcii rabotat so radijani.
	@Override
	public double CalculateAngleInputRepresentation(double angle) {
		return Math.toRadians(angle);
	}

	// Metod za konverzija na radijanite vo stepeni od izlezite na
	// inverzinite trigonometriski funkcii (arcsin, arccos, arctng).
	// Ova e potrebno bidejki kaj site programski jazici (fklucuvajki ja i Java-ta)
	// trigonometriskite funkcii rabotat so radijani.
	@Override
	public double CalculateAngleOutputRepresentation(double angle) {
		return Math.toDegrees(angle);
	}

	// Metod za zemanje na imeto na strategijata za reprezentacija na aglite
	@Override
	public String getName() {
		return "DEG";
	}

}
