/*
 *   Copyright (C) 2022 Ratul Hasan
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package botX.dialog;

import android.content.*;
import android.app.*;
import android.widget.*;
import android.view.*;
import android.view.ViewGroup.*;
import android.graphics.*;
import android.graphics.drawable.*;
import botX.arch.viewer.R;
import android.text.method.LinkMovementMethod;
import botX.arch.viewer.MainActivity;
import botX.arch.viewer.Util;
import android.os.Build;

/* Created by Ratul Hasan */

public class NoticeDialog {
	public AlertDialog dialog;
	public LinearLayout titleView;
	public Drawable logo;
	public int logoSize = 200;
	public String titleString = "Dialog Title";
	
    public NoticeDialog(Context context) {
		dialog = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_Alert).create();
		dialog.setCancelable(false);
		dialog.setCanceledOnTouchOutside(false);
		GradientDrawable gradient = new GradientDrawable();
		gradient.setColor(Util.getColor(context, R.color.colorCheckbox));
		gradient.setCornerRadius(15);
		dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		dialog.getWindow().setBackgroundDrawable(new InsetDrawable(gradient, 70));
	}

	public NoticeDialog setMessage(String str) {
		dialog.setMessage(str);
		return this;
	}
	
	public NoticeDialog setLogoSize(int size) {
		logoSize = size;
		return this;
	}

	public NoticeDialog setTitle(String str) {
		titleString = str;
		return this;
	}

	public NoticeDialog setImage(Drawable image) {
		logo = image;
		return this;
	}

	private View getView(Drawable image) {
		LinearLayout base = new LinearLayout(dialog.getContext());
		ImageView logo = new ImageView(dialog.getContext());
		TextView title = new TextView(dialog.getContext());

		base.setGravity(Gravity.CENTER);
		base.setPadding(50, 50, 50, 30);
		base.setOrientation(LinearLayout.VERTICAL);
		
        title.setText("null");
		title.setGravity(Gravity.CENTER);
        title.setTextSize(MainActivity.textSize - 2f);
		title.setPadding(50, 30, 50, 0);
		title.setTextColor(Util.getColor(dialog.getContext(), R.color.textColorPrimary));
        title.setTypeface(Typeface.createFromAsset(dialog.getContext().getAssets(), "fonts/google_sans_bold.ttf"));
        
		LayoutParams params = new LayoutParams(logoSize, logoSize);
		logo.setLayoutParams(params);
		logo.setImageDrawable(image);
		logo.setScaleType(ImageView.ScaleType.FIT_XY);
		logo.setPadding(5, 5, 5, 5);
        if (Build.VERSION.SDK_INT >= 21)
            logo.setElevation(4);

		base.addView(logo, 0);
		base.addView(title, 1);

		return (titleView = base);
	}

	public void show() {
        dialog.setCustomTitle(getView(logo));
		dialog.show();
		TextView msg = dialog.findViewById(android.R.id.message);
		msg.setTextColor(Util.getColor(dialog.getContext(), R.color.textColorSecondary));
		msg.setTextSize(MainActivity.textSize - 3.5f);
		msg.setTypeface(Typeface.createFromAsset(dialog.getContext().getAssets(), "fonts/google_sans_regular.ttf"));
		float butSize = MainActivity.textSize - 3.5f;
        
        TextView title = (TextView) titleView.getChildAt(1);
        title.setText(titleString);
		
		try {
			TextView neutral = dialog.findViewById(android.R.id.button3);
			neutral.setTextColor(Util.getColor(dialog.getContext(), R.color.dialogButtonInfo));
			neutral.setTextSize(butSize);
			neutral.setTypeface(Typeface.createFromAsset(dialog.getContext().getAssets(), "fonts/google_sans_medium.ttf"));
		} catch (Exception ex) {}
			
		try {
			TextView posButton = dialog.findViewById(android.R.id.button1);
			posButton.setTextColor(Util.getColor(dialog.getContext(), R.color.dialogButtonClose));
			posButton.setTextSize(butSize);
			posButton.setTypeface(Typeface.createFromAsset(dialog.getContext().getAssets(), "fonts/google_sans_medium.ttf"));
		} catch (Exception ex) {}
	}
}