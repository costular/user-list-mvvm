package io.keepcoding.userlist.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.keepcoding.userlist.util.Navigator
import javax.inject.Singleton

/**
 * Created by costular on 12/06/2018.
 */
@Module
class ApplicationModule(val application: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context = application.applicationContext

    @Singleton
    @Provides
    fun provideNavigator(): Navigator = Navigator()

}