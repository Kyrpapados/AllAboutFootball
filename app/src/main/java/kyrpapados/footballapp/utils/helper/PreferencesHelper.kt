package kyrpapados.footballapp.utils.helper

import android.content.SharedPreferences
import kyrpapados.footballapp.utils.Statics.Companion.FIRST_INSTALL
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
public class PreferencesHelper @Inject constructor(val preferences : SharedPreferences) {

    fun getFirstInstall(): Boolean {
        return preferences.getBoolean(FIRST_INSTALL, true)
    }

    fun putString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String {
        return preferences.getString(key, "")
    }

    fun putBoolean(key: String, value: Boolean) {
        preferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return preferences.getBoolean(key, false)
    }

    fun putInt(key: String, value: Int) {
        preferences.edit().putInt(key, value).apply()
    }

    fun getInt(key: String): Int {
        return preferences.getInt(key, -1)
    }

    fun putFloat(key: String, value: Float) {
        preferences.edit().putFloat(key, value).apply()
    }

    fun getFloat(key: String): Float {
        return preferences.getFloat(key, -1f)
    }

    fun clear() {
        preferences.edit().clear().apply()
    }
}