package com.archisketch.apartmentcomplexsearchapi.controller

import com.archisketch.apartmentcomplexsearchapi.dto.ApartmentComplexDto
import com.archisketch.apartmentcomplexsearchapi.dto.FloorPlanDto
import com.archisketch.apartmentcomplexsearchapi.service.ApartmentComplexService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/apartment-complexes")
@Validated
class ApartmentComplexController @Autowired constructor(
    private val apartmentComplexService: ApartmentComplexService
) {

    @GetMapping("/{name}")
    fun getApartmentComplexByName(@PathVariable name: String): ResponseEntity<ApartmentComplexDto> {
        val apartmentComplex = apartmentComplexService.getApartmentComplexByName(name)
        return if (apartmentComplex != null) ResponseEntity.ok(apartmentComplex) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @GetMapping("/road-address/{roadAddress}")
    fun getApartmentComplexesByRoadAddress(@PathVariable roadAddress: String): ResponseEntity<List<ApartmentComplexDto>> {
        val complexes = apartmentComplexService.getApartmentComplexesByRoadAddress(roadAddress)
        return ResponseEntity.ok(complexes)
    }

    @GetMapping("/jibun-address/{jibunAddress}")
    fun getApartmentComplexesByJibunAddress(@PathVariable jibunAddress: String): ResponseEntity<List<ApartmentComplexDto>> {
        val complexes = apartmentComplexService.getApartmentComplexesByJibunAddress(jibunAddress)
        return ResponseEntity.ok(complexes)
    }

    @GetMapping("/floor-plans")
    fun getFloorPlansByCriteria(
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) type: String?,
        @RequestParam(required = false) isExpanded: Boolean?,
        @RequestParam(required = false) sortDirection: Sort.Direction = Sort.Direction.ASC
    ): ResponseEntity<List<FloorPlanDto>> {
        val floorPlans = when {
            type != null && name != null -> apartmentComplexService.getFloorPlansByComplexNameAndType(name, type, sortDirection)
            isExpanded != null && name != null -> apartmentComplexService.getFloorPlansByComplexNameAndExpansion(name, isExpanded, sortDirection)
            else -> emptyList()
        }
        return ResponseEntity.ok(floorPlans)
    }
}
