package com.example.champernownecalculator.auxiliar;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;

import com.example.champernownecalculator.MainActivity;

public class LayoutListener implements OnTouchListener {
    Activity activity;

    public LayoutListener(Activity activity){
       this.activity=activity;
    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        hideKeyboardTouch(view);
        return false;
    }

    protected void hideKeyboardTouch(View view)
    {
        InputMethodManager in = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
