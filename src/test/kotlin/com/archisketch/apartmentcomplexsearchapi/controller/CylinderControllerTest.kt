package com.archisketch.apartmentcomplexsearchapi.controller

import com.archisketch.apartmentcomplexsearchapi.dto.UserInfoDto
import com.archisketch.apartmentcomplexsearchapi.entity.User
import com.archisketch.apartmentcomplexsearchapi.service.CylinderService
import com.archisketch.apartmentcomplexsearchapi.service.UserService
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(CylinderController::class)
class CylinderControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var cylinderService: CylinderService

    @MockBean
    private lateinit var userService: UserService

    @Test
    fun `getCylinder returns data`() {
        // Given
        val cylinderData = mapOf(
            "name" to "[샘플] FLOOR COMPOSITION",
            "editorAsset" to "https://resources.archisketch.com/product/YB0Njg-02923BC5C1A84C59/03-05-2022_05-41-12/2d/editor.png"
        )
        every { cylinderService.fetchCylinderData() } returns cylinderData

        // When & Then
        mockMvc.perform(get("/cylinder/")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().json("""
                    {"name":"[샘플] FLOOR COMPOSITION","editorAsset":"https://resources.archisketch.com/product/YB0Njg-02923BC5C1A84C59/03-05-2022_05-41-12/2d/editor.png"}
                """.trimIndent()))
    }

    @Test
    fun `saveUserInfo returns message`() {
        // Given
        val userInfoDto = UserInfoDto(name = "Test User", password = "password123")
        val savedUser = User( name = "Test User", password = "password123")
        every { userService.saveUser(any()) } returns savedUser

        // When & Then
        mockMvc.perform(post("/cylinder/info")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                    {"name":"Test User","password":"password123"}
                """.trimIndent()))
            .andExpect(status().isOk)
            .andExpect(content().json("""
                    {"user":{"name":"Test User","password":"password123"},"message":"User saved"}
                """.trimIndent()))
    }
}