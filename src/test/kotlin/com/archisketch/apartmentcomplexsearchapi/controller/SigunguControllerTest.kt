package com.archisketch.apartmentcomplexsearchapi.controller

import com.archisketch.apartmentcomplexsearchapi.entity.Sigungu
import com.archisketch.apartmentcomplexsearchapi.service.SigunguService
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.junit.jupiter.api.Test
import io.mockk.every
import io.mockk.mockkClass

@WebMvcTest(SigunguController::class)
class SigunguControllerTest(@Autowired private val mockMvc: MockMvc) {

    @MockBean
    private lateinit var sigunguService: SigunguService

    @Test
    fun `Given pidLocCode, when GET request to sigungu, then return list of Sigungu as JSON`() {
        // Given
        val pidLocCode: Long = 1111000000
        val mockSigunguList = listOf(
            mockkClass(Sigungu::class).apply {
                every { pidLocCode } returns 1111000000
                // 나머지 프로퍼티에 대한 모킹은 여기에 추가합니다.
            }
        )
        every { sigunguService.getSigunguByPidLocCode(pidLocCode) } returns mockSigunguList

        // When & Then
        mockMvc.perform(get("/sigungu/$pidLocCode"))
            .andExpect(status().isOk)
        // JSON 응답 내용 검증은 실제 프로퍼티에 따라 jsonPath를 사용하여 구현합니다.
    }
}
