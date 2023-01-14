package com.tjackapps.rapidtouch.preferences.api

interface Preferences {
    suspend fun putString(key: String, value: String)
    suspend fun getString(key: String, defaultValue: String = ""): String
    suspend fun putBoolean(key: String, value: Boolean)
    suspend fun getBoolean(key: String, defaultValue: Boolean = false): Boolean
    suspend fun putInt(key: String, value: Int)
    suspend fun getInt(key: String, defaultValue: Int = 0): Int
    suspend fun putDouble(key: String, value: Double)
    suspend fun getDouble(key: String, defaultValue: Double = 0.0): Double
    suspend fun delete()
}