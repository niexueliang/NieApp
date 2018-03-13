package com.nie.nieapp.net

import com.google.gson.JsonObject
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/**
 * 说明：
 * Created by code_nil on 2017/12/21.
 */
interface ApiService {
    @GET("top250")
    fun getTopMovie(@Query("start") start: Int, @Query("count") count: Int): Observable<JsonObject>

    @Multipart
    @POST("upload.action")
    fun uploadFile(@Part partList: List<MultipartBody.Part>): Call<ResponseBody>
}