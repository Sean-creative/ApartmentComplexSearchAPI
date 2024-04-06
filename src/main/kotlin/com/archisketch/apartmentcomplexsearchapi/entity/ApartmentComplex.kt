package com.archisketch.apartmentcomplexsearchapi.entity

import jakarta.persistence.*

//아파트 단지 정보를 저장하는 테이블
@Entity
@Table(name = "apartment_complex")
class ApartmentComplex(
    name: String
) : BaseEntity() {
    @Column(nullable = false, unique = true)
    var name: String = name
        private set

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "apartmentComplex", cascade = [CascadeType.ALL], orphanRemoval = true)
    val addresses: MutableSet<Address> = mutableSetOf()

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "apartmentComplex", cascade = [CascadeType.ALL], orphanRemoval = true)
    val floorPlans: MutableSet<FloorPlan> = mutableSetOf()
}
