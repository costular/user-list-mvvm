package io.keepcoding.userlist.data.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by costular on 07/06/2018.
 */

@Parcelize
data class UserEntity(
        val name: String,
        val avatarUrl: String
): Parcelable