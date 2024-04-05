package com.archisketch.apartmentcomplexsearchapi.service

import com.archisketch.apartmentcomplexsearchapi.dto.UserInfoDto
import com.archisketch.apartmentcomplexsearchapi.entity.User
import com.archisketch.apartmentcomplexsearchapi.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    @Transactional
    fun saveUser(userInfo: UserInfoDto): User {
        val newUser = User(userInfo.name, userInfo.password)
        return userRepository.save(newUser)
    }
}