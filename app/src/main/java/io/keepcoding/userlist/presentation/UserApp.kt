package io.keepcoding.userlist.presentation

import android.app.Application
import android.preference.PreferenceManager
import com.facebook.stetho.Stetho
import io.keepcoding.userlist.di.components.ApplicationComponent
import io.keepcoding.userlist.di.components.DaggerApplicationComponent
import io.keepcoding.userlist.di.modules.ApplicationModule
import io.keepcoding.userlist.di.modules.DataModule
import io.keepcoding.userlist.util.SettingsManager

/**
 * Created by costular on 11/06/2018.
 */
class UserApp : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

        // DI
        component =
                DaggerApplicationComponent.builder()
                        .applicationModule(ApplicationModule(this))
                        .build()
    }

}