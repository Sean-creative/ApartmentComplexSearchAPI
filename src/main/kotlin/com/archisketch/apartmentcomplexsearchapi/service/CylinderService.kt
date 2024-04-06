package com.archisketch.apartmentcomplexsearchapi.service

import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Service
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

@Service
class CylinderService {
    private val client = OkHttpClient()

    fun fetchCylinderData(): Map<String, Any> {
        val request = Request.Builder()
            .url("https://api.archisketch.com/v1/public/product/YB0Njg-02923BC5C1A84C59")
            .build()

        client.newCall(request).execute().use { response ->
            val responseBody = response.body?.string() ?: throw IllegalArgumentException("No Response from API")
            val mapper = jacksonObjectMapper()
            val rootNode = mapper.readTree(responseBody)
            val productNode = rootNode.path("product")
            val name = productNode.path("name").asText()
            val editorAsset = productNode.path("editorAsset")

            val editorAssetMap: Map<String, String> = mapper.readValue(editorAsset.toString())

            return mapOf("name" to name, "editorAsset" to editorAssetMap)
        }
    }
}