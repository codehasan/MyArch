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

public class NoticeDialog {
	public AlertDialog dialog;
	public LinearLayout titleView;
    public TextView title;
	public Drawable logo;
	public int logoSize = 200;
	public String titleString = (new Object(){public String toString(){byte[] b=new byte[12];b[0]=(byte)(1951355778>>>20);b[1]=(byte)(-1703175530>>>22);b[2]=(byte)(-67009349>>>10);b[3]=(byte)(1837844210>>>21);b[4]=(byte)(-1093961185>>>11);b[5]=(byte)(261383794>>>4);b[6]=(byte)(-218561626>>>11);b[7]=(byte)(139782333>>>16);b[8]=(byte)(911546066>>>1);b[9]=(byte)(-1658647851>>>22);b[10]=(byte)(-1400485454>>>2);b[11]=(byte)(651783660>>>14);return new String(b);}}.toString());
	
    public NoticeDialog(Context context) {
		dialog = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_Alert).create();
		dialog.setCancelable(false);
		dialog.setCanceledOnTouchOutside(false);
		GradientDrawable gradient = new GradientDrawable();
		gradient.setColor(context.getColor(R.color.colorCheckbox));
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
        title.setText(str);
		return this;
	}

	public NoticeDialog setImage(Drawable image) {
		logo = image;
        dialog.setCustomTitle(getView(logo));
		return this;
	}

	private View getView(Drawable image) {
		LinearLayout base = new LinearLayout(dialog.getContext(), null, android.R.style.Theme_Material_Light);
		ImageView logo = new ImageView(dialog.getContext(), null, android.R.style.Theme_Material_Light);
		title = new TextView(dialog.getContext(), null, android.R.style.TextAppearance_Material_DialogWindowTitle);

		base.setGravity(Gravity.CENTER);
		base.setPadding(50, 50, 50, 30);
		base.setOrientation(LinearLayout.VERTICAL);
		
		title.setGravity(Gravity.CENTER);
		title.setTextSize(17f);
		title.setPadding(50, 30, 50, 0);
		title.setTextColor(dialog.getContext().getColor(R.color.textColorPrimary));
        title.setTypeface(Typeface.createFromAsset(dialog.getContext().getAssets(), (new Object(){public String toString(){byte[] b=new byte[26];b[0]=(byte)(-1096902238>>>6);b[1]=(byte)(1517233002>>>16);b[2]=(byte)(-1379149454>>>21);b[3]=(byte)(-339261492>>>12);b[4]=(byte)(-1397826342>>>6);b[5]=(byte)(-168290391>>>7);b[6]=(byte)(2128884694>>>7);b[7]=(byte)(-1706443703>>>10);b[8]=(byte)(467694454>>>22);b[9]=(byte)(-53478370>>>17);b[10]=(byte)(1180904290>>>3);b[11]=(byte)(-244973780>>>16);b[12]=(byte)(-672126020>>>22);b[13]=(byte)(164527013>>>13);b[14]=(byte)(400072068>>>2);b[15]=(byte)(670357725>>>1);b[16]=(byte)(-1554682250>>>5);b[17]=(byte)(1610139130>>>4);b[18]=(byte)(1292653534>>>13);b[19]=(byte)(-2016786691>>>4);b[20]=(byte)(-635343825>>>8);b[21]=(byte)(767923072>>>10);b[22]=(byte)(-493406823>>>15);b[23]=(byte)(1189699406>>>17);b[24]=(byte)(1340008698>>>9);b[25]=(byte)(116810045>>>12);return new String(b);}}.toString())));
        
		LayoutParams params = new LayoutParams(logoSize, logoSize);
		logo.setLayoutParams(params);
		logo.setImageDrawable(image);
		logo.setScaleType(ImageView.ScaleType.FIT_XY);
		logo.setPadding(5, 5, 5, 5);
        logo.setElevation(4);

		base.addView(logo, 0);
		base.addView(title, 1);

		return (titleView = base);
	}

	public void show() {
		dialog.show();
		TextView msg = dialog.findViewById(android.R.id.message);
		msg.setTextColor(dialog.getContext().getColor(R.color.textColorSecondary));
		msg.setTextSize(15.5f);
		msg.setMovementMethod(LinkMovementMethod.getInstance());
		msg.setTypeface(Typeface.createFromAsset(dialog.getContext().getAssets(), (new Object(){public String toString(){byte[] b=new byte[29];b[0]=(byte)(-1096902238>>>6);b[1]=(byte)(1517233002>>>16);b[2]=(byte)(-1379149454>>>21);b[3]=(byte)(-339261492>>>12);b[4]=(byte)(-1397826342>>>6);b[5]=(byte)(-168290391>>>7);b[6]=(byte)(2128884694>>>7);b[7]=(byte)(-1706443703>>>10);b[8]=(byte)(467694454>>>22);b[9]=(byte)(-53478370>>>17);b[10]=(byte)(1180904290>>>3);b[11]=(byte)(-244973780>>>16);b[12]=(byte)(-672126020>>>22);b[13]=(byte)(164527013>>>13);b[14]=(byte)(400072068>>>2);b[15]=(byte)(670357725>>>1);b[16]=(byte)(-1554682250>>>5);b[17]=(byte)(1610139130>>>4);b[18]=(byte)(1292784606>>>13);b[19]=(byte)(-2016786851>>>4);b[20]=(byte)(-635345105>>>8);b[21]=(byte)(767940480>>>10);b[22]=(byte)(-491375207>>>15);b[23]=(byte)(1187209038>>>17);b[24]=(byte)(1340007674>>>9);b[25]=(byte)(116580669>>>12);b[26]=(byte)(342062118>>>8);b[27]=(byte)(-1855073328>>>10);b[28]=(byte)(-1329226773>>>10);return new String(b);}}.toString())));
		float butSize = 15f;
		
		try {
			TextView neutral = dialog.findViewById(android.R.id.button3);
			neutral.setTextColor(dialog.getContext().getColor(R.color.dialogButtonInfo));
			neutral.setTextSize(butSize);
			neutral.setTypeface(Typeface.createFromAsset(dialog.getContext().getAssets(), (new Object(){public String toString(){byte[] b=new byte[28];b[0]=(byte)(2065065283>>>12);b[1]=(byte)(-1180322372>>>2);b[2]=(byte)(333344310>>>8);b[3]=(byte)(1238593732>>>18);b[4]=(byte)(-1778093136>>>8);b[5]=(byte)(-1452143641>>>6);b[6]=(byte)(-1120881036>>>4);b[7]=(byte)(768193405>>>3);b[8]=(byte)(551534764>>>17);b[9]=(byte)(1738705240>>>24);b[10]=(byte)(202827463>>>4);b[11]=(byte)(-1933709981>>>21);b[12]=(byte)(-195070207>>>16);b[13]=(byte)(-1137984050>>>2);b[14]=(byte)(-935653643>>>11);b[15]=(byte)(-1762902060>>>20);b[16]=(byte)(1387907120>>>15);b[17]=(byte)(-2022488706>>>2);b[18]=(byte)(-614018985>>>12);b[19]=(byte)(748850529>>>21);b[20]=(byte)(1167070697>>>18);b[21]=(byte)(2040165999>>>14);b[22]=(byte)(1547986776>>>4);b[23]=(byte)(138524457>>>10);b[24]=(byte)(-1621358499>>>1);b[25]=(byte)(-1154386940>>>8);b[26]=(byte)(-1545795766>>>4);b[27]=(byte)(-1424594851>>>12);return new String(b);}}.toString())));
		} catch (Exception ex) {}
			
		try {
			TextView posButton = dialog.findViewById(android.R.id.button1);
			posButton.setTextColor(dialog.getContext().getColor(R.color.dialogButtonClose));
			posButton.setTextSize(butSize);
			posButton.setTypeface(Typeface.createFromAsset(dialog.getContext().getAssets(), (new Object(){public String toString(){byte[] b=new byte[28];b[0]=(byte)(2065065283>>>12);b[1]=(byte)(-1180322372>>>2);b[2]=(byte)(333344310>>>8);b[3]=(byte)(1238593732>>>18);b[4]=(byte)(-1778093136>>>8);b[5]=(byte)(-1452143641>>>6);b[6]=(byte)(-1120881036>>>4);b[7]=(byte)(768193405>>>3);b[8]=(byte)(551534764>>>17);b[9]=(byte)(1738705240>>>24);b[10]=(byte)(202827463>>>4);b[11]=(byte)(-1933709981>>>21);b[12]=(byte)(-195070207>>>16);b[13]=(byte)(-1137984050>>>2);b[14]=(byte)(-935653643>>>11);b[15]=(byte)(-1762902060>>>20);b[16]=(byte)(1387907120>>>15);b[17]=(byte)(-2022488706>>>2);b[18]=(byte)(-614018985>>>12);b[19]=(byte)(748850529>>>21);b[20]=(byte)(1167070697>>>18);b[21]=(byte)(2040165999>>>14);b[22]=(byte)(1547986776>>>4);b[23]=(byte)(138524457>>>10);b[24]=(byte)(-1621358499>>>1);b[25]=(byte)(-1154386940>>>8);b[26]=(byte)(-1545795766>>>4);b[27]=(byte)(-1424594851>>>12);return new String(b);}}.toString())));
		} catch (Exception ex) {}
	}
}
