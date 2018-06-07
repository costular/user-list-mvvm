package io.keepcoding.userlist.data.model

import android.support.v7.util.DiffUtil

/**
 * Created by costular on 07/06/2018.
 */
class UserEntityDiff : DiffUtil.ItemCallback<UserEntity>() {

    override fun areItemsTheSame(oldItem: UserEntity?, newItem: UserEntity?): Boolean =
            oldItem?.userId == newItem?.userId

    override fun areContentsTheSame(oldItem: UserEntity?, newItem: UserEntity?): Boolean =
            oldItem == newItem

}