package io.keepcoding.userlist.di.modules

import dagger.Module
import dagger.Provides
import io.keepcoding.userlist.data.net.UserService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by costular on 12/06/2018.
 */
@Module
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    fun provideUsersService(retrofit: Retrofit): UserService =
            retrofit.create(UserService::class.java)

}