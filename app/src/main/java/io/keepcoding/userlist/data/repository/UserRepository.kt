package io.keepcoding.userlist.data.repository

import io.keepcoding.userlist.data.model.UserEntity
import io.keepcoding.userlist.data.repository.datasource.ApiDataSource
import io.keepcoding.userlist.data.repository.datasource.LocalDataSource
import io.reactivex.Flowable

/**
 * Created by costular on 07/06/2018.
 */
class UserRepository(private val localDataSource: LocalDataSource,
                     private val apiDataSource: ApiDataSource) {

    fun getUserList(): Flowable<List<UserEntity>> =
            localDataSource.getUserList()
                    .concatWith(apiDataSource.getUserList())

}