package io.keepcoding.userlist.data.repository.datasource

import io.keepcoding.userlist.data.model.UserEntity
import io.reactivex.Observable

/**
 * Created by costular on 08/06/2018.
 */
class UserFakeDataSource2 : UserDataSource {

    val userList = listOf(
            UserEntity(5, "Roger", "https://randomuser.me/api/portraits/men/75.jpg"),
            UserEntity(6, "Onur", "https://randomuser.me/api/portraits/men/4.jpg")
    )

    override fun getUserList(): Observable<List<UserEntity>> =
            Observable.just(userList)

    override fun getUserDetail(userId: Long): Observable<UserEntity> =
            Observable.just(userList.find { it.userId == userId })

}
