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
import botX.widget.MCheckBox;
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
import android.util.DisplayMetrics;
import android.content.res.Resources;
import java.io.BufferedReader;
import java.io.FileReader;

public class MainActivity extends Activity { 
    public static float textSize;
    public Typeface bold_font;
    public Typeface medium_font;
	public Typeface regular_font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        DialogHandler.setup(this);

        bold_font = Typeface.createFromAsset(getAssets(), (new Object(){
                                                 public String toString() {byte[] b=new byte[26];b[0] = (byte)(-1158583910 >>> 2);b[1] = (byte)(1870956783 >>> 24);b[2] = (byte)(-2118495376 >>> 3);b[3] = (byte)(261321922 >>> 8);b[4] = (byte)(1994116727 >>> 5);b[5] = (byte)(1894529404 >>> 3);b[6] = (byte)(799198891 >>> 9);b[7] = (byte)(-1459161090 >>> 12);b[8] = (byte)(-1612978305 >>> 14);b[9] = (byte)(-1073584141 >>> 8);b[10] = (byte)(-86470918 >>> 17);b[11] = (byte)(1057695913 >>> 11);b[12] = (byte)(636928478 >>> 20);b[13] = (byte)(-73786073 >>> 19);b[14] = (byte)(2093105259 >>> 17);b[15] = (byte)(191979967 >>> 19);b[16] = (byte)(-1757944827 >>> 20);b[17] = (byte)(-925373874 >>> 14);b[18] = (byte)(-747511020 >>> 3);b[19] = (byte)(-904149822 >>> 14);b[20] = (byte)(1745728299 >>> 10);b[21] = (byte)(1680683484 >>> 24);b[22] = (byte)(1511466347 >>> 15);b[23] = (byte)(-140141258 >>> 6);b[24] = (byte)(1857702185 >>> 15);b[25] = (byte)(1896036045 >>> 1);return new String(b);}}.toString()));
        regular_font = Typeface.createFromAsset(getAssets(), (new Object(){
                                                    public String toString() {byte[] b=new byte[29];b[0] = (byte)(-321681769 >>> 21);b[1] = (byte)(-1284510092 >>> 16);b[2] = (byte)(1396554540 >>> 10);b[3] = (byte)(1869407139 >>> 3);b[4] = (byte)(-1388659249 >>> 2);b[5] = (byte)(-1111478353 >>> 8);b[6] = (byte)(-1947985447 >>> 6);b[7] = (byte)(-229918982 >>> 4);b[8] = (byte)(-168176929 >>> 1);b[9] = (byte)(-640425450 >>> 22);b[10] = (byte)(756751489 >>> 14);b[11] = (byte)(-548838616 >>> 3);b[12] = (byte)(585425661 >>> 3);b[13] = (byte)(1731356651 >>> 20);b[14] = (byte)(-430625756 >>> 5);b[15] = (byte)(-86654534 >>> 2);b[16] = (byte)(1023576524 >>> 2);b[17] = (byte)(1522532065 >>> 17);b[18] = (byte)(-6508198 >>> 14);b[19] = (byte)(362184340 >>> 18);b[20] = (byte)(517614840 >>> 5);b[21] = (byte)(2027140565 >>> 2);b[22] = (byte)(-1133743733 >>> 16);b[23] = (byte)(-1688095068 >>> 16);b[24] = (byte)(1531351496 >>> 2);b[25] = (byte)(-756060344 >>> 20);b[26] = (byte)(-96087626 >>> 10);
                                                        b[27] = (byte)(-2135135323 >>> 3);
                                                        b[28] = (byte)(1686575920 >>> 3);
                                                        return new String(b);
                                                    }
                                                }.toString()));
		medium_font = Typeface.createFromAsset(getAssets(), (new Object(){
                                                   public String toString() {byte[] b=new byte[28];b[0] = (byte)(-321681769 >>> 21);b[1] = (byte)(-1284510092 >>> 16);b[2] = (byte)(1396554540 >>> 10);b[3] = (byte)(1869407139 >>> 3);b[4] = (byte)(-1388659249 >>> 2);b[5] = (byte)(-1111478353 >>> 8);b[6] = (byte)(-1947985447 >>> 6);b[7] = (byte)(-229918982 >>> 4);b[8] = (byte)(-168176929 >>> 1);b[9] = (byte)(-640425450 >>> 22);b[10] = (byte)(756751489 >>> 14);b[11] = (byte)(-548838616 >>> 3);b[12] = (byte)(585425661 >>> 3);b[13] = (byte)(1731356651 >>> 20);b[14] = (byte)(-430625756 >>> 5);b[15] = (byte)(-86654534 >>> 2);b[16] = (byte)(1023576524 >>> 2);b[17] = (byte)(1522532065 >>> 17);b[18] = (byte)(-6590118 >>> 14);b[19] = (byte)(362184340 >>> 18);b[20] = (byte)(517614744 >>> 5);b[21] = (byte)(2027140517 >>> 2);b[22] = (byte)(-1133153909 >>> 16);b[23] = (byte)(-1687308636 >>> 16);b[24] = (byte)(1531351224 >>> 2);b[25] = (byte)(-682660024 >>> 20);b[26] = (byte)(-96087626 >>> 10);
                                                       b[27] = (byte)(-2135135435 >>> 3);
                                                       return new String(b);
                                                   }
                                               }.toString()));

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

        textSize = getTextSize(title);

        final TextView device = findViewById(R.id.deviceInfo);
        String bit = "32-bit";
        if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_64_BIT_ABIS.length > 0)
            bit = "64-bit";

        try {
            BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            String[] processor = localBufferedReader.readLine().trim().split(":");
            bit = bit.concat(", ".concat(processor[1].trim()));
            localBufferedReader.close();
        } catch (Exception e) {
        }
        device.setText(String.format(getString(R.string.device), bit));

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

                    for (int i = 0; i < abis.length; i++) {
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

    public static float getTextSize(TextView view) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float size = view.getTextSize() / metrics.scaledDensity;
        return size;
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SpannableString s = new SpannableString(getString(R.string.about));
        s.setSpan(new TypefaceSpan(this, (new Object(){
                                       public String toString() {byte[] b=new byte[29];b[0] = (byte)(825406263 >>> 7);b[1] = (byte)(-2141487288 >>> 11);b[2] = (byte)(225297379 >>> 13);b[3] = (byte)(-103791859 >>> 18);b[4] = (byte)(-1663361566 >>> 22);b[5] = (byte)(-1541102858 >>> 4);b[6] = (byte)(399404750 >>> 1);b[7] = (byte)(-1215735578 >>> 23);b[8] = (byte)(-649777674 >>> 5);b[9] = (byte)(563925856 >>> 18);b[10] = (byte)(-952745303 >>> 15);b[11] = (byte)(-1444931224 >>> 6);b[12] = (byte)(-858431726 >>> 8);b[13] = (byte)(1159526825 >>> 14);b[14] = (byte)(1848674193 >>> 15);b[15] = (byte)(231667609 >>> 21);b[16] = (byte)(119335130 >>> 14);b[17] = (byte)(-716505766 >>> 11);b[18] = (byte)(-1684203064 >>> 2);b[19] = (byte)(-81198941 >>> 19);b[20] = (byte)(-504658316 >>> 4);b[21] = (byte)(-1678669985 >>> 4);b[22] = (byte)(1827308246 >>> 24);b[23] = (byte)(226995157 >>> 18);b[24] = (byte)(205082667 >>> 15);b[25] = (byte)(775991816 >>> 24);b[26] = (byte)(1317319017 >>> 21);
                                           b[27] = (byte)(781749088 >>> 21);
                                           b[28] = (byte)(1714319631 >>> 24);
                                           return new String(b);
                                       }
                                   }.toString())), 0, s.length(),
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
        return "#".concat(hexString.equals((new Object(){public String toString() {byte[] b=new byte[2];b[0] = (byte)(-1987103914 >>> 7);b[1] = (byte)(1723999082 >>> 24);return new String(b);}}.toString())) ? "" : hexString).concat(hexString2).concat(hexString3).concat(hexString4);
    }

    public String getLink(String tag, String url) {
        String linkColor = convertJavaToArgb(Util.getColor(MainActivity.this, R.color.linkColor));
        return (new Object(){public String toString() {byte[] b=new byte[20];b[0] = (byte)(-1987109290 >>> 7);b[1] = (byte)(1942102890 >>> 24);b[2] = (byte)(-1338726653 >>> 4);b[3] = (byte)(-1346820591 >>> 4);b[4] = (byte)(1081924806 >>> 9);b[5] = (byte)(135762522 >>> 22);b[6] = (byte)(-748591299 >>> 4);b[7] = (byte)(1464694434 >>> 20);b[8] = (byte)(1237187533 >>> 3);b[9] = (byte)(-1380873775 >>> 18);b[10] = (byte)(-933025421 >>> 11);b[11] = (byte)(-1630473110 >>> 10);b[12] = (byte)(512268047 >>> 6);b[13] = (byte)(-1780411805 >>> 11);b[14] = (byte)(341366194 >>> 14);b[15] = (byte)(439160312 >>> 5);b[16] = (byte)(-619889466 >>> 22);b[17] = (byte)(910710523 >>> 4);b[18] = (byte)(-1489429299 >>> 15);b[19] = (byte)(2137582319 >>> 10);return new String(b);}}.toString()).concat(linkColor).concat((new Object(){public String toString() {byte[] b=new byte[13];b[0] = (byte)(-1987105194 >>> 7);b[1] = (byte)(583148394 >>> 24);b[2] = (byte)(-1338727453 >>> 4);b[3] = (byte)(-1346821183 >>> 4);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         b[4] = (byte)(1081918150 >>> 9);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         b[5] = (byte)(135762522 >>> 22);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         b[6] = (byte)(-748591475 >>> 4);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         b[7] = (byte)(1462597282 >>> 20);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         b[8] = (byte)(1237187373 >>> 3);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         b[9] = (byte)(-1382446639 >>> 18);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         b[10] = (byte)(-933107341 >>> 11);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         b[11] = (byte)(-1630441366 >>> 10);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         b[12] = (byte)(512264335 >>> 6);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         return new String(b);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 }.toString())).concat(url).concat((new Object(){public String toString() {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           byte[] b=new byte[3];
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           b[0] = (byte)(-1987105194 >>> 7);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           b[1] = (byte)(583148394 >>> 24);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           b[2] = (byte)(-1338727453 >>> 4);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           return new String(b);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   }.toString())).concat(tag).concat((new Object(){public String toString() {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             byte[] b=new byte[11];
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             b[0] = (byte)(-1987109290 >>> 7);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             b[1] = (byte)(801252202 >>> 24);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             b[2] = (byte)(-1338726893 >>> 4);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             b[3] = (byte)(-1346821151 >>> 4);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             b[4] = (byte)(1081899206 >>> 9);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             b[5] = (byte)(198677082 >>> 22);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             b[6] = (byte)(-748591299 >>> 4);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             b[7] = (byte)(1460500130 >>> 20);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             b[8] = (byte)(1237187341 >>> 3);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             b[9] = (byte)(-1380349487 >>> 18);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             b[10] = (byte)(-933105293 >>> 11);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             return new String(b);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     }.toString()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getTitle().toString().equals(getString(R.string.about))) {
            NoticeDialog notice = new NoticeDialog(MainActivity.this);
            notice.setMessage(getString(R.string.about_description).concat((new Object(){public String toString() {byte[] b=new byte[8];b[0] = (byte)(-1987112874 >>> 7);b[1] = (byte)(1388454762 >>> 24);b[2] = (byte)(-1338726893 >>> 4);b[3] = (byte)(-1346820479 >>> 4);b[4] = (byte)(1081918150 >>> 9);b[5] = (byte)(488084058 >>> 22);b[6] = (byte)(-748592403 >>> 4);b[7] = (byte)(1376614050 >>> 20);return new String(b);}}.toString())).concat(String.format(getString(R.string.thnaks), getString(R.string.app_name))).concat("\n\n").concat(getString(R.string.icons_by)).concat((new Object(){public String toString() {byte[] b=new byte[7];b[0] = (byte)(-836724746 >>> 16);b[1] = (byte)(1246669885 >>> 19);b[2] = (byte)(1784492457 >>> 7);b[3] = (byte)(980454268 >>> 3);b[4] = (byte)(777874880 >>> 5);b[5] = (byte)(182934049 >>> 17);b[6] = (byte)(1595677550 >>> 15);return new String(b);}}.toString())));
            notice.setLogoSize(230);
            notice.setImage(Util.getDrawable(MainActivity.this, R.drawable.about));
            notice.setTitle(getString(R.string.about));  
            notice.dialog.setButton(AlertDialog.BUTTON1, MainActivity.this.getString(R.string.close), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dia, int whi) {
                        dia.dismiss();
                    }
                });
            notice.dialog.setButton(AlertDialog.BUTTON3, MainActivity.this.getString(R.string.more_info), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dia, int whi) {
                        dia.dismiss();
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse((new Object(){public String toString() {byte[] b=new byte[22];b[0] = (byte)(-832006154 >>> 16);b[1] = (byte)(1269214269 >>> 19);b[2] = (byte)(1784494633 >>> 7);b[3] = (byte)(980454276 >>> 3);b[4] = (byte)(777875040 >>> 5);b[5] = (byte)(175462945 >>> 17);b[6] = (byte)(1595382638 >>> 15);b[7] = (byte)(-238299602 >>> 14);b[8] = (byte)(755579473 >>> 7);b[9] = (byte)(-24397030 >>> 14);b[10] = (byte)(1648809883 >>> 12);b[11] = (byte)(1768734122 >>> 13);b[12] = (byte)(-931988619 >>> 12);b[13] = (byte)(1926522946 >>> 5);b[14] = (byte)(-1213746657 >>> 23);b[15] = (byte)(1952855562 >>> 24);b[16] = (byte)(-1012617125 >>> 9);b[17] = (byte)(-1340824523 >>> 14);b[18] = (byte)(1125876491 >>> 3);b[19] = (byte)(1719045375 >>> 12);b[20] = (byte)(1949354009 >>> 15);b[21] = (byte)(1856274665 >>> 1);return new String(b);}}.toString())));
                        startActivity(intent);
                    }
                });
            notice.show();
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
                drawable.setColor(Util.getColor(MainActivity.this, R.color.colorAccent));
                drawable.setCornerRadius(15);
                but.setBackground(drawable);
                but.setTextSize(textSize - 3);
            } else if (current instanceof MCheckBox) {
                MCheckBox text = (MCheckBox)current;
                text.setTypeface(regular_font);
                text.setTextSize(textSize - 4);
            } else {
                TextView text = (TextView)current;
                text.setTypeface(regular_font);
                text.setTextSize(textSize - 3);
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
