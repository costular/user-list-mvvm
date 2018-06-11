package io.keepcoding.userlist.presentation.servicelocator

import android.content.SharedPreferences
import io.keepcoding.userlist.data.repository.UserRepository
import io.keepcoding.userlist.data.repository.datasource.UserFakeDataSource
import io.keepcoding.userlist.data.repository.datasource.UserFakeDataSource2
import io.keepcoding.userlist.util.SettingsManager

/**
 * Created by costular on 07/06/2018.
 */
object Inject {

    lateinit var settingsManager: SettingsManager

    val fakeDataSource = UserFakeDataSource()
    val fakeDataSource2 = UserFakeDataSource2()
    val userRepository =  UserRepository(fakeDataSource, fakeDataSource2)

}