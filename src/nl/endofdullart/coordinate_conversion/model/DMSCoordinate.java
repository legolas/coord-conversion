package nl.endofdullart.coordinate_conversion.model;

/**
 * The {@link DMSCoordinate} class represents a coordinate formatted with the
 * Degrees Minutes Seconds format: {@code N 12 34 56.78 E 009 87 65.43}
 * 
 * @author MD80469
 * 
 */
public class DMSCoordinate {

	private final int degrees;
	private final int minutes;
	private final double seconds;

	public DMSCoordinate(int degrees, int minutes, double seconds) {
		this.degrees = degrees;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public DMSCoordinate(double coord) {
		degrees = (int) coord;
		double fractal = coord % 1;
		coord = fractal * 60;
		minutes = (int) coord;
		fractal = coord % 1;
		seconds = fractal * 60;
	}

	public double getRawCoordinate() {
		// Add the minutes to the seconds
		double minutesAndSeconds = getSeconds() + 60 * getMinutes();

		// Add the total seconds as a fraction to the degrees and return the
		// result
		return degrees + minutesAndSeconds / 3600;
	}

	public int getDegrees() {
		return degrees;
	}

	public int getMinutes() {
		return minutes;
	}

	public double getSeconds() {
		return (double) Math.round(seconds * 100) / 100;
	}

	@Override
	public String toString() {
		return String.format("%d %d %.2f", getDegrees(), getMinutes(),
				getSeconds());
	}
}
