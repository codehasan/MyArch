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
package botX.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.graphics.drawable.GradientDrawable;
import botX.arch.viewer.R;
import android.view.View;
import botX.model.DialogHandler;
import android.os.Build;
import android.widget.TextView;
import android.content.res.Resources;
import botX.arch.viewer.Util;

/* Created by Ratul Hasan */

public class MCheckBox extends TextView {
    public MCheckBox(Context context) {
        super(context);
        setChecked(false);
        if (Build.VERSION.SDK_INT >= 21)
            setElevation(4);
        setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    DialogHandler.show(getContext(), getText().toString());
                }
            });
    }
    
    public MCheckBox(Context context, int style) {
        super(context, null, style);
        setChecked(false);
        if (Build.VERSION.SDK_INT >= 21)
            setElevation(4);
        setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    DialogHandler.show(getContext(), getText().toString());
                }
            });
    }
    
    public MCheckBox(Context context, AttributeSet attrs, int style, int res) {
        super(context, attrs, style, res);
        setChecked(false);
        if (Build.VERSION.SDK_INT >= 21)
            setElevation(4);
        setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    DialogHandler.show(getContext(), getText().toString());
                }
            });
    }
    
    public MCheckBox(Context context, AttributeSet attrs, int style) {
        super(context, attrs, style);
        setChecked(false);
        if (Build.VERSION.SDK_INT >= 21)
            setElevation(4);
        setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    DialogHandler.show(getContext(), getText().toString());
                }
            });
    }
    
    public MCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        setChecked(false);
        if (Build.VERSION.SDK_INT >= 21)
            setElevation(4);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogHandler.show(getContext(), getText().toString());
            }
        });
    }
    
    public void setChecked(boolean bool) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(999);
        
        if (bool) {
            setTextColor(Util.getColor(getContext(), R.color.buttonColor));
            drawable.setColor(Util.getColor(getContext(), R.color.colorCheckboxChecked));
        } else {
            setTextColor(Util.getColor(getContext(), R.color.textColorSecondary));
            drawable.setColor(Util.getColor(getContext(), R.color.colorCheckbox));
        }
        setBackground(drawable);
    }
}