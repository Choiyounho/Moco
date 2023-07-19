package com.soten.data.network.retrofit

import com.soten.data.network.ApiResult
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

internal class ApiResultCallAdapter<R : ApiResult<*>>(
    private val responseType: Type
) : CallAdapter<R, ApiCall<R>> {

    override fun responseType(): Type {
        return responseType
    }

    override fun adapt(call: Call<R>): ApiCall<R> {
        return ApiCall(call)
    }
}
