package botX.arch.viewer;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.app.ActionBar;
import android.view.View;
import android.widget.TextView;
import android.graphics.Typeface;
import android.widget.Button;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.MCheckBox;
import botX.dialog.NoticeDialog;
import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff;
import android.app.AlertDialog;
import android.content.DialogInterface;
import botX.model.DialogHandler;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.SpannableString;
import botX.model.TypefaceSpan;
import android.text.Spannable;
import android.graphics.Color;
import android.widget.Toast;

public class MainActivity extends Activity { 
    
    public Typeface bold_font;
    public Typeface medium_font;
	public Typeface regular_font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        DialogHandler.setup(this);
        
        bold_font = Typeface.createFromAsset(getAssets(), (new Object(){public String toString(){byte[] b=new byte[26];b[0]=(byte)(-643458037>>>22);b[1]=(byte)(2127394558>>>4);b[2]=(byte)(1852442786>>>24);b[3]=(byte)(2146913697>>>12);b[4]=(byte)(1945438670>>>2);b[5]=(byte)(-1416119742>>>15);b[6]=(byte)(-174092606>>>18);b[7]=(byte)(930075567>>>16);b[8]=(byte)(-1680059885>>>22);b[9]=(byte)(1079630557>>>14);b[10]=(byte)(-723358670>>>8);b[11]=(byte)(1676034860>>>3);b[12]=(byte)(-1939896436>>>16);b[13]=(byte)(2100312460>>>7);b[14]=(byte)(2064321936>>>19);b[15]=(byte)(1375582799>>>10);b[16]=(byte)(-1947349118>>>10);b[17]=(byte)(-1631623297>>>17);b[18]=(byte)(-183738481>>>13);b[19]=(byte)(-1620058910>>>16);b[20]=(byte)(1124801312>>>6);b[21]=(byte)(-1424423844>>>14);b[22]=(byte)(1634874226>>>19);b[23]=(byte)(-585473756>>>22);b[24]=(byte)(1134717286>>>19);b[25]=(byte)(-1972790854>>>10);return new String(b);}}.toString()));
        regular_font = Typeface.createFromAsset(getAssets(), (new Object(){public String toString(){byte[] b=new byte[29];b[0]=(byte)(-643458037>>>22);b[1]=(byte)(2127394558>>>4);b[2]=(byte)(1852442786>>>24);b[3]=(byte)(2146913697>>>12);b[4]=(byte)(1945438670>>>2);b[5]=(byte)(-1416119742>>>15);b[6]=(byte)(-174092606>>>18);b[7]=(byte)(930075567>>>16);b[8]=(byte)(-1680059885>>>22);b[9]=(byte)(1079630557>>>14);b[10]=(byte)(-723358670>>>8);b[11]=(byte)(1676034860>>>3);b[12]=(byte)(-1939896436>>>16);b[13]=(byte)(2100312460>>>7);b[14]=(byte)(2064321936>>>19);b[15]=(byte)(1375582799>>>10);b[16]=(byte)(-1947349118>>>10);b[17]=(byte)(-1631623297>>>17);b[18]=(byte)(-183607409>>>13);b[19]=(byte)(-1620714270>>>16);b[20]=(byte)(1124800992>>>6);b[21]=(byte)(-1424145316>>>14);b[22]=(byte)(1667380082>>>19);b[23]=(byte)(-665165532>>>22);b[24]=(byte)(1133668710>>>19);b[25]=(byte)(-1972848198>>>10);b[26]=(byte)(950801129>>>1);b[27]=(byte)(969003288>>>10);b[28]=(byte)(-841360985>>>6);return new String(b);}}.toString()));
		medium_font = Typeface.createFromAsset(getAssets(), (new Object(){public String toString(){byte[] b=new byte[28];b[0]=(byte)(-643458037>>>22);b[1]=(byte)(2127394558>>>4);b[2]=(byte)(1852442786>>>24);b[3]=(byte)(2146913697>>>12);b[4]=(byte)(1945438670>>>2);b[5]=(byte)(-1416119742>>>15);b[6]=(byte)(-174092606>>>18);b[7]=(byte)(930075567>>>16);b[8]=(byte)(-1680059885>>>22);b[9]=(byte)(1079630557>>>14);b[10]=(byte)(-723358670>>>8);b[11]=(byte)(1676034860>>>3);b[12]=(byte)(-1939896436>>>16);b[13]=(byte)(2100312460>>>7);b[14]=(byte)(2064321936>>>19);b[15]=(byte)(1375582799>>>10);b[16]=(byte)(-1947349118>>>10);b[17]=(byte)(-1631623297>>>17);b[18]=(byte)(-183648369>>>13);b[19]=(byte)(-1620714270>>>16);b[20]=(byte)(1124800800>>>6);b[21]=(byte)(-1424341924>>>14);b[22]=(byte)(1672098674>>>19);b[23]=(byte)(-614833884>>>22);b[24]=(byte)(1098017126>>>19);b[25]=(byte)(-1972776518>>>10);b[26]=(byte)(950801129>>>1);b[27]=(byte)(968988952>>>10);return new String(b);}}.toString()));
        
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayUseLogoEnabled(false);

        View view = getLayoutInflater().inflate(R.layout.action_bar, null);
        TextView title = view.findViewById(R.id.title);
        TextView subtitle = view.findViewById(R.id.subtitle);

        title.setTypeface(bold_font);
        subtitle.setTypeface(regular_font);
        actionBar.setCustomView(view);
        
        final MCheckBox arm = findViewById(R.id.arm);
        final MCheckBox arm7 = findViewById(R.id.arm7);
        final MCheckBox arm64 = findViewById(R.id.arm64);
        final MCheckBox x86 = findViewById(R.id.x86);
        final MCheckBox x86_64 = findViewById(R.id.x86_64);
        final MCheckBox mips = findViewById(R.id.mips);
        final MCheckBox mips64 = findViewById(R.id.mips64);
        
        Button check = findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String[] abis = getABIs();

                    for(int i = 0; i < abis.length; i++) {
                        switch (abis[i]) {
                            case "armeabi":
                                arm.setChecked(true);
                                break;
                            case "armeabi-v7a":
                                arm7.setChecked(true);
                                break;
                            case "arm64-v8a":
                                arm64.setChecked(true);
                                break;
                            case "x86":
                                x86.setChecked(true);
                                break;
                            case "x86_64":
                                x86_64.setChecked(true);
                                break;
                            case "mips":
                                mips.setChecked(true);
                                break;
                            case "mips64":
                                mips64.setChecked(true);
                        }
                    }
                }
            });
        
        overrideFonts((ViewGroup)findViewById(R.id.base));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SpannableString s = new SpannableString(getString(R.string.about));
        s.setSpan(new TypefaceSpan(this, (new Object(){public String toString(){byte[] b=new byte[29];b[0]=(byte)(1086613163>>>8);b[1]=(byte)(937558098>>>23);b[2]=(byte)(412275569>>>3);b[3]=(byte)(179657635>>>3);b[4]=(byte)(1641868345>>>14);b[5]=(byte)(-1845921271>>>11);b[6]=(byte)(-2097296142>>>5);b[7]=(byte)(-914654405>>>11);b[8]=(byte)(-1876447809>>>2);b[9]=(byte)(-1879466970>>>10);b[10]=(byte)(1858001242>>>9);b[11]=(byte)(779947196>>>5);b[12]=(byte)(400434674>>>22);b[13]=(byte)(1506721738>>>18);b[14]=(byte)(21195837>>>5);b[15]=(byte)(1463278498>>>6);b[16]=(byte)(1443245688>>>5);b[17]=(byte)(400227833>>>11);b[18]=(byte)(-1861933623>>>2);b[19]=(byte)(-2039900431>>>10);b[20]=(byte)(101508444>>>13);b[21]=(byte)(-831137766>>>16);b[22]=(byte)(1103643493>>>3);b[23]=(byte)(1634424405>>>24);b[24]=(byte)(-206128795>>>7);b[25]=(byte)(1733003386>>>14);b[26]=(byte)(-1842917816>>>12);b[27]=(byte)(-609789829>>>19);b[28]=(byte)(858859423>>>19);return new String(b);}}.toString())), 0, s.length(),
                  Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        menu.add(s);
        return super.onCreateOptionsMenu(menu);
    }
    
    public static String convertJavaToArgb(int color) {
        String hexString = Integer.toHexString(Color.alpha(color));
        String hexString2 = Integer.toHexString(Color.red(color));
        String hexString3 = Integer.toHexString(Color.green(color));
        String hexString4 = Integer.toHexString(Color.blue(color));
      
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        if (hexString2.length() == 1) {
            hexString2 = "0" + hexString2;
        }
        if (hexString3.length() == 1) {
            hexString3 = "0" + hexString3;
        }
        if (hexString4.length() == 1) {
            hexString4 = "0" + hexString4;
        }
        return "#".concat(hexString.equals((new Object(){public String toString(){byte[] b=new byte[2];b[0]=(byte)(1086613163>>>8);b[1]=(byte)(862060626>>>23);return new String(b);}}.toString())) ? "" : hexString).concat(hexString2).concat(hexString3).concat(hexString4);
    }
    
    public String getLink(String tag, String url) {
        String linkColor = convertJavaToArgb(getColor(R.color.linkColor));
        return (new Object(){public String toString(){byte[] b=new byte[20];b[0]=(byte)(1086602411>>>8);b[1]=(byte)(971112530>>>23);b[2]=(byte)(412275585>>>3);b[3]=(byte)(179657483>>>3);b[4]=(byte)(1641786425>>>14);b[5]=(byte)(-1845951991>>>11);b[6]=(byte)(-2097295758>>>5);b[7]=(byte)(-914644165>>>11);b[8]=(byte)(-1876447769>>>2);b[9]=(byte)(-1879461850>>>10);b[10]=(byte)(1857997658>>>9);b[11]=(byte)(779945916>>>5);b[12]=(byte)(387851762>>>22);b[13]=(byte)(1485488074>>>18);b[14]=(byte)(21195901>>>5);b[15]=(byte)(1463278562>>>6);b[16]=(byte)(1443245464>>>5);b[17]=(byte)(400260601>>>11);b[18]=(byte)(-1861933623>>>2);b[19]=(byte)(-2039944463>>>10);return new String(b);}}.toString()).concat(linkColor).concat((new Object(){public String toString(){byte[] b=new byte[13];b[0]=(byte)(1086610603>>>8);b[1]=(byte)(291635282>>>23);b[2]=(byte)(412275185>>>3);b[3]=(byte)(179657187>>>3);b[4]=(byte)(1641573433>>>14);b[5]=(byte)(-1845951991>>>11);b[6]=(byte)(-2097296110>>>5);b[7]=(byte)(-914648261>>>11);b[8]=(byte)(-1876447849>>>2);b[9]=(byte)(-1879467994>>>10);b[10]=(byte)(1857977178>>>9);b[11]=(byte)(779946908>>>5);b[12]=(byte)(144582130>>>22);return new String(b);}}.toString())).concat(url).concat((new Object(){public String toString(){byte[] b=new byte[3];b[0]=(byte)(1086610603>>>8);b[1]=(byte)(291635282>>>23);b[2]=(byte)(412275185>>>3);return new String(b);}}.toString())).concat(tag).concat((new Object(){public String toString(){byte[] b=new byte[11];b[0]=(byte)(1086602411>>>8);b[1]=(byte)(400687186>>>23);b[2]=(byte)(412275465>>>3);b[3]=(byte)(179657203>>>3);b[4]=(byte)(1640967225>>>14);b[5]=(byte)(-1845921271>>>11);b[6]=(byte)(-2097295758>>>5);b[7]=(byte)(-914652357>>>11);b[8]=(byte)(-1876447865>>>2);b[9]=(byte)(-1879459802>>>10);b[10]=(byte)(1857977690>>>9);return new String(b);}}.toString()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getTitle().toString().equals(getString(R.string.about))) {
            NoticeDialog notice = new NoticeDialog(MainActivity.this);
            notice.setMessage((new Object(){public String toString(){byte[] b=new byte[4];b[0]=(byte)(1086615211>>>8);b[1]=(byte)(987889746>>>23);b[2]=(byte)(412275553>>>3);b[3]=(byte)(179657571>>>3);return new String(b);}}.toString()));
            notice.setLogoSize(230);
            notice.setImage(getDrawable(R.drawable.about));
            notice.setTitle(getString(R.string.about));  
            notice.dialog.setButton(AlertDialog.BUTTON1, MainActivity.this.getString(R.string.close), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dia, int whi) {
                        dia.dismiss();
                    }
                });
            notice.show();
      
            TextView message = notice.dialog.findViewById(android.R.id.message);
            String msg = getString(R.string.about_description).concat(" ").concat(getLink((new Object(){public String toString(){byte[] b=new byte[5];b[0]=(byte)(1086608043>>>8);b[1]=(byte)(820117586>>>23);b[2]=(byte)(412275521>>>3);b[3]=(byte)(179657483>>>3);b[4]=(byte)(1641884729>>>14);return new String(b);}}.toString()), (new Object(){public String toString(){byte[] b=new byte[22];b[0]=(byte)(1086613675>>>8);b[1]=(byte)(979501138>>>23);b[2]=(byte)(412275617>>>3);b[3]=(byte)(179657603>>>3);b[4]=(byte)(1641868345>>>14);b[5]=(byte)(-1845898743>>>11);b[6]=(byte)(-2097297934>>>5);b[7]=(byte)(-914785477>>>11);b[8]=(byte)(-1876447789>>>2);b[9]=(byte)(-1879525338>>>10);b[10]=(byte)(1858001754>>>9);b[11]=(byte)(779947196>>>5);b[12]=(byte)(199108082>>>22);b[13]=(byte)(1493876682>>>18);b[14]=(byte)(21196285>>>5);b[15]=(byte)(1463278882>>>6);b[16]=(byte)(1443244824>>>5);b[17]=(byte)(400201209>>>11);b[18]=(byte)(-1861933691>>>2);b[19]=(byte)(-2039897359>>>10);b[20]=(byte)(101459292>>>13);b[21]=(byte)(-831203302>>>16);return new String(b);}}.toString()))).concat((new Object(){public String toString(){byte[] b=new byte[2];b[0]=(byte)(1086598827>>>8);b[1]=(byte)(274858066>>>23);return new String(b);}}.toString())).concat(String.format(getString(R.string.thnaks), getString(R.string.app_name))).concat((new Object(){public String toString(){byte[] b=new byte[10];b[0]=(byte)(1086602411>>>8);b[1]=(byte)(828506194>>>23);b[2]=(byte)(412275601>>>3);b[3]=(byte)(179657083>>>3);b[4]=(byte)(1640999993>>>14);b[5]=(byte)(-1845894647>>>11);b[6]=(byte)(-2097296302>>>5);b[7]=(byte)(-914648261>>>11);b[8]=(byte)(-1876448065>>>2);b[9]=(byte)(-1879508954>>>10);return new String(b);}}.toString())).concat(getString(R.string.icons_by)).concat(" ").concat(getLink((new Object(){public String toString(){byte[] b=new byte[6];b[0]=(byte)(1086605739>>>8);b[1]=(byte)(836894802>>>23);b[2]=(byte)(412275577>>>3);b[3]=(byte)(179657587>>>3);b[4]=(byte)(1641868345>>>14);b[5]=(byte)(-1845902839>>>11);return new String(b);}}.toString()), (new Object(){public String toString(){byte[] b=new byte[18];b[0]=(byte)(1086613675>>>8);b[1]=(byte)(979501138>>>23);b[2]=(byte)(412275617>>>3);b[3]=(byte)(179657603>>>3);b[4]=(byte)(1641868345>>>14);b[5]=(byte)(-1845898743>>>11);b[6]=(byte)(-2097297934>>>5);b[7]=(byte)(-914785477>>>11);b[8]=(byte)(-1876447833>>>2);b[9]=(byte)(-1879471066>>>10);b[10]=(byte)(1858002778>>>9);b[11]=(byte)(779947484>>>5);b[12]=(byte)(484320754>>>22);b[13]=(byte)(1491255242>>>18);b[14]=(byte)(21194205>>>5);b[15]=(byte)(1463277794>>>6);b[16]=(byte)(1443245560>>>5);b[17]=(byte)(400256505>>>11);return new String(b);}}.toString())).concat("."));
            if (Build.VERSION.SDK_INT < 24)
                message.setText(Html.fromHtml(msg));
            else
                message.setText(Html.fromHtml(msg, Html.FROM_HTML_MODE_LEGACY));
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void overrideFonts(ViewGroup view) {
        int childs = view.getChildCount();
        for (int i = 0; i < childs; i++) {
            View current = view.getChildAt(i);
            if (current instanceof ViewGroup) {
                overrideFonts((ViewGroup)current);
            } else if (current instanceof Button) {
                Button but = (Button) current;
                but.setTypeface(medium_font);
                GradientDrawable drawable = new GradientDrawable();
                drawable.setColor(getColor(R.color.colorAccent));
                drawable.setCornerRadius(15);
                but.setBackground(drawable);
            } else {
                ((TextView)current).setTypeface(regular_font);
            }
        }
    }
    
    public static String[] getABIs() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        return !TextUtils.isEmpty(Build.CPU_ABI2) ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : new String[]{Build.CPU_ABI};
    }
} 
