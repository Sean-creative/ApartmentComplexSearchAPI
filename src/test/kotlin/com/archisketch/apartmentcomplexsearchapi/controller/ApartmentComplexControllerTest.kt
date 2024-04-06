package com.archisketch.apartmentcomplexsearchapi.controller

import com.archisketch.apartmentcomplexsearchapi.dto.ApartmentComplexDto
import com.archisketch.apartmentcomplexsearchapi.service.ApartmentComplexService
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(ApartmentComplexController::class)
class ApartmentComplexControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var apartmentComplexService: ApartmentComplexService

    @Test
    fun `Given name return apartment complex`() {
        val name = "롯데캐슬"
        val dto = ApartmentComplexDto(1L, name, emptyList(), emptyList())

        given(apartmentComplexService.getApartmentComplexByName(name)).willReturn(dto)

        mockMvc.perform(get("/api/apartment-complexes/$name")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value(name))
    }
}
