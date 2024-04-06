package com.archisketch.apartmentcomplexsearchapi.service

import com.archisketch.apartmentcomplexsearchapi.entity.ApartmentComplex
import com.archisketch.apartmentcomplexsearchapi.repository.ApartmentComplexRepository
import com.archisketch.apartmentcomplexsearchapi.repository.FloorPlanRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class ApartmentComplexServiceTest {

    @Autowired
    private lateinit var apartmentComplexService: ApartmentComplexService

    @MockBean
    private lateinit var apartmentComplexRepository: ApartmentComplexRepository

    @MockBean
    private lateinit var floorPlanRepository: FloorPlanRepository

    @Test
    fun `Given name return complex details`() {
        val name = "롯데캐슬"
        val complex = mock(ApartmentComplex::class.java)
        given(apartmentComplexRepository.findByName(name)).willReturn(complex)

        val result = apartmentComplexService.getApartmentComplexByName(name)

        // 검증 로직 작성
        val notNull = assertThat(result).isNotNull
        assertThat(result!!.name).isEqualTo(name)
    }
}
