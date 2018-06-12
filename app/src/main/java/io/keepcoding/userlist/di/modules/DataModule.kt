package io.keepcoding.userlist.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import io.keepcoding.userlist.data.db.UserDatabase
import io.keepcoding.userlist.data.mapper.UserEntityMapper
import io.keepcoding.userlist.data.net.UserService
import io.keepcoding.userlist.data.repository.UserRepository
import io.keepcoding.userlist.data.repository.datasource.ApiDataSource
import io.keepcoding.userlist.data.repository.datasource.LocalDataSource
import io.keepcoding.userlist.util.SettingsManager
import javax.inject.Singleton

/**
 * Created by costular on 12/06/2018.
 */
@Module
class DataModule {

    @Singleton
    @Provides
    fun provideUserEntityMapper(): UserEntityMapper = UserEntityMapper()

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

    @Singleton
    @Provides
    fun provideSettingsManager(sharedPreferences: SharedPreferences): SettingsManager =
            SettingsManager(sharedPreferences)

    @Singleton
    @Provides
    fun provideDatabase(context: Context): UserDatabase =
            Room.databaseBuilder(context, UserDatabase::class.java, "user.db").build()

    @Singleton
    @Provides
    fun provideLocalDataSource(userDatabase: UserDatabase): LocalDataSource =
            LocalDataSource(userDatabase)

    @Singleton
    @Provides
    fun provideApiDataSource(userService: UserService,
                             userEntityMapper: UserEntityMapper): ApiDataSource =
            ApiDataSource(userService, userEntityMapper)

    @Singleton
    @Provides
    fun provideRepository(localDataSource: LocalDataSource,
                          apiDataSource: ApiDataSource): UserRepository =
            UserRepository(localDataSource, apiDataSource)
}