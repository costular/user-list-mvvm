package io.keepcoding.userlist.presentation.userdetail

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import io.keepcoding.userlist.R
import io.keepcoding.userlist.data.model.UserEntity
import kotlinx.android.synthetic.main.activity_user_detail.*

/**
 * Created by costular on 11/06/2018.
 */
class UserDetailActivity : AppCompatActivity() {

    companion object {
        const val PARAM_USER_ID = "user_id"
    }

    lateinit var userDetailViewModel: UserDetailViewModel
    var userEntity: UserEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        userEntity = intent.getParcelableExtra(PARAM_USER_ID)
        init()
    }

    private fun init() {
        userDetailViewModel = ViewModelProviders.of(this).get(UserDetailViewModel::class.java)
        loadUserData()
    }

    private fun loadUserData() {
        if (userEntity == null) {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
        onUserLoaded(userEntity!!)
    }

    private fun onUserLoaded(userEntity: UserEntity) {
        userDetailName.text = userEntity.name
        Glide.with(this)
                .load(userEntity.avatarUrl)
                .into(userDetailAvatar)
    }

}