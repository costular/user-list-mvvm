package io.keepcoding.userlist.data.repository.datasource

import io.keepcoding.userlist.data.model.UserEntity
import io.reactivex.Observable

/**
 * Created by costular on 07/06/2018.
 */
interface UserDataSource {

    fun getUserList(): Observable<List<UserEntity>>
    fun getUserDetail(userId: Long): Observable<UserEntity>

}