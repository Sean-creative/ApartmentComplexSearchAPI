package com.archisketch.apartmentcomplexsearchapi.service

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.*

class CylinderServiceTest {

    private val client = mock(OkHttpClient::class.java)
    private val cylinderService = CylinderService()

    @Test
    fun `fetchCylinderData returns correct data`() {
        // given
        val jsonMediaType = "application/json".toMediaTypeOrNull()
        val fakeResponseBody = """
                {
                  "product": {
                    "name": "Test Cylinder",
                    "editorAsset": "Test Asset"
                  }
                }
            """.trimIndent().toResponseBody(jsonMediaType)

        val fakeResponse = Response.Builder()
            .request(Request.Builder().url("http://example.com").build())
            .protocol(Protocol.HTTP_1_1)
            .code(200) // HTTP 200 OK
            .message("OK")
            .body(fakeResponseBody)
            .build()

        `when`(client.newCall(any()).execute()).thenReturn(fakeResponse)

        // when
        val result = cylinderService.fetchCylinderData()

        // then
        assertThat(result["name"]).isEqualTo("Test Cylinder")
        assertThat(result["editorAsset"]).isEqualTo("Test Asset")
    }
}
