package io.keepcoding.userlist.data.mapper

import io.keepcoding.userlist.data.model.User
import io.keepcoding.userlist.data.model.UserEntity

/**
 * Created by costular on 11/06/2018.
 */
class UserEntityMapper : Mapper<User, UserEntity> {

    override fun transform(input: User): UserEntity =
            UserEntity(input.name.last, input.picture.large)

    override fun transformList(inputList: List<User>): List<UserEntity> =
            inputList.map { transform(it) }

}