package com.archisketch.apartmentcomplexsearchapi.dto

data class ApartmentComplexDto(
    val id: Long,
    val name: String,
    val addresses: List<AddressDto>,
    val floorPlans: List<FloorPlanDto>
)