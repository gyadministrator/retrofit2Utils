package com.gy.android.retrofit2utils.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gy.android.retrofit2utils.R;

/**
 * author:Administrator
 * time:2018/9/23
 * decription:
 **/
public class LoadingUtils {
    private static Dialog dialog;
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public static void showMsg(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public static void show(String msg) {
        if (dialog == null) {
            dialog = new Dialog(mContext, R.style.LoadDialog);
            View view = View.inflate(mContext, R.layout.dialog_loading, null);

            LinearLayout loadingRoot = view.findViewById(R.id.loadingRoot);

            TextView loadingMsg = view.findViewById(R.id.loadingMsg);
            loadingMsg.setText(msg);
            dialog = new Dialog(mContext, R.style.LoadDialog);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            dialog.setContentView(view);

            loadingRoot.setLayoutParams(new FrameLayout.LayoutParams(dp2px(100), dp2px(100)));
        }
        dialog.show();
    }

    public static void dismiss() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }


    private static int dp2px(int dip) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }
}
