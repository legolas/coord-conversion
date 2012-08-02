package nl.endofdullart.coordinate_conversion.model;

/**
 * The {@link DecDegCoordinate} class represents a coordinate formatted with the
 * Decimal Degrees format: {@code N 12.345678 E 009.87654}
 * 
 * @author MD80469
 * 
 */
public class DecDegCoordinate {

	private double degrees;

	public DecDegCoordinate(double degrees) {
		this.degrees = degrees;
	}

	public double getDegrees() {
		return degrees;
	}

	public double getRawCoordinate() {
		return getDegrees();
	}

	@Override
	public String toString() {
		return String.format("%d", getDegrees());
	}
}
