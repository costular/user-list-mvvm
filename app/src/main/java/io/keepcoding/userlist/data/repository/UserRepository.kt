package io.keepcoding.userlist.data.repository

import io.keepcoding.userlist.data.model.UserEntity
import io.keepcoding.userlist.data.repository.datasource.ApiDataSource
import io.reactivex.Flowable
import java.util.concurrent.TimeUnit

/**
 * Created by costular on 07/06/2018.
 */
class UserRepository(private val apiDataSource: ApiDataSource) {

    fun getUserList(): Flowable<List<UserEntity>> =
            apiDataSource.getUserList()
                    .delay(1, TimeUnit.SECONDS)

}