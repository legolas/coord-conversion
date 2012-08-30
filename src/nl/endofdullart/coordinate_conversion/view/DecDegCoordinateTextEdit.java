package nl.endofdullart.coordinate_conversion.view;

import nl.endofdullart.coordinate_conversion.R;
import nl.endofdullart.coordinate_conversion.model.DecDegCoordinate;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DecDegCoordinateTextEdit extends LinearLayout {

	private static final String T = DecDegCoordinateTextEdit.class
			.getSimpleName();
	private EditText editDegrees;
	private Character latLong;

	public DecDegCoordinateTextEdit(Context context) {
		super(context);
		inflateView();
	}

	public DecDegCoordinateTextEdit(Context context, AttributeSet attributeSet) {
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

	public void setCoordinate(DecDegCoordinate coordinate) {
		Log.v(T, "setCoordinate");
		editDegrees.setText(Double.valueOf(coordinate.getDegrees()).toString());
	}

	public DecDegCoordinate getCoordinate() {
		Log.v(T, "getCoordinate");
		String coordText = editDegrees.getText().toString();
		Log.v(T, String.format("EditText contains %s.", coordText));
		Double rawCoord = Double.parseDouble(coordText);

		return new DecDegCoordinate(rawCoord);
	}
}
