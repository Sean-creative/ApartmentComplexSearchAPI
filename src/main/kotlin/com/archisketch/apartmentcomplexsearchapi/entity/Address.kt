package com.archisketch.apartmentcomplexsearchapi.entity

import jakarta.persistence.*

//지번 주소 및 도로명 주소 정보를 저장하는 테이블
@Entity
@Table(name = "address")
class Address(
    apartmentComplex: ApartmentComplex,
    roadAddress: String,
    jibunAddress: String
) : BaseEntity() {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_complex_id", nullable = false)
    var apartmentComplex: ApartmentComplex = apartmentComplex
        private set

    @Column(nullable = false)
    var roadAddress: String = roadAddress
        private set

    @Column(nullable = false)
    var jibunAddress: String = jibunAddress
        private set

    fun setApartmentComplex(apartmentComplex: ApartmentComplex) {
        this.apartmentComplex = apartmentComplex
    }
}
