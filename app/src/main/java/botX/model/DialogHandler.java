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
package botX.model;
import android.content.Context;
import botX.dialog.NoticeDialog;
import android.graphics.drawable.Drawable;
import botX.arch.viewer.R;
import android.os.Build;
import android.graphics.PorterDuff;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Map;
import java.util.HashMap;
import android.content.Intent;
import android.net.Uri;
import botX.arch.viewer.Util;

/* Created by Ratul Hasan */

public class DialogHandler {
    private static Map<String, String> map;
    private static Map<String, String> links;
    private static Drawable drawable;
    
    private static void initMap(Context context) {
        map = new HashMap<>();
        map.put("armeabi", context.getString(R.string.armeabi_info));
        map.put("arm64-v8a", context.getString(R.string.v8a_info));
        map.put("armeabi-v7a", context.getString(R.string.v7a_info));
        map.put("x86", context.getString(R.string.x86_info));
        map.put("x86_64", context.getString(R.string.x86_64_info));
        map.put("mips", context.getString(R.string.mips_info));
        map.put("mips64", context.getString(R.string.mips64_info));
        
        links = new HashMap<>();
        links.put("armeabi", "http://android-doc.github.io/ndk/guides/abis.html#armeabi");
        links.put("arm64-v8a", "http://android-doc.github.io/ndk/guides/abis.html#arm64-v8a");
        links.put("armeabi-v7a", "http://android-doc.github.io/ndk/guides/abis.html#v7a");
        links.put("x86", "http://android-doc.github.io/ndk/guides/abis.html#x86");
        links.put("x86_64", "http://android-doc.github.io/ndk/guides/abis.html#86-64");
        links.put("mips", "http://android-doc.github.io/ndk/guides/abis.html#mips");
        links.put("mips64", "http://android-doc.github.io/ndk/guides/abis.html#mips64");
    }
    
    public static void setup(Context context) {
        initMap(context);
        drawable = Util.getDrawable(context, R.drawable.cpu).mutate();
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(Util.getColor(context, R.color.textColorPrimary));
            drawable.setTintMode(PorterDuff.Mode.SRC_IN);
        }
    }
    
    public static void show(final Context context, final String str) {
        NoticeDialog dialog = new NoticeDialog(context);
        dialog.setLogoSize(230);
        dialog.setMessage(map.get(str));
        dialog.setImage(drawable);
        dialog.setTitle(str);
        dialog.dialog.setButton(AlertDialog.BUTTON1, context.getString(R.string.close), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dia, int whi) {
                    dia.dismiss();
                }
            });
        dialog.dialog.setButton(AlertDialog.BUTTON3, context.getString(R.string.more_info), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dia, int whi) {
                    dia.dismiss();
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(links.get(str)));
                    context.startActivity(intent);
                }
            });
        dialog.show();
    }
    
}