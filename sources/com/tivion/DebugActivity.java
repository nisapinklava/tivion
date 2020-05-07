package com.tivion;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;

public class DebugActivity extends Activity {
    String[] errMessage = {"Invalid string operation\n", "Invalid list operation\n", "Invalid arithmetical operation\n", "Invalid toNumber block operation\n", "Invalid intent operation"};
    String[] exceptionType = {"StringIndexOutOfBoundsException", "IndexOutOfBoundsException", "ArithmeticException", "NumberFormatException", "ActivityNotFoundException"};

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r1.isEmpty() != false) goto L_0x0025;
     */
    public void onCreate(Bundle bundle) {
        String str;
        int i = 0;
        super.onCreate(bundle);
        Intent intent = getIntent();
        String str2 = "";
        String str3 = "";
        if (intent != null) {
            str = intent.getStringExtra("error");
            String[] split = str.split("\n");
            while (true) {
                try {
                    if (i >= this.exceptionType.length) {
                        break;
                    } else if (split[0].contains(this.exceptionType[i])) {
                        str3 = new StringBuilder(String.valueOf(this.errMessage[i])).append(split[0].substring(this.exceptionType[i].length() + split[0].indexOf(this.exceptionType[i]), split[0].length())).toString();
                        break;
                    } else {
                        i++;
                    }
                } catch (Exception e) {
                    str = str3;
                }
            }
        }
        str = str3;
        Builder builder = new Builder(this);
        builder.setTitle("An error occured");
        builder.setMessage(str);
        builder.setNeutralButton("End Application", new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DebugActivity.this.finish();
            }
        });
        builder.create().show();
    }
}
