package io.keepcoding.userlist.presentation.userlist

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import io.keepcoding.userlist.data.model.UserEntity
import io.keepcoding.userlist.data.repository.UserRepository
import io.keepcoding.userlist.util.SettingsManager
import io.keepcoding.userlist.util.mvvm.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by costular on 07/06/2018.
 */
class UserListViewModel @Inject constructor(val userRepository: UserRepository,
                                            val settingsManager: SettingsManager): BaseViewModel() {

    val userListState: MutableLiveData<List<UserEntity>> = MutableLiveData()
    val isLoadingState: MutableLiveData<Boolean> = MutableLiveData()

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
                            Log.d("UserViewModel", it.toString())
                        },
                        onComplete = {
                            settingsManager.firstLoad = false
                        }
                )
                .addTo(compositeDisposable)
    }

}