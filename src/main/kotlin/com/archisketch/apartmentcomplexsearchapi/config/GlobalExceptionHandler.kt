package com.archisketch.apartmentcomplexsearchapi.config

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.servlet.resource.NoResourceFoundException

class CustomException(val code: String, message: String) :
    RuntimeException(message)

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class, MethodArgumentTypeMismatchException::class, HttpMessageNotReadableException::class, NoResourceFoundException::class)
    fun handleValidationExceptions(ex: Exception): ResponseEntity<Map<String, Any?>> {
        val errors = when (ex) {
            is MethodArgumentNotValidException ->  ex.bindingResult.fieldErrors.map { error ->
                error.defaultMessage
            }.joinToString(separator = ", ")
            is MethodArgumentTypeMismatchException -> "요청한 '${ex.name}'의 값이 유효하지 않습니다: ${ex.value}"
            is HttpMessageNotReadableException -> "요청 본문이 잘못되었습니다. 필수 정보를 모두 입력했는지 확인해주세요."
            is NoResourceFoundException -> "요청 값이 잘못되었습니다. 필수 정보를 모두 요청했는지 확인해주세요."
            else -> ex.message ?: "알 수 없는 오류가 발생했습니다."
        }
        val errorDetails = mapOf(
            "error" to mapOf(
                "code" to "BAD_REQUEST_BODY",
                "message" to errors
            )
        )

        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(CustomException::class)
    fun handleStudentAlreadyExistsException(ex: CustomException): ResponseEntity<Any> {
        val errorResponse = mapOf(
            "data" to null,
            "error" to mapOf(
                "code" to ex.code,
                "message" to ex.message
            )
        )
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }
}
