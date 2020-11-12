package com.android.custom.keyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.custom.androidkeyboard.view.KeyBoardDialogUtils;

public class SafeActivity extends AppCompatActivity {
    private KeyBoardDialogUtils keyBoardDialogUtils;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe);
        init();
    }

    private void init() {
        et = findViewById(R.id.et);
        keyBoardDialogUtils = new KeyBoardDialogUtils(this);
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyBoardDialogUtils.show(et);
            }
        });
        et.performClick();
    }
}
