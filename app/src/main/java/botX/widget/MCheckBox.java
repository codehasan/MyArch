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
