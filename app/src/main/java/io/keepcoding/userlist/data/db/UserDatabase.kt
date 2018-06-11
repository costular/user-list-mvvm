package io.keepcoding.userlist.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import io.keepcoding.userlist.data.model.UserEntity

/**
 * Created by costular on 11/06/2018.
 */
@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

}