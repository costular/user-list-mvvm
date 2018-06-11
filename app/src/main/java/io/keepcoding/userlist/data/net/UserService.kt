package io.keepcoding.userlist.data.net

import io.keepcoding.userlist.data.model.UserApiResponse
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Created by costular on 11/06/2018.
 */
interface UserService {

    @GET("api/?results=20")
    fun getUsers(): Flowable<UserApiResponse>

}