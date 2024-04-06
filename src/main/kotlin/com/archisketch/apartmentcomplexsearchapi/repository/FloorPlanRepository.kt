package com.archisketch.apartmentcomplexsearchapi.repository

import com.archisketch.apartmentcomplexsearchapi.entity.FloorPlan
import com.archisketch.apartmentcomplexsearchapi.entity.Sigungu
import com.archisketch.apartmentcomplexsearchapi.entity.User
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FloorPlanRepository : JpaRepository<FloorPlan, Long> {
    fun findByApartmentComplexNameAndTypeContaining(name: String, type: String, sort: Sort): List<FloorPlan>
    fun findByApartmentComplexNameAndIsExpanded(name: String, isExpanded: Boolean, sort: Sort): List<FloorPlan>
}