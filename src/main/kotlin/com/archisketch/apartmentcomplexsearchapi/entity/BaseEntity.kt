package com.archisketch.apartmentcomplexsearchapi.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@MappedSuperclass
open class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime? = null
        protected set

    @Column(nullable = false)
    var updatedAt: LocalDateTime? = null
        protected set

    @PrePersist
    protected fun onCreate() {
        val now = LocalDateTime.now()
        createdAt = now
        updatedAt = now
    }

    @PreUpdate
    protected fun onUpdate() {
        updatedAt = LocalDateTime.now()
    }
}
