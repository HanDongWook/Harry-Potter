package com.handongwook.harry_potter.core.data

import kotlinx.coroutines.CoroutineExceptionHandler
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

interface NetworkCoroutineExceptionHandler : CoroutineExceptionHandler

class NetworkCoroutineExceptionHandlerImpl : NetworkCoroutineExceptionHandler {
    override val key: CoroutineContext.Key<*> = CoroutineExceptionHandler

    override fun handleException(
        context: CoroutineContext,
        exception: Throwable
    ) {
        Timber.e(exception, "NetworkCoroutineExceptionHandler handleException")
    }
}