package com.tivion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {
    private Button antv;
    private Button button1;
    private Button global;
    private Button inews;
    /* access modifiers changed from: private */
    public Intent intent = new Intent();
    private LinearLayout linear10;
    private LinearLayout linear11;
    private LinearLayout linear13;
    private LinearLayout linear14;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear6;
    private LinearLayout linear7;
    private LinearLayout linear8;
    private LinearLayout linear9;
    private Button mnctv;
    private Button rcti;
    private Button rtv;
    private Button sctv;
    private TextView textview2;
    private TextView textview3;
    private Button trans7;
    private Button transtv;
    private Button tvone;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.linear6 = (LinearLayout) findViewById(R.id.linear6);
        this.linear7 = (LinearLayout) findViewById(R.id.linear7);
        this.linear8 = (LinearLayout) findViewById(R.id.linear8);
        this.linear9 = (LinearLayout) findViewById(R.id.linear9);
        this.linear10 = (LinearLayout) findViewById(R.id.linear10);
        this.linear11 = (LinearLayout) findViewById(R.id.linear11);
        this.linear13 = (LinearLayout) findViewById(R.id.linear13);
        this.linear14 = (LinearLayout) findViewById(R.id.linear14);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.rcti = (Button) findViewById(R.id.rcti);
        this.mnctv = (Button) findViewById(R.id.mnctv);
        this.sctv = (Button) findViewById(R.id.sctv);
        this.global = (Button) findViewById(R.id.global);
        this.tvone = (Button) findViewById(R.id.tvone);
        this.trans7 = (Button) findViewById(R.id.trans7);
        this.transtv = (Button) findViewById(R.id.transtv);
        this.antv = (Button) findViewById(R.id.antv);
        this.rtv = (Button) findViewById(R.id.rtv);
        this.inews = (Button) findViewById(R.id.inews);
        this.button1 = (Button) findViewById(R.id.button1);
        this.rcti.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.intent.setClass(MainActivity.this.getApplicationContext(), RctiActivity.class);
                MainActivity.this.startActivity(MainActivity.this.intent);
            }
        });
        this.mnctv.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.intent.setClass(MainActivity.this.getApplicationContext(), MncActivity.class);
                MainActivity.this.startActivity(MainActivity.this.intent);
            }
        });
        this.sctv.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.intent.setClass(MainActivity.this.getApplicationContext(), SctvActivity.class);
                MainActivity.this.startActivity(MainActivity.this.intent);
            }
        });
        this.global.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.intent.setClass(MainActivity.this.getApplicationContext(), GlobalActivity.class);
                MainActivity.this.startActivity(MainActivity.this.intent);
            }
        });
        this.tvone.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.intent.setClass(MainActivity.this.getApplicationContext(), TvoneActivity.class);
                MainActivity.this.startActivity(MainActivity.this.intent);
            }
        });
        this.trans7.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.intent.setClass(MainActivity.this.getApplicationContext(), Trans7Activity.class);
                MainActivity.this.startActivity(MainActivity.this.intent);
            }
        });
        this.transtv.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.intent.setClass(MainActivity.this.getApplicationContext(), TranstvActivity.class);
                MainActivity.this.startActivity(MainActivity.this.intent);
            }
        });
        this.antv.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.intent.setClass(MainActivity.this.getApplicationContext(), AntvActivity.class);
                MainActivity.this.startActivity(MainActivity.this.intent);
            }
        });
        this.rtv.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.intent.setClass(MainActivity.this.getApplicationContext(), RtvActivity.class);
                MainActivity.this.startActivity(MainActivity.this.intent);
            }
        });
        this.inews.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.intent.setClass(MainActivity.this.getApplicationContext(), InewsActivity.class);
                MainActivity.this.startActivity(MainActivity.this.intent);
            }
        });
        this.button1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.intent.setClass(MainActivity.this.getApplicationContext(), LebihActivity.class);
                MainActivity.this.startActivity(MainActivity.this.intent);
            }
        });
    }

    private void initializeLogic() {
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent2) {
        super.onActivityResult(i, i2, intent2);
    }

    @Deprecated
    public void showMessage(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    @Deprecated
    public int getLocationX(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    @Deprecated
    public int getLocationY(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    @Deprecated
    public int getRandom(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList<Double> arrayList = new ArrayList<>();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                arrayList.add(Double.valueOf((double) checkedItemPositions.keyAt(i)));
            }
        }
        return arrayList;
    }

    @Deprecated
    public float getDip(int i) {
        return TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
