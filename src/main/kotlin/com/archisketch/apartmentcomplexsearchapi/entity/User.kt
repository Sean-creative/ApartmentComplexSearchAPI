package com.archisketch.apartmentcomplexsearchapi.entity

import jakarta.persistence.*

//TODO 중복된 사용자를 어떻게 처리할지 고민해보기
@Entity
@Table(name = "user")
class User(
    user:String,
    password:String
) : BaseEntity() {
    @Column(nullable = false)
    var user: String = user
        private set

    @Column(nullable = false)
    var password: String = password
        private set
}