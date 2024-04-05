package com.archisketch.apartmentcomplexsearchapi.dto

data class FloorPlanDto(
    val type: String,
    val isExpanded: Boolean,
    val exclusiveArea: Double,
    val supplyArea: Double,
    val imageUrl: String
)