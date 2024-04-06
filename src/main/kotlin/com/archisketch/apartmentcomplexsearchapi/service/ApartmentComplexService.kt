package com.archisketch.apartmentcomplexsearchapi.service

import com.archisketch.apartmentcomplexsearchapi.dto.AddressDto
import com.archisketch.apartmentcomplexsearchapi.dto.ApartmentComplexDto
import com.archisketch.apartmentcomplexsearchapi.dto.FloorPlanDto
import com.archisketch.apartmentcomplexsearchapi.repository.ApartmentComplexRepository
import com.archisketch.apartmentcomplexsearchapi.repository.FloorPlanRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ApartmentComplexService @Autowired constructor(
    private val apartmentComplexRepository: ApartmentComplexRepository,
    private val floorPlanRepository: FloorPlanRepository
) {
    fun getApartmentComplexByName(name: String): ApartmentComplexDto? {
        println("name : $name")
        val a = apartmentComplexRepository.findByName(name)?:null
        println("a : $a")
        return apartmentComplexRepository.findByName(name)?.let { complex ->
            ApartmentComplexDto(
                id = complex.id!!,
                name = complex.name!!,
                addresses = complex.addresses.map { address ->
                    AddressDto(roadAddress = address.roadAddress!!, jibunAddress = address.jibunAddress!!)
                },
                floorPlans = complex.floorPlans.map { plan ->
                    FloorPlanDto(
                        type = plan.type!!,
                        isExpanded = plan.isExpanded!!,
                        exclusiveArea = plan.exclusiveArea!!,
                        supplyArea = plan.supplyArea!!,
                        imageUrl = plan.imageUrl!!
                    )
                }
            )
        }
    }

    fun getApartmentComplexesByRoadAddress(roadAddress: String): List<ApartmentComplexDto> {
        return apartmentComplexRepository.findByAddressesRoadAddress(roadAddress).map { complex ->
            ApartmentComplexDto(
                id = complex.id!!,
                name = complex.name!!,
                addresses = complex.addresses.map { address ->
                    AddressDto(roadAddress = address.roadAddress!!, jibunAddress = address.jibunAddress!!)
                },
                floorPlans = complex.floorPlans.map { plan ->
                    FloorPlanDto(
                        type = plan.type!!,
                        isExpanded = plan.isExpanded!!,
                        exclusiveArea = plan.exclusiveArea!!,
                        supplyArea = plan.supplyArea!!,
                        imageUrl = plan.imageUrl!!
                    )
                }
            )
        }
    }

    fun getApartmentComplexesByJibunAddress(jibunAddress: String): List<ApartmentComplexDto> {
        return apartmentComplexRepository.findByAddressesJibunAddress(jibunAddress).map { complex ->
            ApartmentComplexDto(
                id = complex.id!!,
                name = complex.name!!,
                addresses = complex.addresses.map { address ->
                    AddressDto(roadAddress = address.roadAddress!!, jibunAddress = address.jibunAddress!!)
                },
                floorPlans = complex.floorPlans.map { plan ->
                    FloorPlanDto(
                        type = plan.type!!,
                        isExpanded = plan.isExpanded!!,
                        exclusiveArea = plan.exclusiveArea!!,
                        supplyArea = plan.supplyArea!!,
                        imageUrl = plan.imageUrl!!
                    )
                }
            )
        }
    }

    fun getFloorPlansByComplexNameAndType(name: String, type: String, sortDirection: Sort.Direction): List<FloorPlanDto> {
        val sort = Sort.by(sortDirection, "exclusiveArea")
        return floorPlanRepository.findByApartmentComplexNameAndTypeContaining(name, type, sort).map { plan ->
            FloorPlanDto(
                type = plan.type!!,
                isExpanded = plan.isExpanded!!,
                exclusiveArea = plan.exclusiveArea!!,
                supplyArea = plan.supplyArea!!,
                imageUrl = plan.imageUrl!!
            )
        }
    }

    fun getFloorPlansByComplexNameAndExpansion(name: String, isExpanded: Boolean, sortDirection: Sort.Direction): List<FloorPlanDto> {
        val sort = Sort.by(sortDirection, "exclusiveArea")
        return floorPlanRepository.findByApartmentComplexNameAndIsExpanded(name, isExpanded, sort).map { plan ->
            FloorPlanDto(
                type = plan.type!!,
                isExpanded = plan.isExpanded!!,
                exclusiveArea = plan.exclusiveArea!!,
                supplyArea = plan.supplyArea!!,
                imageUrl = plan.imageUrl!!
            )
        }
    }
}
