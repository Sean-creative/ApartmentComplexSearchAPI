package com.archisketch.apartmentcomplexsearchapi.controller

import com.archisketch.apartmentcomplexsearchapi.dto.UserInfoDto
import com.archisketch.apartmentcomplexsearchapi.service.CylinderService
import com.archisketch.apartmentcomplexsearchapi.service.UserService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cylinder")
@Validated
class CylinderController(private val cylinderService: CylinderService, @Autowired private val userService: UserService) {

    @GetMapping
    fun getCylinder(): ResponseEntity<Map<String, Any>> {
        return ResponseEntity.ok(cylinderService.fetchCylinderData())
    }

    @PostMapping("/info")
    fun saveUserInfo(@Valid @RequestBody userInfo: UserInfoDto): ResponseEntity<Any> {
        val savedUser = userService.saveUser(userInfo)
        return ResponseEntity.ok().body(mapOf(
            "user" to savedUser.user,
            "createdAt" to savedUser.createdAt,
            "message" to "User information saved successfully"))
    }
}