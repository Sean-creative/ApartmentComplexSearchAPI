package com.archisketch.apartmentcomplexsearchapi.service

import com.archisketch.apartmentcomplexsearchapi.dto.UserInfoDto
import com.archisketch.apartmentcomplexsearchapi.entity.User
import com.archisketch.apartmentcomplexsearchapi.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun saveUser(userInfo: UserInfoDto): UserInfoDto {
        // 비밀번호 암호화
        val encodedPassword = passwordEncoder.encode(userInfo.password)
        val newUser = User(userInfo.user, encodedPassword)
        return userRepository.save(newUser).let {
            UserInfoDto(it.id!!, it.user, it.password, it.createdAt, it.updatedAt)
        }
    }
}