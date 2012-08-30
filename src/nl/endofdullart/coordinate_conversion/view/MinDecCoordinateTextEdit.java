package nl.endofdullart.coordinate_conversion.view;

import nl.endofdullart.coordinate_conversion.R;
import nl.endofdullart.coordinate_conversion.model.MinDecCoordinate;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MinDecCoordinateTextEdit extends LinearLayout {

	private static final String T = MinDecCoordinateTextEdit.class
			.getSimpleName();
	private EditText editDegrees;
	private EditText editMinutes;
	private Character latLong;

	public MinDecCoordinateTextEdit(Context context) {
		super(context);
		inflateView();
	}

	public MinDecCoordinateTextEdit(Context context, AttributeSet attributeSet) {
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
			layoutInflater.inflate(R.layout.decdeg_coordinate, this, true);

			// Get child control references
			editDegrees = (EditText) findViewById(R.id.editDegrees);
			editMinutes = (EditText) findViewById(R.id.editMinutes);
		}
	}

	public Character getLatLong() {
		return latLong;
	}

	public void setLatLong(Character latLongText) {
		this.latLong = latLongText;

		TextView txtLatLong = (TextView) findViewById(R.id.textLatLong);
		txtLatLong.setText(latLong);
		Log.v(T, String.format("Direction set to ", latLong));
	}

	@Override
	public void setOnKeyListener(OnKeyListener listener) {
		Log.v(T, "setOnKeyListener");
		editDegrees.setOnKeyListener(listener);
	}

	public void setCoordinate(MinDecCoordinate coordinate) {
		Log.v(T, "setCoordinate");
		editDegrees
				.setText(Integer.valueOf(coordinate.getDegrees()).toString());
		editMinutes.setText(Double.valueOf(coordinate.getMinutes()).toString());
	}

	public MinDecCoordinate getCoordinate() {
		Log.v(T, "getCoordinate");
		String degreesText = editDegrees.getText().toString();
		String minutesText = editMinutes.getText().toString();
		Log.v(T, String.format("Coordinate: %s %s.", degreesText, minutesText));

		return new MinDecCoordinate(Integer.parseInt(degreesText),
				Double.parseDouble(minutesText));
	}
}
