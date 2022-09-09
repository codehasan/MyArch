package android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.graphics.drawable.GradientDrawable;
import botX.arch.viewer.R;
import android.view.View;
import botX.model.DialogHandler;

public class MCheckBox extends TextView {
    /*public MCheckBox(Context context) {
        super(context);
        setChecked(false);
    }
    
    public MCheckBox(Context context, int style) {
        super(context, null, style);
        setChecked(false);
    }
    
    public MCheckBox(Context context, AttributeSet attrs, int style, int res) {
        super(context, attrs, style, res);
        setChecked(false);
    }
    
    public MCheckBox(Context context, AttributeSet attrs, int style) {
        super(context, attrs, style);
        setChecked(false);
    }
    */
    public MCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        setChecked(false);
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
            setTextColor(getContext().getColor(R.color.buttonColor));
            drawable.setColor(getContext().getColor(R.color.colorCheckboxChecked));
        } else {
            setTextColor(getContext().getColor(R.color.textColorSecondary));
            drawable.setColor(getContext().getColor(R.color.colorCheckbox));
        }
        setBackground(drawable);
    }
}
