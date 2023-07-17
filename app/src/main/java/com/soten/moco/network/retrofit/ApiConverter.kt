package com.soten.moco.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.soten.moco.network.ApiResult
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class KotlinxConverter(private val json: Json = JSON) :
    Converter<ResponseBody, ApiResult<Any>> {

    override fun convert(value: ResponseBody): ApiResult<Any> {
        val jsonString = value.string()
        val jsonObject = json.parseToJsonElement(jsonString) as JsonObject

        val stat: String = jsonObject["stat"]?.jsonPrimitive?.contentOrNull
            ?: throw IllegalArgumentException("Invalid response: missing 'stat' field")
        val code: Int = jsonObject["code"]?.jsonPrimitive?.intOrNull ?: 0
        val message: String = jsonObject["message"]?.jsonPrimitive?.contentOrNull ?: ""

        return when (stat) {
            "ok" -> {
                val deserializedData = json.test<Any>(jsonString)
                ApiResult.Success(deserializedData)
            }

            else -> ApiResult.Failure(code, message)
        }
    }
}

class Fac : Converter.Factory() {

    private val originalMoshiConverterFactory = Json.asConverterFactory("application/json".toMediaType())

    companion object {
        fun create(): Fac {
            return Fac()
        }
    }

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *> {
        return KotlinxConverter()
    }

    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<Annotation>,
        methodAnnotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<*, RequestBody>? {
        return originalMoshiConverterFactory.requestBodyConverter(
            type,
            parameterAnnotations,
            methodAnnotations,
            retrofit
        )
    }

    override fun stringConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<*, String>? {
        return originalMoshiConverterFactory.stringConverter(type, annotations, retrofit)
    }
}

private inline fun <reified T : Any> Json.test(text: String): T {
    return this.decodeFromString(text)
}

val JSON: Json = Json {
    encodeDefaults = true
    ignoreUnknownKeys = true
}

inline fun <reified T : Any> serializeObject(obj: T): String {
    return JSON.encodeToString(serializer(), obj)
}

inline fun <reified T : Any> deserializeObject(jsonString: String): T {
    return JSON.decodeFromString(serializer(), jsonString)
}
