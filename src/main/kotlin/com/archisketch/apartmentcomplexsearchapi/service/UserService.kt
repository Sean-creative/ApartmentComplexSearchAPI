package com.archisketch.apartmentcomplexsearchapi.service

import com.archisketch.apartmentcomplexsearchapi.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

}