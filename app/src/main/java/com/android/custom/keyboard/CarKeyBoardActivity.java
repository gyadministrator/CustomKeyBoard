package com.android.custom.keyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.android.custom.androidkeyboard.util.CarKeyBoardUtil;
import com.android.custom.androidkeyboard.view.CarKeyboardView;

public class CarKeyBoardActivity extends AppCompatActivity {
    private EditText act_key_board_et;
    private CarKeyboardView keyboardView;
    private View ky_keyboard_parent;
    private CarKeyBoardUtil carKeyBoardUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_key_board);

        init();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init() {
        act_key_board_et = findViewById(R.id.act_key_board_et);
        keyboardView = findViewById(R.id.ky_keyboard);
        ky_keyboard_parent = findViewById(R.id.ky_keyboard_parent);
        carKeyBoardUtil = new CarKeyBoardUtil(ky_keyboard_parent, keyboardView, act_key_board_et);
        act_key_board_et.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (carKeyBoardUtil == null) {
                    carKeyBoardUtil = new CarKeyBoardUtil(ky_keyboard_parent, keyboardView, act_key_board_et);
                }
                carKeyBoardUtil.showKeyboard();
                return false;
            }
        });
        act_key_board_et.performClick();
    }
}
