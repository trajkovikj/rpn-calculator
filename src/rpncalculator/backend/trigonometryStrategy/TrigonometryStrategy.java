package rpncalculator.backend.trigonometryStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class TrigonometryStrategy {

	public abstract void SinPressed();
	public abstract void CosPressed();
	public abstract void TngPressed();
	public abstract String getName();
	
	// Metod za zaokruzuvanje na broevite.
	// Potreben pri rezultatite sto se vrakjaat od
	// izvrsuvanjeto na trigonometriskite fnkcii.
	protected static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
