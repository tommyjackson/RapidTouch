package com.tjackapps.rapidtouch.repository.androidglue

import com.tjackapps.rapidtouch.repository.androidimpl.HighScoreRepositoryAndroidImpl
import com.tjackapps.rapidtouch.repository.api.HighScoreRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryAndroidModule {

    @Binds
    @Singleton
    fun bindsHighScoreRepository(
        highScoreRepository: HighScoreRepositoryAndroidImpl,
    ): HighScoreRepository
}
