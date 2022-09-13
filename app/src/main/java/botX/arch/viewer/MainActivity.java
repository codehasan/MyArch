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

        bold_font = Typeface.createFromAsset(getAssets(), "fonts/google_sans_bold.ttf");
        regular_font = Typeface.createFromAsset(getAssets(), "fonts/google_sans_regular.ttf");
		medium_font = Typeface.createFromAsset(getAssets(), "fonts/google_sans_medium.ttf");

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
        s.setSpan(new TypefaceSpan(this, "fonts/google_sans_regular.ttf"), 0, s.length(),
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
        return "#".concat(hexString.equals("ff") ? "" : hexString).concat(hexString2).concat(hexString3).concat(hexString4);
    }

    public String getLink(String tag, String url) {
        String linkColor = convertJavaToArgb(Util.getColor(MainActivity.this, R.color.linkColor));
        return "<span style=\"color:".concat(linkColor).concat("\"><a href=\"").concat(url).concat("\">").concat(tag).concat("</a></span>");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getTitle().toString().equals(getString(R.string.about))) {
            NoticeDialog notice = new NoticeDialog(MainActivity.this);
            notice.setMessage(getString(R.string.about_description).concat(" Rahat. ").concat(String.format(getString(R.string.thnaks), getString(R.string.app_name))).concat("\n\n").concat(getString(R.string.icons_by)).concat(" Icons8"));
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
                        intent.setData(Uri.parse("https://t.me/BotXRahat"));
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
