package io.keepcoding.userlist.data.repository.datasource

import io.keepcoding.userlist.data.model.UserEntity
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by costular on 07/06/2018.
 */
class UserFakeDataSource : UserDataSource {

    val userList = listOf(
            UserEntity("Tyrone", "https://randomuser.me/api/portraits/men/40.jpg"),
            UserEntity("Eelis", "https://randomuser.me/api/portraits/men/24.jpg"),
            UserEntity("Isla", "https://randomuser.me/api/portraits/women/63.jpg"),
            UserEntity("Mathias", "https://randomuser.me/api/portraits/men/41.jpg")
    )

    override fun getUserList(): Flowable<List<UserEntity>> =
            Flowable.just(userList)
}