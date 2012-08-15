package nl.endofdullart.coordinate_conversion.view;

import nl.endofdullart.coordinate_conversion.R;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.Toast;

public class CoordinateTextWatcher implements TextWatcher {

	private Context context;
	private int maxValue;

	public CoordinateTextWatcher(Context context, int maxValue) {
		this.context = context;
		this.maxValue = maxValue;
	}

	@Override
	public void afterTextChanged(Editable editable) {
		String stringValue = editable.toString();
		// Expect it to be numeric
		double value = Double.valueOf(stringValue);
		if (value > maxValue) {
			showToast();
		}
	}

	private void showToast() {
		String msg = context.getResources().getString(R.string.exceededMaximum,
				maxValue);
		Toast toast = Toast.makeText(context.getApplicationContext(), msg,
				Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// Intentionally left empty
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// Intentionally left empty
	}
}
