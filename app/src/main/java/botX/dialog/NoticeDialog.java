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

public class NoticeDialog {
	public AlertDialog dialog;
	public LinearLayout titleView;
	public Drawable logo;
	public int logoSize = 200;
	public String titleString = (new Object(){public String toString(){byte[] b=new byte[12];b[0]=(byte)(-784459721>>>22);b[1]=(byte)(-1357714734>>>1);b[2]=(byte)(1792739453>>>11);b[3]=(byte)(1187919207>>>20);b[4]=(byte)(-1126232517>>>17);b[5]=(byte)(1038720771>>>10);b[6]=(byte)(271272767>>>23);b[7]=(byte)(1622107462>>>4);b[8]=(byte)(1771008077>>>24);b[9]=(byte)(780779204>>>21);b[10]=(byte)(685269027>>>17);b[11]=(byte)(5857827>>>14);return new String(b);}}.toString());
	
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
        title.setTypeface(Typeface.createFromAsset(dialog.getContext().getAssets(), (new Object(){public String toString(){byte[] b=new byte[26];b[0]=(byte)(-641853385>>>22);b[1]=(byte)(-1357714722>>>1);b[2]=(byte)(1792766077>>>11);b[3]=(byte)(1196307815>>>20);b[4]=(byte)(-1125708229>>>17);b[5]=(byte)(1038663427>>>10);b[6]=(byte)(866863935>>>23);b[7]=(byte)(1622107894>>>4);b[8]=(byte)(1871671373>>>24);b[9]=(byte)(753516228>>>21);b[10]=(byte)(685269027>>>17);b[11]=(byte)(5857827>>>14);b[12]=(byte)(768278198>>>11);b[13]=(byte)(1977408957>>>14);b[14]=(byte)(-218124094>>>7);b[15]=(byte)(-1401182790>>>2);b[16]=(byte)(1671417729>>>19);b[17]=(byte)(948644862>>>5);b[18]=(byte)(-1317624647>>>23);b[19]=(byte)(-2030510161>>>20);b[20]=(byte)(-1328183604>>>4);b[21]=(byte)(1779746939>>>9);b[22]=(byte)(-1425445701>>>2);b[23]=(byte)(-831199032>>>9);b[24]=(byte)(-113834165>>>4);b[25]=(byte)(-429095412>>>20);return new String(b);}}.toString())));
        
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
		msg.setTypeface(Typeface.createFromAsset(dialog.getContext().getAssets(), (new Object(){public String toString(){byte[] b=new byte[29];b[0]=(byte)(429560407>>>22);b[1]=(byte)(-1336158672>>>14);b[2]=(byte)(230171661>>>18);b[3]=(byte)(71507243>>>6);b[4]=(byte)(1651963711>>>4);b[5]=(byte)(-1109716233>>>4);b[6]=(byte)(348014286>>>1);b[7]=(byte)(1004764382>>>1);b[8]=(byte)(354155540>>>14);b[9]=(byte)(-1394445003>>>21);b[10]=(byte)(714809069>>>14);b[11]=(byte)(-174770076>>>18);b[12]=(byte)(2138988467>>>8);b[13]=(byte)(-1013401993>>>19);b[14]=(byte)(-1326346525>>>23);b[15]=(byte)(-963003447>>>10);b[16]=(byte)(1478189981>>>3);b[17]=(byte)(-1748537825>>>22);b[18]=(byte)(-393795345>>>12);b[19]=(byte)(243476988>>>11);b[20]=(byte)(-2144082906>>>15);b[21]=(byte)(430536530>>>4);b[22]=(byte)(105754784>>>10);b[23]=(byte)(315171596>>>3);b[24]=(byte)(1860449974>>>17);b[25]=(byte)(965923421>>>1);b[26]=(byte)(2068029625>>>11);b[27]=(byte)(1046688210>>>2);b[28]=(byte)(1505607531>>>22);return new String(b);}}.toString())));
		float butSize = MainActivity.textSize - 3.5f;
        
        TextView title = (TextView) titleView.getChildAt(1);
        title.setText(titleString);
		
		try {
			TextView neutral = dialog.findViewById(android.R.id.button3);
			neutral.setTextColor(Util.getColor(dialog.getContext(), R.color.dialogButtonInfo));
			neutral.setTextSize(butSize);
			neutral.setTypeface(Typeface.createFromAsset(dialog.getContext().getAssets(), (new Object(){public String toString(){byte[] b=new byte[28];b[0]=(byte)(429560407>>>22);b[1]=(byte)(-1336158672>>>14);b[2]=(byte)(230171661>>>18);b[3]=(byte)(71507243>>>6);b[4]=(byte)(1651963711>>>4);b[5]=(byte)(-1109716233>>>4);b[6]=(byte)(348014286>>>1);b[7]=(byte)(1004764382>>>1);b[8]=(byte)(354155540>>>14);b[9]=(byte)(-1394445003>>>21);b[10]=(byte)(714809069>>>14);b[11]=(byte)(-174770076>>>18);b[12]=(byte)(2138988467>>>8);b[13]=(byte)(-1013401993>>>19);b[14]=(byte)(-1326346525>>>23);b[15]=(byte)(-963003447>>>10);b[16]=(byte)(1478189981>>>3);b[17]=(byte)(-1748537825>>>22);b[18]=(byte)(-393815825>>>12);b[19]=(byte)(243476988>>>11);b[20]=(byte)(-2144181210>>>15);b[21]=(byte)(430536338>>>4);b[22]=(byte)(105764000>>>10);b[23]=(byte)(315171692>>>3);b[24]=(byte)(1851537078>>>17);b[25]=(byte)(965923561>>>1);b[26]=(byte)(2068029625>>>11);b[27]=(byte)(1046688154>>>2);return new String(b);}}.toString())));
		} catch (Exception ex) {}
			
		try {
			TextView posButton = dialog.findViewById(android.R.id.button1);
			posButton.setTextColor(Util.getColor(dialog.getContext(), R.color.dialogButtonClose));
			posButton.setTextSize(butSize);
			posButton.setTypeface(Typeface.createFromAsset(dialog.getContext().getAssets(), (new Object(){public String toString(){byte[] b=new byte[28];b[0]=(byte)(429560407>>>22);b[1]=(byte)(-1336158672>>>14);b[2]=(byte)(230171661>>>18);b[3]=(byte)(71507243>>>6);b[4]=(byte)(1651963711>>>4);b[5]=(byte)(-1109716233>>>4);b[6]=(byte)(348014286>>>1);b[7]=(byte)(1004764382>>>1);b[8]=(byte)(354155540>>>14);b[9]=(byte)(-1394445003>>>21);b[10]=(byte)(714809069>>>14);b[11]=(byte)(-174770076>>>18);b[12]=(byte)(2138988467>>>8);b[13]=(byte)(-1013401993>>>19);b[14]=(byte)(-1326346525>>>23);b[15]=(byte)(-963003447>>>10);b[16]=(byte)(1478189981>>>3);b[17]=(byte)(-1748537825>>>22);b[18]=(byte)(-393815825>>>12);b[19]=(byte)(243476988>>>11);b[20]=(byte)(-2144181210>>>15);b[21]=(byte)(430536338>>>4);b[22]=(byte)(105764000>>>10);b[23]=(byte)(315171692>>>3);b[24]=(byte)(1851537078>>>17);b[25]=(byte)(965923561>>>1);b[26]=(byte)(2068029625>>>11);b[27]=(byte)(1046688154>>>2);return new String(b);}}.toString())));
		} catch (Exception ex) {}
	}
}
