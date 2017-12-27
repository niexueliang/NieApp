package com.xly.netservice.net

import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 说明：
 * Created by code_nil on 2017/12/21.
 */
interface ApiService {
    @GET("top250")
    fun getTopMovie(@Query("start") start: Int, @Query("count") count: Int): Observable<JsonObject>
}