package com.tjackapps.rapidtouch.preferences.androidglue

import com.tjackapps.rapidtouch.preferences.androidimpl.PreferencesAndroidImpl
import com.tjackapps.rapidtouch.preferences.api.Preferences
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface PreferencesAndroidModule {

    @Binds
    @Singleton
    fun bindsPreferences(
        preferencesAndroidImpl: PreferencesAndroidImpl,
    ): Preferences
}
