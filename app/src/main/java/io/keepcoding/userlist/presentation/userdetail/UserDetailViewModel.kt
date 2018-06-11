package io.keepcoding.userlist.presentation.userdetail

import android.arch.lifecycle.MutableLiveData
import io.keepcoding.userlist.data.model.UserEntity
import io.keepcoding.userlist.util.mvvm.BaseViewModel

/**
 * Created by costular on 11/06/2018.
 */
class UserDetailViewModel : BaseViewModel() {

    val userState: MutableLiveData<UserEntity> = MutableLiveData()

}