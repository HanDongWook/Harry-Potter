package com.handongwook.harry_potter.data

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.CoroutineContext

interface NetworkCoroutineExceptionHandler : CoroutineExceptionHandler

class NetworkCoroutineExceptionHandlerImpl : NetworkCoroutineExceptionHandler {
    override val key: CoroutineContext.Key<*> = CoroutineExceptionHandler

    override fun handleException(
        context: CoroutineContext,
        exception: Throwable
    ) {
        println("NetworkCoroutineExceptionHandler handleException: $exception")
    }
}