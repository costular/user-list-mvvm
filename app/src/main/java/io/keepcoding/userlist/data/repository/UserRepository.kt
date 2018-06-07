package io.keepcoding.userlist.data.repository

import io.keepcoding.userlist.data.model.UserEntity
import io.keepcoding.userlist.data.repository.datasource.UserFakeDataSource
import io.reactivex.Observable

/**
 * Created by costular on 07/06/2018.
 */
class UserRepository(private val userFakeDataSource: UserFakeDataSource) {

    fun getUserList(): Observable<List<UserEntity>> =
            userFakeDataSource.getUserList()

    fun getUserDetail(userId: Long): Observable<UserEntity> =
            userFakeDataSource.getUserDetail(userId)

}