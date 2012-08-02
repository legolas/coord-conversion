package nl.endofdullart.coordinate_conversion.model;

/**
 * The {@link MinDecCoordinate} class represents a coordinate formatted with the
 * Decimal Degrees format: {@code N 12.345678 E 009.87654}
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
		minutes = (int) coord;
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
		return minutes;
	}

	@Override
	public String toString() {
		return String.format("%d %f", getDegrees(), getMinutes());
	}
}
