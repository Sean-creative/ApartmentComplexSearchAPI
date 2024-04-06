package com.archisketch.apartmentcomplexsearchapi.repository

import com.archisketch.apartmentcomplexsearchapi.entity.ApartmentComplex
import com.archisketch.apartmentcomplexsearchapi.entity.Sigungu
import com.archisketch.apartmentcomplexsearchapi.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface ApartmentComplexRepository : JpaRepository<ApartmentComplex, Long>, JpaSpecificationExecutor<ApartmentComplex> {
    fun findByName(name: String): ApartmentComplex?
    fun findByAddressesRoadAddress(roadAddress: String): List<ApartmentComplex>
    fun findByAddressesJibunAddress(jibunAddress: String): List<ApartmentComplex>
}