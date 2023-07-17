package com.soten.moco.network.retrofit

import com.soten.moco.network.ApiResult
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class ApiResultCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type, annotations: Array<out Annotation>, retrofit: Retrofit
    ): CallAdapter<*, *>? {
        // 반환 타입이 Call 이면 따로 처리 안하므로, 그냥 null 반환
        if (Call::class.java != getRawType(returnType)) {
            return null
        }

        // ParameterizedType 인지 먼저 확인한다.
        check(returnType is ParameterizedType) {
            "반환 타입은 반드시 ${ApiCall::class.java.name}<Foo> 또는 ${ApiCall::class.java.name}<out Foo>과 같은 형식 이어야 합니다."
        }

        /**
         * [ApiCall] 타입에서 제네릭에 포함 된 응답 타입을 가져온다
         */
        val responseType = getParameterUpperBound(0, returnType)
        // if the response type is not ApiResponse then we can't handle this type, so we return null
        if (getRawType(responseType) != ApiResult::class.java) {
            return null
        }

        /**
         * 응답 타입이 [ApiResult] 이면 반드시 제네릭을 갖고 있어야 한다.
         */
        check(responseType is ParameterizedType) { "Response must be parameterized as NetworkResponse<Foo> or NetworkResponse<out Foo>" }

        val successBodyType = getParameterUpperBound(0, responseType)

        return ApiResultCallAdapter<ApiResult<*>>(successBodyType)
    }
}