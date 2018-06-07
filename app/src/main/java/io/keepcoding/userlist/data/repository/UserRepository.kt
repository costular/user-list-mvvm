package io.keepcoding.userlist.data.repository

import io.keepcoding.userlist.data.model.UserEntity
import io.keepcoding.userlist.data.repository.datasource.UserFakeDataSource
import io.keepcoding.userlist.data.repository.datasource.UserFakeDataSource2
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by costular on 07/06/2018.
 */
class UserRepository(private val userFakeDataSource: UserFakeDataSource,
                     private val userFakeDataSource2: UserFakeDataSource2) {

    fun getUserList(): Observable<List<UserEntity>> =
            userFakeDataSource.getUserList()
                    .concatWith(userFakeDataSource2.getUserList())
                    .delay(1, TimeUnit.SECONDS)

    fun getUserDetail(userId: Long): Observable<UserEntity> =
            userFakeDataSource.getUserDetail(userId)
                    .concatWith(userFakeDataSource2.getUserDetail(userId))
                    .delay(1, TimeUnit.SECONDS)

}