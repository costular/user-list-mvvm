package io.keepcoding.userlist.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by costular on 07/06/2018.
 */
@Entity(tableName = "users")
@Parcelize
data class UserEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val name: String,
        @ColumnInfo(name = "avatar_url")
        val avatarUrl: String
): Parcelable