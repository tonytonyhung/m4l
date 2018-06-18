package leduyhung.me.m4l.util;

import android.content.Context;
import android.content.SharedPreferences;

public class CacheUtil {

    private static final String NAME_CACHE = "MUSIC_FOR_LIFE_CACHE";
    private SharedPreferences shared;
    private SharedPreferences.Editor editor;

    public CacheUtil(Context ctx) {
        shared = ctx.getSharedPreferences(NAME_CACHE, Context.MODE_PRIVATE);
        editor = shared.edit();
    }

    public void putString(String key, String value) {

        editor.putString(key, value).commit();
    }

    public String getString(String key, String defValue) {

        return shared.getString(key, defValue);
    }

    public void putInt(String key, int value) {

        editor.putInt(key, value).commit();
    }

    public int getInt(String key, int defValue) {

        return shared.getInt(key, defValue);
    }

    public void putFloat(String key, float value) {

        editor.putFloat(key, value).commit();
    }

    public float getFloat(String key, float defValue) {

        return shared.getFloat(key, defValue);
    }

    public void putBoolean(String key, boolean value) {

        editor.putBoolean(key, value).commit();
    }

    public boolean getBoolean(String key, boolean defValue) {

        return shared.getBoolean(key, defValue);
    }

    public void clearByName(String key) {

        editor.remove(key).commit();
    }

    public void clearAll() {

        editor.clear().apply();
    }
}