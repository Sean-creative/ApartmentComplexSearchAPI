package com.archisketch.apartmentcomplexsearchapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {

    @GetMapping("/health")
    fun checkHealth(): String {
        return "1"
    }
}