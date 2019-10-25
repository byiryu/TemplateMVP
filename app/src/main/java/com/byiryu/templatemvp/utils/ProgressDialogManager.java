package com.byiryu.templatemvp.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.byiryu.templatemvp.R;

public class ProgressDialogManager {
    private static ProgressDialogManager sInterface = new ProgressDialogManager();
    private DIProgress mProgress = null;

    public static ProgressDialogManager getInstance() {
        return sInterface;
    }

    public synchronized void show(Context context) {
        try {
            if (mProgress != null) {
                mProgress.dismiss();
            }

//            Activity activity = ActivityReference.getActivtyReference();
//            if (activity == null) return;
//            if (activity.isDestroyed()) return;
            mProgress = new DIProgress(context);
            mProgress.show();
        } catch (Exception ignored) {
        }
    }

    public synchronized void clear() {
        try {
            if (mProgress != null) {
                mProgress.dismiss();
                mProgress = null;
            }
        } catch (Exception ignored) {

        }
    }

    public boolean isShowing(){
        return this.isShowing();
    }

    public class DIProgress extends Dialog {

        public DIProgress(Context context) {
            super(context, R.style.DialogTheme);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.di_progress);
            setCancelable(false);
        }
    }
}
