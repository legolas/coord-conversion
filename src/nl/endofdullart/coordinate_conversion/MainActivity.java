package nl.endofdullart.coordinate_conversion;

import nl.endofdullart.coordinate_conversion.model.DMSCoordinate;
import nl.endofdullart.coordinate_conversion.model.DecDegCoordinate;
import nl.endofdullart.coordinate_conversion.model.MinDecCoordinate;
import nl.endofdullart.coordinate_conversion.view.DMSCoordinateTextEdit;
import nl.endofdullart.coordinate_conversion.view.DecDegCoordinateTextEdit;
import nl.endofdullart.coordinate_conversion.view.MinDecCoordinateTextEdit;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private DecDegCoordinateTextEdit decDegCoordinateLatitude;
	private DecDegCoordinateTextEdit decDegCoordinateLongitude;
	private DMSCoordinateTextEdit dmsCoordinateLatitude;
	private DMSCoordinateTextEdit dmsCoordinateLongitude;
	private MinDecCoordinateTextEdit minDecCoordinateLatitude;
	private MinDecCoordinateTextEdit minDecCoordinateLongitude;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Associate the views with representing objects
		decDegCoordinateLatitude = (DecDegCoordinateTextEdit) findViewById(R.id.decDegCoordinateLatitude);
		decDegCoordinateLongitude = (DecDegCoordinateTextEdit) findViewById(R.id.decDegCoordinateLongitude);
		dmsCoordinateLatitude = (DMSCoordinateTextEdit) findViewById(R.id.dmsCoordinateLatitude);
		dmsCoordinateLongitude = (DMSCoordinateTextEdit) findViewById(R.id.dmsCoordinateLongitude);
		minDecCoordinateLatitude = (MinDecCoordinateTextEdit) findViewById(R.id.minDecCoordinateLatitude);
		minDecCoordinateLongitude = (MinDecCoordinateTextEdit) findViewById(R.id.minDecCoordinateLongitude);

		// Add listeners
		decDegCoordinateLatitude.setOnKeyListener(new View.OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				DecDegCoordinate coordinate = decDegCoordinateLatitude
						.getCoordinate();
				double rawCoordinate = coordinate.getRawCoordinate();
				// Set the coordinate in all other flavours
				dmsCoordinateLatitude.setCoordinate(new DMSCoordinate(
						rawCoordinate));
				minDecCoordinateLatitude.setCoordinate(new MinDecCoordinate(
						rawCoordinate));
				return true;
			}
		});
		decDegCoordinateLongitude.setOnKeyListener(new View.OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				DecDegCoordinate coordinate = decDegCoordinateLongitude
						.getCoordinate();
				double rawCoordinate = coordinate.getRawCoordinate();
				// Set the coordinate in all other flavours
				dmsCoordinateLongitude.setCoordinate(new DMSCoordinate(
						rawCoordinate));
				minDecCoordinateLongitude.setCoordinate(new MinDecCoordinate(
						rawCoordinate));
				return true;
			}
		});
		dmsCoordinateLatitude.setOnKeyListener(new View.OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				DMSCoordinate coordinate = dmsCoordinateLatitude
						.getCoordinate();
				double rawCoordinate = coordinate.getRawCoordinate();
				// Set the coordinate in all other flavours
				minDecCoordinateLatitude.setCoordinate(new MinDecCoordinate(
						rawCoordinate));
				decDegCoordinateLatitude.setCoordinate(new DecDegCoordinate(
						rawCoordinate));
				return true;
			}
		});
		dmsCoordinateLongitude.setOnKeyListener(new View.OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				DMSCoordinate coordinate = dmsCoordinateLongitude
						.getCoordinate();
				double rawCoordinate = coordinate.getRawCoordinate();
				// Set the coordinate in all other flavours
				decDegCoordinateLongitude.setCoordinate(new DecDegCoordinate(
						rawCoordinate));
				minDecCoordinateLongitude.setCoordinate(new MinDecCoordinate(
						rawCoordinate));
				return true;
			}
		});
		minDecCoordinateLatitude.setOnKeyListener(new View.OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				MinDecCoordinate coordinate = minDecCoordinateLatitude
						.getCoordinate();
				double rawCoordinate = coordinate.getRawCoordinate();
				// Set the coordinate in all other flavours
				decDegCoordinateLatitude.setCoordinate(new DecDegCoordinate(
						rawCoordinate));
				dmsCoordinateLatitude.setCoordinate(new DMSCoordinate(
						rawCoordinate));
				return true;
			}
		});
		minDecCoordinateLongitude.setOnKeyListener(new View.OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				MinDecCoordinate coordinate = minDecCoordinateLongitude
						.getCoordinate();
				double rawCoordinate = coordinate.getRawCoordinate();
				// Set the coordinate in all other flavours
				decDegCoordinateLongitude.setCoordinate(new DecDegCoordinate(
						rawCoordinate));
				dmsCoordinateLongitude.setCoordinate(new DMSCoordinate(
						rawCoordinate));
				return true;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		// Set the coordinate in all other flavours
		return true;
	}

}
