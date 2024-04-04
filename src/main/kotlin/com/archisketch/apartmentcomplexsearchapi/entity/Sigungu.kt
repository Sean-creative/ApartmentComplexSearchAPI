package com.archisketch.apartmentcomplexsearchapi.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Sigungu")
class Sigungu(
    level: Int,
    depth1: String,
    depth2: String = "none",
    depth3: String = "none",
    ltLng: Double,
    ltLat: Double,
    rbLng: Double,
    rbLat: Double
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var pidLocCode: Long? = null

    @Column(nullable = false)
    var level: Int = level
        private set

    @Column(nullable = false, length = 10)
    var depth1: String = depth1
        private set

    @Column(nullable = false, length = 10)
    var depth2: String = depth2
        private set

    @Column(nullable = false, length = 10)
    var depth3: String = depth3
        private set

    @Column(nullable = false)
    var ltLng: Double = ltLng
        private set

    @Column(nullable = false)
    var ltLat: Double = ltLat
        private set

    @Column(nullable = false)
    var rbLng: Double = rbLng
        private set

    @Column(nullable = false)
    var rbLat: Double = rbLat
        private set

    @Column(nullable = false)
    var dateCreation: LocalDateTime = LocalDateTime.now()
        private set
}
