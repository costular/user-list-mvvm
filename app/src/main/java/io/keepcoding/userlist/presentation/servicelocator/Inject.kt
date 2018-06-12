package io.keepcoding.userlist.presentation.servicelocator

import android.arch.persistence.room.Room
import android.content.Context
import io.keepcoding.userlist.data.db.UserDatabase
import io.keepcoding.userlist.data.mapper.UserEntityMapper
import io.keepcoding.userlist.data.net.UserService
import io.keepcoding.userlist.data.repository.UserRepository
import io.keepcoding.userlist.data.repository.datasource.ApiDataSource
import io.keepcoding.userlist.data.repository.datasource.LocalDataSource
import io.keepcoding.userlist.util.SettingsManager
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by costular on 07/06/2018.
 */
object Inject {

    lateinit var database: UserDatabase

    val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    val userService = retrofit.create(UserService::class.java)

    val userEntityMapper = UserEntityMapper()

    lateinit var settingsManager: SettingsManager

    val apiDataSource = ApiDataSource(userService, userEntityMapper)

    lateinit var localDataSource: LocalDataSource
    lateinit var userRepository: UserRepository

    fun initDatabase(context: Context) {
        database = Room.databaseBuilder(context, UserDatabase::class.java, "user.db").build()
        localDataSource = LocalDataSource(database)
        userRepository = UserRepository(localDataSource, apiDataSource)
    }

}