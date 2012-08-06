package nl.endofdullart.coordinate_conversion.model;

/**
 * The {@link MinDecCoordinate} class represents a coordinate formatted with the
 * MinDec Degrees format: {@code N 12 34.678 E 009 87.654}
 * 
 * @author MD80469
 * 
 */
public class MinDecCoordinate {

	private int degrees;
	private double minutes;

	public MinDecCoordinate(int degrees, double minutes) {
		this.degrees = degrees;
		this.minutes = minutes;
	}

	public MinDecCoordinate(double coord) {
		degrees = (int) coord;
		double fractal = coord % 1;
		coord = fractal * 60;
		// Only 3 digits
		minutes = coord;
	}

	public double getRawCoordinate() {
		// Add the minutes as a fraction to the degrees and return the
		// result
		return degrees + minutes / 60;
	}

	public int getDegrees() {
		return degrees;
	}

	public double getMinutes() {
		return (double) Math.round(minutes * 1000) / 1000;
	}

	@Override
	public String toString() {
		return String.format("%d %.3f", getDegrees(), getMinutes());
	}
}
