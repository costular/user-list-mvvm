package io.keepcoding.userlist.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.keepcoding.userlist.util.Navigator

/**
 * Created by costular on 12/06/2018.
 */
@Module
class ApplicationModule(val application: Application) {

    @Provides
    fun provideContext(): Context = application.applicationContext

    @Provides
    fun provideNavigator(): Navigator = Navigator()

}