package com.soten.data.extensins

import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer


internal val JSON: Json = Json {
    encodeDefaults = true
    ignoreUnknownKeys = true
}

internal inline fun <reified T : Any> serializeObject(obj: T): String {
    return JSON.encodeToString(serializer(), obj)
}

internal inline fun <reified T : Any> deserializeObject(jsonString: String): T {
    return JSON.decodeFromString(serializer(), jsonString)
}
