package com.archisketch.apartmentcomplexsearchapi.repository

import com.archisketch.apartmentcomplexsearchapi.entity.Sigungu
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest
class SigunguRepositoryTest {

    @Autowired
    private lateinit var sigunguRepository: SigunguRepository

    @Test
    fun `Given pidLocCode return Sigungu list`() {
        // Given
        val pidLocCode = 1111000000L
        val mockSigungu = Sigungu(pidLocCode, 2, "서울특별시", "종로구", "none", 126.948899, 37.56582, 127.023365, 37.632375)
        sigunguRepository.save(mockSigungu)

        // When
        val result = sigunguRepository.findByPidLocCode(pidLocCode)

        // Then
        assert(result.isNotEmpty())
        assert(result[0].depth1 == "서울특별시")
        assert(result[0].pidLocCode == pidLocCode)
    }
}
