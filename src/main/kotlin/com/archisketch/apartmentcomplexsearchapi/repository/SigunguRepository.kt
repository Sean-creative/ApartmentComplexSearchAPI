package com.archisketch.apartmentcomplexsearchapi.repository

import com.archisketch.apartmentcomplexsearchapi.entity.Sigungu
import com.archisketch.apartmentcomplexsearchapi.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SigunguRepository : JpaRepository<Sigungu, Long> {
    fun findByPidLocCode(pidLocCode: Long): List<Sigungu>
}