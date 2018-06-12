package io.keepcoding.userlist.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.keepcoding.userlist.data.mapper.UserEntityMapper
import io.keepcoding.userlist.data.model.UserEntity
import io.reactivex.Flowable
import io.reactivex.Maybe

/**
 * Created by costular on 11/06/2018.
 */
@Dao
abstract class UserDao {

    @Query("SELECT * FROM users")
    abstract fun getAllUsers(): Maybe<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(users: List<UserEntity>)

    // TODO replace ???

}