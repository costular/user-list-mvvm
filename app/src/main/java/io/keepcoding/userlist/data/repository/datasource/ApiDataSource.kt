package io.keepcoding.userlist.data.repository.datasource

import io.keepcoding.userlist.data.mapper.UserEntityMapper
import io.keepcoding.userlist.data.model.UserEntity
import io.keepcoding.userlist.data.net.UserService
import io.reactivex.Flowable

/**
 * Created by costular on 11/06/2018.
 */
class ApiDataSource(private val usersService: UserService,
                    private val userEntityMapper: UserEntityMapper) : UserDataSource {

    override fun getUserList(): Flowable<List<UserEntity>> =
            usersService.getUsers()
                    .map { it.results }
                    .map { userEntityMapper.transformList(it) }

}