package com.archisketch.apartmentcomplexsearchapi.service

import com.archisketch.apartmentcomplexsearchapi.dto.SigunguDTO
import com.archisketch.apartmentcomplexsearchapi.entity.Sigungu
import com.archisketch.apartmentcomplexsearchapi.repository.SigunguRepository
import org.springframework.stereotype.Service

@Service
class SigunguService(val sigunguRepository: SigunguRepository) {
    fun getSigunguByPidLocCode(pidLocCode: Long): List<SigunguDTO> {
        val aa = sigunguRepository.findByPidLocCode(pidLocCode)

        println("aa.size : ${aa.size}")

        return sigunguRepository.findByPidLocCode(pidLocCode).map { entity ->
            SigunguDTO(
                pidLocCode = entity.pidLocCode,
                level = entity.level,
                depth1 = entity.depth1,
                depth2 = entity.depth2,
                depth3 = entity.depth3,
                ltLng = entity.ltLng,
                ltLat = entity.ltLat,
                rbLng = entity.rbLng,
                rbLat = entity.rbLat,
                dateCreation = entity.dateCreation
            )
        }
    }
}
