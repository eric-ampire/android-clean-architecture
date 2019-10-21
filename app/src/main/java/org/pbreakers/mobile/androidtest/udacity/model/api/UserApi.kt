package org.pbreakers.mobile.androidtest.udacity.model.api

import kotlinx.coroutines.Deferred
import org.pbreakers.mobile.androidtest.udacity.model.entity.GithubUser
import retrofit2.http.GET

interface UserApi {

    @GET("users")
    fun getAllAsync(): Deferred<List<GithubUser>>
}