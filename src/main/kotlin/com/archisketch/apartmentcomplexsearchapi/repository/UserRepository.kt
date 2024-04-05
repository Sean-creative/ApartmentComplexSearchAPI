package com.archisketch.apartmentcomplexsearchapi.repository

import com.archisketch.apartmentcomplexsearchapi.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>