package com.example.doan.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class SaveToken {

    private static SharedPreferences sharedPreferences;
    private static final String TOKEN_KEY = "TOKEN_KEY";

    private SaveToken() {}

    public static void init(Context context) {
        if (sharedPreferences == null && context != null) {
            sharedPreferences = context.getSharedPreferences("saveToken", Context.MODE_PRIVATE);
        }
    }

    public static SaveToken getInstance() {
        return SaveTokenHolder.INSTANCE;
    }

    private static class SaveTokenHolder {
        private static final SaveToken INSTANCE = new SaveToken();
    }

    public static void saveTokens(String token) {
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(TOKEN_KEY, token);
            editor.apply();
        } else {
            Log.d("Token", token);
        }
    }

    public static  String getToken() {
        if (sharedPreferences != null) {
            return sharedPreferences.getString(TOKEN_KEY, null);
        }
        return null;
    }

    public  static  void clearToken() {
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(TOKEN_KEY).apply();
        }
    }
}

