package com.tjackapps.rapidtouch.models

sealed class Either<out S : Any?, out F : Any?> {
    open class Success<S : Any?> internal constructor(open val success: S) : Either<S, Nothing>()

    open class Failure<F : Any?> internal constructor(open val failure: F) : Either<Nothing, F>()

    companion object {
        fun <T : Any> success(success: T): Either<T, Nothing> {
            return Success(success)
        }

        fun <T : Any> failure(failure: T): Either<Nothing, T> {
            return Failure(failure)
        }
    }
}