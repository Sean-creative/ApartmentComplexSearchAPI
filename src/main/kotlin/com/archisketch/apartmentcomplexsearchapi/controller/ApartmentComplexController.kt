package com.archisketch.apartmentcomplexsearchapi.controller

import com.archisketch.apartmentcomplexsearchapi.dto.ApartmentComplexDto
import com.archisketch.apartmentcomplexsearchapi.dto.FloorPlanDto
import com.archisketch.apartmentcomplexsearchapi.service.ApartmentComplexService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/apartment-complexes")
class ApartmentComplexController @Autowired constructor(
    private val apartmentComplexService: ApartmentComplexService
) {

    @GetMapping("/{name}")
    fun getApartmentComplexByName(@PathVariable name: String): ResponseEntity<ApartmentComplexDto> {

        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @GetMapping("/road-address/{roadAddress}")
    fun getApartmentComplexesByRoadAddress(@PathVariable roadAddress: String): ResponseEntity<List<ApartmentComplexDto>> {

        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @GetMapping("/jibun-address/{jibunAddress}")
    fun getApartmentComplexesByJibunAddress(@PathVariable jibunAddress: String): ResponseEntity<List<ApartmentComplexDto>> {

        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @GetMapping("/floor-plans")
    fun getFloorPlansByCriteria(
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) type: String?,
        @RequestParam(required = false) isExpanded: Boolean?,
        @RequestParam(required = false) sortDirection: Sort.Direction = Sort.Direction.ASC
    ): ResponseEntity<List<FloorPlanDto>> {

        return ResponseEntity.ok(listOf())
    }
}
