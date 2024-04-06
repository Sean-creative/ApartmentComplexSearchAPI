package com.archisketch.apartmentcomplexsearchapi.controller

import com.archisketch.apartmentcomplexsearchapi.dto.SigunguDTO
import com.archisketch.apartmentcomplexsearchapi.service.SigunguService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
class SigunguController(val sigunguService: SigunguService) {

    @GetMapping("/sigungu/{pidLocCode}")
    fun getSigungu(@PathVariable pidLocCode: Long): List<SigunguDTO> {
        return sigunguService.getSigunguByPidLocCode(pidLocCode)
    }
}
