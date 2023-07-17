package com.soten.moco.network.retrofit

import com.soten.moco.network.ApiResult
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class ApiCall<T: ApiResult<*>>(
    private val call: Call<T>
) : Call<T> {

    override fun clone(): Call<T> = ApiCall(call.clone())

    override fun execute(): Response<T> {
        throw UnsupportedOperationException("execute() 지원 X")
    }

    override fun isExecuted(): Boolean = call.isExecuted

    override fun cancel() = call.cancel()

    override fun isCanceled(): Boolean = call.isCanceled

    override fun request(): Request = call.request()

    override fun timeout(): Timeout = call.timeout()

    override fun enqueue(callback: Callback<T>) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val newResponse: Response<T> = Response.success(response.body())
                callback.onResponse(
                    this@ApiCall,
                    newResponse
                )
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                val networkResponse:T = when (t) {
                    is IOException -> ApiResult.NetworkError(t)
                    else -> ApiResult.Unexpected(t)
                } as T
                callback.onResponse(this@ApiCall, Response.success(networkResponse))
            }
        })
    }
}