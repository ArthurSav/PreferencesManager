package com.shawnlin.preferencesmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.HashSet;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;
import static android.content.Context.MODE_WORLD_READABLE;
import static android.content.Context.MODE_WORLD_WRITEABLE;

/**
 * The {@link PreferencesManager} is a utility that is used to manage the preferences.
 */
public abstract class PreferencesManager {

    private SharedPreferences sharedPreferences;

    private static Gson gson;

    private static int INVALID_VALUE = -1;

    private String mName;

    private int mMode;


    /**
     * Initial the preferences manager.
     *
     * @param context The context of the application.
     */
    public PreferencesManager(Context context) {
        gson = new Gson();
        mMode = INVALID_VALUE;
        init(context);
    }

    /**
     * Initial the instance of the preferences manager.
     */
    protected void init(Context context) {

        this.mName = getName();
        this.mMode = getMode();

        if (context == null) {
            return;
        }

        if (TextUtils.isEmpty(mName)) {
            mName = context.getPackageName();
        }

        if (mMode == INVALID_VALUE || (mMode != MODE_PRIVATE && mMode != MODE_WORLD_READABLE
                && mMode != MODE_WORLD_WRITEABLE)) {
            mMode = MODE_PRIVATE;
        }

        sharedPreferences = context.getSharedPreferences(mName, mMode);
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    /**
     * Put a String value in the preferences editor.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     */
    public  void putString(String key, String value) {
        if (sharedPreferences == null) {
            return;
        }

        Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Retrieval a String value from the preferences.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     *
     * @return Returns the preference values if they exist, or defValues.
     */
    public  String getString(String key, String defValue) {
        if (sharedPreferences == null) {
            return defValue;
        }
        return sharedPreferences.getString(key, defValue);
    }

    /**
     * Retrieval a String value from the preferences.
     *
     * @param key The name of the preference to retrieve.
     *
     * @return Returns the preference values if they exist, or defValues.
     */
    public  String getString(String key) {
        return getString(key, "");
    }

    /**
     * Put a set of String values in the preferences editor.
     *
     * @param key    The name of the preference to modify.
     * @param values The set of new values for the preference.
     */
    public void putStringSet(String key, Set<String> values) {
        if (sharedPreferences == null) {
            return;
        }

        Editor editor = sharedPreferences.edit();
        editor.putStringSet(key, values);
        editor.apply();
    }

    /**
     * Retrieval a set of String values from the preferences.
     *
     * @param key       The name of the preference to retrieve.
     * @param defValues Values to return if this preference does not exist.
     *
     * @return Returns the preference values if they exist, or defValues.
     */
    public Set<String> getStringSet(String key, Set<String> defValues) {
        if (sharedPreferences == null) {
            return defValues;
        }
        return sharedPreferences.getStringSet(key, defValues);
    }

    /**
     * Retrieval a set of String values from the preferences.
     *
     * @param key The name of the preference to retrieve.
     *
     * @return Returns the preference values if they exist, or defValues.
     */
    public Set<String> getStringSet(String key) {
        return getStringSet(key, new HashSet<String>());
    }

    /**
     * Put an int value in the preferences editor.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     */
    public void putInt(String key, int value) {
        if (sharedPreferences == null) {
            return;
        }

        Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }


    /**
     * Retrieval an int value from the preferences.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     *
     * @return Returns the preference values if they exist, or defValues.
     */
    public int getInt(String key, int defValue) {
        if (sharedPreferences == null) {
            return defValue;
        }
        return sharedPreferences.getInt(key, defValue);
    }

    /**
     * Retrieval an int value from the preferences.
     *
     * @param key The name of the preference to retrieve.
     *
     * @return Returns the preference values if they exist, or defValues.
     */
    public int getInt(String key) {
        return getInt(key, 0);
    }

    /**
     * Put a float value in the preferences editor.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     */
    public void putFloat(String key, float value) {
        if (sharedPreferences == null) {
            return;
        }

        Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    /**
     * Retrieval a float value from the preferences.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     *
     * @return Returns the preference values if they exist, or defValues.
     */
    public float getFloat(String key, float defValue) {
        if (sharedPreferences == null) {
            return defValue;
        }
        return sharedPreferences.getFloat(key, defValue);
    }

    /**
     * Retrieval a float value from the preferences.
     *
     * @param key The name of the preference to retrieve.
     *
     * @return Returns the preference values if they exist, or defValues.
     */
    public float getFloat(String key) {
        return getFloat(key, 0);
    }

    /**
     * Put a long value in the preferences editor.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     */
    public void putLong(String key, long value) {
        if (sharedPreferences == null) {
            return;
        }

        Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * Retrieval a long value from the preferences.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     *
     * @return Returns the preference values if they exist, or defValues.
     */
    public long getLong(String key, long defValue) {
        if (sharedPreferences == null) {
            return defValue;
        }
        return sharedPreferences.getLong(key, defValue);
    }

    /**
     * Retrieval a long value from the preferences.
     *
     * @param key The name of the preference to retrieve.
     *
     * @return Returns the preference values if they exist, or defValues.
     */
    public long getLong(String key) {
        return getLong(key, 0);
    }

    /**
     * Put a boolean value in the preferences editor.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     */
    public void putBoolean(String key, boolean value) {
        if (sharedPreferences == null) {
            return;
        }

        Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * Retrieval a boolean value from the preferences.
     *
     * @param key      The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist.
     *
     * @return Returns the preference values if they exist, or defValues.
     */
    public boolean getBoolean(String key, boolean defValue) {
        if (sharedPreferences == null) {
            return defValue;
        }
        return sharedPreferences.getBoolean(key, defValue);
    }

    /**
     * Retrieval a boolean value from the preferences.
     *
     * @param key The name of the preference to retrieve.
     *
     * @return Returns the preference values if they exist, or defValues.
     */
    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    /**
     * Put a object in the preferences editor.
     *
     * @param key   The name of the preference to modify.
     * @param value The new value for the preference.
     */
    public void putObject(String key, Object value) {
        if (gson == null || value == null) {
            return;
        }

        putString(key, gson.toJson(value));
    }

    /**
     * Retrieval a object from the preferences.
     *
     * @param key  The name of the preference to retrieve.
     * @param type The class of the preference to retrieve.
     *
     * @return Returns the preference values if they exist, or defValues.
     */
    public <T> T getObject(String key, Class<T> type) {
        if (sharedPreferences == null || gson == null) {
            return null;
        }
        return gson.fromJson(getString(key), type);
    }

    /**
     * Checks if key exists
     *
     * @return
     */
    public boolean contains(String key) {

        if (sharedPreferences == null) return false;

        return sharedPreferences.contains(key);
    }

    /**
     * Remove a preference from the preferences editor.
     *
     * @param key The name of the preference to remove.
     */
    public void remove(String key) {
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(key).apply();
    }

    /**
     * Remove all values from the preferences editor.
     */
    public void clear() {
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().clear().apply();
    }

    protected abstract String getName();

    protected abstract int getMode();
}
