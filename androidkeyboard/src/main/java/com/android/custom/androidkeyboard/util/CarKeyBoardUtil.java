package com.android.custom.androidkeyboard.util;

import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.android.custom.androidkeyboard.R;

/**
 * @ProjectName: CustomKeyBoard
 * @Package: com.android.custom.androidkeyboard.util
 * @ClassName: CarKeyBoardUtil
 * @Author: 1984629668@qq.com
 * @CreateDate: 2020/11/12 14:33
 * 车牌号专用键盘
 */
public class CarKeyBoardUtil {
    private View keyboardParentView;
    private KeyboardView keyboardView;
    private EditText editText;
    private Keyboard keyboard;// 键盘

    public CarKeyBoardUtil(View keyboardParentView, KeyboardView keyboardView, EditText editText) {
        this.keyboardParentView = keyboardParentView;
        this.keyboardView = keyboardView;
        this.editText = editText;

        this.keyboard = new Keyboard(editText.getContext(), R.xml.customer_car_key_board);
        this.editText.setInputType(InputType.TYPE_NULL);
        this.keyboardView.setOnKeyboardActionListener(listener);
        this.keyboardView.setKeyboard(keyboard);
        this.keyboardView.setEnabled(true);
        this.keyboardView.setPreviewEnabled(false);
    }

    private KeyboardView.OnKeyboardActionListener listener = new KeyboardView.OnKeyboardActionListener() {

        @Override
        public void swipeUp() {
        }

        @Override
        public void swipeRight() {

        }

        @Override
        public void swipeLeft() {
        }

        @Override
        public void swipeDown() {
        }

        @Override
        public void onText(CharSequence text) {
        }

        @Override
        public void onRelease(int primaryCode) {
        }

        @Override
        public void onPress(int primaryCode) {
        }

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {
            Editable editable = editText.getText();
            int start = editText.getSelectionStart();
            switch (primaryCode) {
                case Keyboard.KEYCODE_DELETE:
                    if (editable != null && editable.length() > 0) {
                        if (start > 0) {
                            editable.delete(start - 1, start);
                        }
                    }
                    break;
                case Keyboard.KEYCODE_DONE:
                    if (runnable != null) {
                        keyboardView.postDelayed(runnable, 200);
                    } else {
                        if (keyboardParentView != null) {
                            keyboardParentView.setVisibility(View.GONE);
                        } else {
                            keyboardView.setVisibility(View.GONE);
                        }
                    }
                    break;
                case 73:
                case 79:
                    break;
                default:
                    editable.insert(start, Character.toString((char) primaryCode));
                    break;
            }
        }
    };

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (keyboardParentView != null) {
                if (keyboardParentView.getVisibility() == View.VISIBLE) {
                    keyboardParentView.setVisibility(View.GONE);
                }
            } else {
                if (keyboardView != null) {
                    if (keyboardView.getVisibility() == View.VISIBLE) {
                        keyboardView.setVisibility(View.GONE);
                    }
                }
            }
        }
    };

    public void showKeyboard() {
        if (keyboardParentView != null) {
            int visibility = keyboardParentView.getVisibility();
            if (visibility == View.GONE || visibility == View.INVISIBLE) {
                keyboardParentView.setVisibility(View.VISIBLE);
            }
        } else {
            if (keyboardView == null) {
                return;
            }
            int visibility = keyboardView.getVisibility();
            if (visibility == View.GONE || visibility == View.INVISIBLE) {
                keyboardView.setVisibility(View.VISIBLE);
            }
        }
    }

    public void hideKeyboard() {
        if (keyboardParentView != null) {
            int visibility = keyboardParentView.getVisibility();
            if (visibility == View.VISIBLE) {
                keyboardParentView.setVisibility(View.GONE);
            }
        } else {
            if (keyboardView == null) {
                return;
            }
            int visibility = keyboardView.getVisibility();
            if (visibility == View.VISIBLE) {
                keyboardView.setVisibility(View.GONE);
            }
        }
    }

    public int getKeyboardVisibility() {
        int visibility = View.GONE;
        if (keyboardParentView != null) {
            visibility = keyboardParentView.getVisibility();

        } else {
            if (keyboardView != null) {
                visibility = keyboardView.getVisibility();
            }
        }
        return visibility;
    }
}
