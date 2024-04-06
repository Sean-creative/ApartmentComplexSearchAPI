package com.archisketch.apartmentcomplexsearchapi.repository

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class ApartmentComplexRepositoryTest {

    @Autowired
    private lateinit var apartmentComplexRepository: ApartmentComplexRepository

    @Test
    fun `findByName return ApartmentComplex`() {
        // 저장 로직
        // val savedComplex = apartmentComplexRepository.save(ApartmentComplex("롯데캐슬"))

        // 검증 로직
        // val foundComplex = apartmentComplexRepository.findByName("롯데캐슬")
        // assertThat(foundComplex).isNotNull
        // assertThat(foundComplex.name).isEqualTo("롯데캐슬")
    }
}
