package nl.endofdullart.coordinate_conversion.view;

import nl.endofdullart.coordinate_conversion.R;
import nl.endofdullart.coordinate_conversion.model.CoordinateDirection;
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

	public DecDegCoordinate getCoordinate() {
		Log.v(T, "getCoordinate");
		String coordText = editDegrees.getText().toString();
		Log.v(T, String.format("EditText contains %s."));
		Double rawCoord = Double.parseDouble(coordText);

		return new DecDegCoordinate(rawCoord);
	}
}
