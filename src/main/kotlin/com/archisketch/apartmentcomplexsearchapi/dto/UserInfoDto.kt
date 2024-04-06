package com.archisketch.apartmentcomplexsearchapi.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import jakarta.validation.constraints.Pattern
import java.time.LocalDateTime

data class UserInfoDto(
    val id: Long,
    @field:NotBlank(message = "이름은 비어 있을 수 없습니다.")
    @field:Size(min = 1, max = 16, message = "이름은 1~16자 사이여야 합니다.")
    @field:Pattern(regexp = "^[\\p{L}\\p{N}]+$", message = "이름은 한글, 영어, 숫자만 포함할 수 있습니다.")
    val user: String,
    @field:Size(min = 6, max = 10, message = "Password must be between 6 and 10 characters")
    @field:Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).{6,10}$", message = "Password must include at least two types of characters")
    val password:String,
    var createdAt: LocalDateTime?,
    var updatedAt: LocalDateTime? = null)