package io.keepcoding.userlist.data.repository.datasource

import io.keepcoding.userlist.data.model.UserEntity
import io.reactivex.Observable

/**
 * Created by costular on 07/06/2018.
 */
class UserFakeDataSource : UserDataSource {

    val userList = listOf(
            UserEntity(1, "Tyrone", "https://randomuser.me/api/portraits/men/40.jpg"),
            UserEntity(2, "Eelis", "https://randomuser.me/api/portraits/men/24.jpg"),
            UserEntity(3, "Isla", "https://randomuser.me/api/portraits/women/63.jpg"),
            UserEntity(4, "Mathias", "https://randomuser.me/api/portraits/men/41.jpg")
    )

    override fun getUserList(): Observable<List<UserEntity>> =
            Observable.just(userList)

    override fun getUserDetail(userId: Long): Observable<UserEntity> {
        val user = userList.find { it.userId == userId }
        return if (user != null) {
            Observable.just(user)
        } else {
            Observable.empty()
        }
    }
}