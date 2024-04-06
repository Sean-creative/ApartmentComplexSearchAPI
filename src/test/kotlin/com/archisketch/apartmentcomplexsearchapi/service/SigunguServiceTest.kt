package com.archisketch.apartmentcomplexsearchapi.service

import com.archisketch.apartmentcomplexsearchapi.dto.SigunguDTO
import com.archisketch.apartmentcomplexsearchapi.entity.Sigungu
import com.archisketch.apartmentcomplexsearchapi.repository.SigunguRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.time.LocalDateTime

class SigunguServiceTest {

    private val sigunguRepository: SigunguRepository = mock(SigunguRepository::class.java)
    private val sigunguService = SigunguService(sigunguRepository)

    @Test
    fun `Given pidLocCode return Sigungu list`() {
        // Given
        val pidLocCode = 1111000000L
        val time = LocalDateTime.now()
        val expectedSigunguDTOList = listOf(
            SigunguDTO(pidLocCode, 2, "서울특별시", "종로구", "none", 126.948899, 37.56582, 127.023365, 37.632375, time)
        )
        `when`(sigunguRepository.findByPidLocCode(pidLocCode)).thenReturn(listOf(
            Sigungu(pidLocCode, 2, "서울특별시", "종로구", "none", 126.948899, 37.56582, 127.023365, 37.632375)
        ))

        // When
        val result = sigunguService.getSigunguByPidLocCode(pidLocCode).first()

        // Then
        assertEquals(pidLocCode, result.pidLocCode)
        assertEquals(2, result.level)
        assertEquals("서울특별시", result.depth1)
        assertEquals("종로구", result.depth2)
    }
}
