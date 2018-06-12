package io.keepcoding.userlist.presentation

import android.app.Application
import android.preference.PreferenceManager
import com.facebook.stetho.Stetho
import io.keepcoding.userlist.presentation.servicelocator.Inject
import io.keepcoding.userlist.util.SettingsManager

/**
 * Created by costular on 11/06/2018.
 */
class UserApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        Inject.initDatabase(this)
        Inject.settingsManager =
                SettingsManager(PreferenceManager.getDefaultSharedPreferences(this))
    }

}