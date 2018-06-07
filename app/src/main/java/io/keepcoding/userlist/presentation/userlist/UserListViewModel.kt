package io.keepcoding.userlist.presentation.userlist

import android.arch.lifecycle.MutableLiveData
import io.keepcoding.userlist.data.model.UserEntity
import io.keepcoding.userlist.data.repository.UserRepository
import io.keepcoding.userlist.data.repository.datasource.UserFakeDataSource
import io.keepcoding.userlist.util.mvvm.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by costular on 07/06/2018.
 */
class UserListViewModel : BaseViewModel() {

    val userListState: MutableLiveData<List<UserEntity>> = MutableLiveData()
    val isLoadingState: MutableLiveData<Boolean> = MutableLiveData()

    // TODO mejorar las dependencias (Service Locator)
    private val fakeDataSource = UserFakeDataSource()
    private val userRepository =  UserRepository(fakeDataSource)

    fun loadUserList() {
        userRepository.getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoadingState.postValue(true) }
                .doOnTerminate { isLoadingState.postValue(false) }
                .subscribeBy(
                        onNext = {
                            userListState.value = it
                        },
                        onError = {

                        }
                )
                .addTo(compositeDisposable)
    }

}