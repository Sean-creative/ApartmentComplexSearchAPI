package com.archisketch.apartmentcomplexsearchapi.entity

import jakarta.persistence.*

//TODO 중복된 사용자를 어떻게 처리할지 고민해보기
@Entity
@Table(name = "user")
class User(
    name:String,
    password:String
) : BaseEntity() {
    @Column(nullable = false)
    var name: String = name
        private set

    @Column(nullable = false)
    var password: String = password
        private set
}