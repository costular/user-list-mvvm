package io.keepcoding.userlist.data.repository.datasource

import io.keepcoding.userlist.data.db.UserDatabase
import io.keepcoding.userlist.data.model.UserEntity
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * Created by costular on 11/06/2018.
 */
class LocalDataSource(val userDatabase: UserDatabase) : UserDataSource {

    override fun getUserList(): Flowable<List<UserEntity>> =
            userDatabase
                    .getUserDao()
                    .getAllUsers()
                    .toFlowable()

    fun saveUsers(users: List<UserEntity>) {
        Observable.fromCallable {
            userDatabase.getUserDao().insertAll(users)
        }
                .subscribeOn(Schedulers.io())
                .subscribe()
    }

}