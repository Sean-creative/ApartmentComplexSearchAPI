package com.archisketch.apartmentcomplexsearchapi.service

import com.archisketch.apartmentcomplexsearchapi.dto.AddressDto
import com.archisketch.apartmentcomplexsearchapi.dto.ApartmentComplexDto
import com.archisketch.apartmentcomplexsearchapi.dto.FloorPlanDto
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ApartmentComplexService {
    val addresses = listOf(AddressDto(": 서울특별시 강동구 상암로 224, 상암로 225", "서울특별시 강동구 상일동 519, 상일동 520"))
    val floorPlans = listOf(FloorPlanDto("112B", true, 1.0, 1.0, "" ))

    fun getApartmentComplexByName(name: String): ApartmentComplexDto? {

        return ApartmentComplexDto(1L, "sean", addresses, floorPlans)
    }

    fun getApartmentComplexesByRoadAddress(roadAddress: String): List<ApartmentComplexDto> {

        return listOf(ApartmentComplexDto(1L, "sean", addresses, floorPlans))
    }

    fun getApartmentComplexesByJibunAddress(jibunAddress: String): List<ApartmentComplexDto> {

        return listOf(ApartmentComplexDto(1L, "sean", addresses, floorPlans))
    }

    fun getFloorPlansByComplexNameAndType(name: String, type: String, sortDirection: Sort.Direction): List<FloorPlanDto> {

        return floorPlans
    }

    fun getFloorPlansByComplexNameAndExpansion(name: String, isExpanded: Boolean, sortDirection: Sort.Direction): List<FloorPlanDto> {

        return floorPlans
    }
}
