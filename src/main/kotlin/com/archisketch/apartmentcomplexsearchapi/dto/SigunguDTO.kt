package com.archisketch.apartmentcomplexsearchapi.dto

import java.time.LocalDateTime

data class SigunguDTO(
    val pidLocCode: Long?,
    val level: Int,
    val depth1: String,
    val depth2: String,
    val depth3: String,
    val ltLng: Double,
    val ltLat: Double,
    val rbLng: Double,
    val rbLat: Double,
    val dateCreation: LocalDateTime
)
