package io.keepcoding.userlist.presentation.servicelocator

import io.keepcoding.userlist.data.repository.UserRepository
import io.keepcoding.userlist.data.repository.datasource.UserFakeDataSource
import io.keepcoding.userlist.data.repository.datasource.UserFakeDataSource2

/**
 * Created by costular on 07/06/2018.
 */
object Inject {

    val fakeDataSource = UserFakeDataSource()
    val fakeDataSource2 = UserFakeDataSource2()
    val userRepository =  UserRepository(fakeDataSource, fakeDataSource2)

}