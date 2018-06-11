package io.keepcoding.userlist.presentation.userdetail

import android.arch.lifecycle.MutableLiveData
import io.keepcoding.userlist.data.model.UserEntity
import io.keepcoding.userlist.data.repository.UserRepository
import io.keepcoding.userlist.presentation.servicelocator.Inject
import io.keepcoding.userlist.util.mvvm.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by costular on 11/06/2018.
 */
class UserDetailViewModel : BaseViewModel() {

    val userState: MutableLiveData<UserEntity> = MutableLiveData()

    fun loadUserById(userId: Long) {
        Inject.userRepository.getUserDetail(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            userState.value = it
                        },
                        onError = {

                        }
                )
                .addTo(compositeDisposable)
    }

}