package io.keepcoding.userlist.di.components

import dagger.Component
import io.keepcoding.userlist.di.modules.ApplicationModule
import io.keepcoding.userlist.di.modules.DataModule
import io.keepcoding.userlist.di.modules.NetModule
import io.keepcoding.userlist.presentation.userlist.UserListActivity
import io.keepcoding.userlist.util.mvvm.ViewModelModule

/**
 * Created by costular on 12/06/2018.
 */
@Component(modules = [
    ApplicationModule::class,
    NetModule::class,
    DataModule::class,
    ViewModelModule::class
])
interface ApplicationComponent {

    fun inject(userListActivity: UserListActivity)

}