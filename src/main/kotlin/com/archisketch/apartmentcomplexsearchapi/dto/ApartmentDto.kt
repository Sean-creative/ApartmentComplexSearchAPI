package com.archisketch.apartmentcomplexsearchapi.dto

data class ApartmentComplexDto(
    val id: Long,
    val name: String,
    val addresses: List<AddressDto>,
    val floorPlans: List<FloorPlanDto>
)

data class FloorPlanDto(
    val type: String,
    val isExpanded: Boolean,
    val exclusiveArea: Double,
    val supplyArea: Double,
    val imageUrl: String
)

data class AddressDto(
    val roadAddress: String,
    val jibunAddress: String
)