package com.archisketch.apartmentcomplexsearchapi.controller

import com.archisketch.apartmentcomplexsearchapi.service.CylinderService
import com.archisketch.apartmentcomplexsearchapi.service.UserService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cylinder")
class CylinderController(private val cylinderService: CylinderService, private val userService: UserService) {

}