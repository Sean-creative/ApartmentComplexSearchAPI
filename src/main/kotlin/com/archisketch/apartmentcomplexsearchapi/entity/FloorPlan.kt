package com.archisketch.apartmentcomplexsearchapi.entity

import jakarta.persistence.*

//도면 정보를 저장하는 테이블
@Entity
@Table(name = "floor_plan")
class FloorPlan(
    apartmentComplex: ApartmentComplex,
    type: String,
    isExpanded: Boolean,
    exclusiveArea: Double,
    supplyArea: Double,
    imageUrl: String
) : BaseEntity() {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_complex_id", nullable = false)
    var apartmentComplex: ApartmentComplex = apartmentComplex
        private set

    @Column(nullable = false)
    var type: String = type
        private set

    @Column(nullable = false)
    var isExpanded: Boolean = isExpanded
        private set

    @Column(nullable = false)
    var exclusiveArea: Double = exclusiveArea
        private set

    @Column(nullable = false)
    var supplyArea: Double = supplyArea
        private set

    @Column(nullable = false)
    var imageUrl: String = imageUrl
        private set

    fun setApartmentComplex(apartmentComplex: ApartmentComplex) {
        this.apartmentComplex = apartmentComplex
    }
}
