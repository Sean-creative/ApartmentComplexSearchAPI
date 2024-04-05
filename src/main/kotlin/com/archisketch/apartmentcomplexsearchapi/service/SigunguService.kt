package com.archisketch.apartmentcomplexsearchapi.service

import com.archisketch.apartmentcomplexsearchapi.entity.Sigungu
import com.archisketch.apartmentcomplexsearchapi.repository.SigunguRepository
import org.springframework.stereotype.Service

@Service
class SigunguService(val sigunguRepository: SigunguRepository) {
    fun getSigunguByPidLocCode(pidLocCode: Long): List<Sigungu> {
        return sigunguRepository.findByPidLocCode(pidLocCode)
    }
}