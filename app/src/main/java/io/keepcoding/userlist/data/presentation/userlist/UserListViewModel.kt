package io.keepcoding.userlist.data.presentation.userlist

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.keepcoding.userlist.data.model.UserEntity
import io.keepcoding.userlist.data.repository.UserRepository
import io.keepcoding.userlist.data.repository.datasource.UserFakeDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by costular on 07/06/2018.
 */
class UserListViewModel : ViewModel() {

    val userListState: MutableLiveData<List<UserEntity>> = MutableLiveData()

    private val fakeDataSource = UserFakeDataSource()
    private val userRepository =  UserRepository(fakeDataSource)

    fun loadUserList() {
        userRepository.getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            userListState.value = it
                        },
                        onError = {

                        }
                )
    }

}