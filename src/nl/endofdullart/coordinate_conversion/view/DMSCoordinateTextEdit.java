package nl.endofdullart.coordinate_conversion.view;

import nl.endofdullart.coordinate_conversion.R;
import nl.endofdullart.coordinate_conversion.model.CoordinateDirection;
import nl.endofdullart.coordinate_conversion.model.DMSCoordinate;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DMSCoordinateTextEdit extends LinearLayout {

	private static final String T = DMSCoordinateTextEdit.class.getSimpleName();
	private EditText editDegrees;
	private EditText editMinutes;
	private EditText editSeconds;

	public DMSCoordinateTextEdit(Context context) {
		super(context);
		inflateView();
	}

	public DMSCoordinateTextEdit(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);

		inflateView();
	}

	/**
	 * Inflate the view from the layout resource
	 */
	private void inflateView() {
		Log.v(T, "inflateView");
		if (!isInEditMode()) {
			String inflaterService = Context.LAYOUT_INFLATER_SERVICE;

			LayoutInflater layoutInflater = (LayoutInflater) getContext()
					.getSystemService(inflaterService);
			layoutInflater.inflate(R.layout.dms_coordinate, this, true);

			// Get child control references
			editDegrees = (EditText) findViewById(R.id.editDegrees);
			editMinutes = (EditText) findViewById(R.id.editMinutes);
			editSeconds = (EditText) findViewById(R.id.editSeconds);
		}
	}

	public void setCoordDirection(CoordinateDirection coordinateDirection) {
		TextView txtLatLong = (TextView) findViewById(R.id.textLatLong);
		txtLatLong.setText(coordinateDirection.toString());
		Log.v(T,
				String.format("Direction set to ",
						coordinateDirection.toString()));
	}

	@Override
	public void setOnKeyListener(OnKeyListener listener) {
		Log.v(T, "setOnKeyListener");
		editDegrees.setOnKeyListener(listener);
	}

	public DMSCoordinate getCoordinate() {
		Log.v(T, "getCoordinate");
		String degreesText = editDegrees.getText().toString();
		String minutesText = editMinutes.getText().toString();
		String secondsText = editSeconds.getText().toString();
		Log.v(T, String.format("Coordinate: %s %s %s.", degreesText,
				minutesText, secondsText));

		return new DMSCoordinate(Integer.parseInt(degreesText),
				Integer.parseInt(minutesText), Double.parseDouble(secondsText));
	}
}
