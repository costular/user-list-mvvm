package io.keepcoding.userlist.util

import android.app.Activity
import android.content.Intent
import io.keepcoding.userlist.presentation.userdetail.UserDetailActivity

/**
 * Created by costular on 11/06/2018.
 */
object Navigator {

    fun openUserDetail(activity: Activity, userId: Long) {
        val intent = Intent(activity, UserDetailActivity::class.java)
        intent.putExtra(UserDetailActivity.PARAM_USER_ID, userId)
        activity.startActivity(intent)
    }

}