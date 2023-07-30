package app.neonorbit.mrvpatchmanager

import android.content.SharedPreferences
import app.neonorbit.mrvpatchmanager.keystore.KeystoreData
import app.neonorbit.mrvpatchmanager.ui.settings.PreferenceFragment

@Suppress("unused")
object DefaultPreference {
    private val preferences: SharedPreferences get() = AppServices.preferences

    private const val KEY_PREF_APK_SERVER = PreferenceFragment.KEY_PREF_APK_SERVER
    private const val KEY_PREF_FIX_CONFLICT = PreferenceFragment.KEY_PREF_FIX_CONFLICT
    private const val KEY_PREF_MASK_PACKAGE = PreferenceFragment.KEY_PREF_MASK_PACKAGE
    private const val KEY_PREF_FALLBACK_MODE = PreferenceFragment.KEY_PREF_FALLBACK_MODE
    private const val KEY_PREF_EXTRA_MODULES = PreferenceFragment.KEY_PREF_EXTRA_MODULES
    private const val KEY_PREF_CUSTOM_KEYSTORE = PreferenceFragment.KEY_PREF_CUSTOM_KEYSTORE

    fun getApkServer(): String? = getString(KEY_PREF_APK_SERVER)
    fun isFixConflictEnabled(): Boolean = getBoolean(KEY_PREF_FIX_CONFLICT)
    fun isPackageMaskEnabled(): Boolean = getBoolean(KEY_PREF_MASK_PACKAGE)
    fun isFallbackModeEnabled(): Boolean = getBoolean(KEY_PREF_FALLBACK_MODE)
    fun getExtraModules(): List<String>? = getString(KEY_PREF_EXTRA_MODULES)?.split(',')
    fun getCustomKeystore(): KeystoreData? = getString(KEY_PREF_CUSTOM_KEYSTORE)?.parseJson()

    fun getString(key: String): String? {
        return preferences.getString(key, null)
    }

    fun setString(key: String, value: String?) {
        if (value == null) remove(key)
        else preferences.edit().putString(key, value).apply()
    }

    private fun getBoolean(key: String): Boolean {
        return preferences.getBoolean(key, false)
    }

    private fun setBoolean(key: String, value: Boolean) {
        preferences.edit().putBoolean(key, value).apply()
    }

    private fun remove(key: String) {
        preferences.edit().remove(key).apply()
    }
}
