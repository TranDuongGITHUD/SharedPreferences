package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {

    private static final String PREF_NAME = "AppPreferences";
    private static final String FONT_SIZE_KEY = "FONT_SIZE";
    private static final float DEFAULT_FONT_SIZE = 16f;

    private final SharedPreferences sharedPreferences;

    public PreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveFontSize(float size) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(FONT_SIZE_KEY, size);
        editor.apply();
    }

    public float getFontSize() {
        return sharedPreferences.getFloat(FONT_SIZE_KEY, DEFAULT_FONT_SIZE);
    }
}
