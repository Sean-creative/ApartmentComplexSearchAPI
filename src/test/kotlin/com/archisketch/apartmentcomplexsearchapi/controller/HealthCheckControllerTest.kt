package com.archisketch.apartmentcomplexsearchapi.controller

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(MockKExtension::class)
@WebMvcTest(HealthCheckController::class)
class HealthCheckControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `Given health endpoint, when GET request, then return 1`() {
        // given
        val endpoint = "/health"

        // when
        val performGet = mockMvc.perform(get(endpoint))

        // then
        performGet.andExpect(status().isOk)
            .andExpect(content().string("1"))
    }
}