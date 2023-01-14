package com.tjackapps.rapidtouch.preferences.androidimpl

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.tjackapps.rapidtouch.preferences.api.Preferences
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import androidx.datastore.preferences.core.Preferences as DataStorePreferences

class PreferencesAndroidImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : Preferences {

    override suspend fun putString(key: String, value: String) {
        val preferencesKey = stringPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun getString(key: String, defaultValue: String): String {
        val preferencesKey = stringPreferencesKey(key)
        return context.dataStore.data
            .map { preferences ->
                preferences[preferencesKey] ?: defaultValue
            }
            .first()
    }

    override suspend fun putBoolean(key: String, value: Boolean) {
        val preferencesKey = booleanPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        val preferencesKey = booleanPreferencesKey(key)
        return context.dataStore.data
            .map { preferences ->
                preferences[preferencesKey] ?: defaultValue
            }
            .first()
    }

    override suspend fun putInt(key: String, value: Int) {
        val preferencesKey = intPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun getInt(key: String, defaultValue: Int): Int {
        val preferencesKey = intPreferencesKey(key)
        return context.dataStore.data
            .map { preferences ->
                preferences[preferencesKey] ?: defaultValue
            }
            .first()
    }

    override suspend fun putDouble(key: String, value: Double) {
        val preferencesKey = doublePreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun getDouble(key: String, defaultValue: Double): Double {
        val preferencesKey = doublePreferencesKey(key)
        return context.dataStore.data
            .map { preferences ->
                preferences[preferencesKey] ?: defaultValue
            }
            .first()
    }

    override suspend fun delete() {
        context.dataStore.edit {
            it.clear()
        }
    }

    companion object {
        private const val DATA_STORE_KEY = "preferences"
        private val Context.dataStore: DataStore<DataStorePreferences> by preferencesDataStore(name = DATA_STORE_KEY)
    }
}
