package com.archisketch.apartmentcomplexsearchapi.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.mockk.every
import io.mockk.mockk
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CylinderServiceTest {

    private val client = mockk<OkHttpClient>()
    private val objectMapper = jacksonObjectMapper() // 이 부분은 실제 ObjectMapper 인스턴스를 사용하거나 목킹할 수 있습니다.
    private val cylinderService = CylinderService()

    @Test
    fun `fetchCylinderData returns correct data`() {
        // given
        val fakeResponseBody = """
                {
                  "product": {
                    "name": "Test Cylinder",
                    "editorAsset": "Test Asset"
                  }
                }
            """.trimIndent().toResponseBody("application/json".toMediaTypeOrNull())

        val fakeResponse = Response.Builder()
            .request(Request.Builder().url("http://example.com").build())
            .protocol(Protocol.HTTP_1_1)
            .code(200) // HTTP 200 OK
            .message("")
            .body(fakeResponseBody)
            .build()

        every { client.newCall(any()).execute() } returns fakeResponse

        // when
        val result = cylinderService.fetchCylinderData()

        // then
        assertThat(result["name"]).isEqualTo("Test Cylinder")
        assertThat(result["editorAsset"]).isEqualTo("Test Asset")
    }
}