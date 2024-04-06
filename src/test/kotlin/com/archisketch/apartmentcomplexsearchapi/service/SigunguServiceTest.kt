package com.archisketch.apartmentcomplexsearchapi.service

import com.archisketch.apartmentcomplexsearchapi.entity.Sigungu
import com.archisketch.apartmentcomplexsearchapi.repository.SigunguRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class SigunguServiceTest {

    private val sigunguRepository: SigunguRepository = mockk(relaxed = true)
    private val sigunguService = SigunguService(sigunguRepository)

    @Test
    fun `Given pidLocCode return Sigungu list`() = runBlocking {
        // Given
        val pidLocCode = 1111000000L
        val expectedSigunguList = listOf(
            Sigungu(2, "서울특별시", "종로구", "none", 126.948899, 37.56582, 127.023365, 37.632375)
        )
        coEvery { sigunguRepository.findByPidLocCode(pidLocCode) } returns expectedSigunguList

        // When
        val result = sigunguService.getSigunguByPidLocCode(pidLocCode)

        // Then
        assertEquals(expectedSigunguList, result)
    }
}
