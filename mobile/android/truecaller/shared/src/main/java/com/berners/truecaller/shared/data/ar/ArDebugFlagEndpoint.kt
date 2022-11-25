package com.berners.truecaller.shared.data.ar

import com.google.firebase.functions.FirebaseFunctions
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

interface ArDebugFlagEndpoint {

    /**
     * Asks if the signed in user can demo the AR feature (bypass the teaser page)
     */
    suspend fun canDemoAr(): Boolean
}

class DefaultArDebugFlagEndpoint @Inject constructor(private val functions: FirebaseFunctions) :
    ArDebugFlagEndpoint {

    override suspend fun canDemoAr(): Boolean = suspendCancellableCoroutine { cont ->
        functions
            .getHttpsCallable("canDemoAr")
            .call()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val taskResult = task.result?.data as Map<*, *>
                    if (taskResult["whitelisted"] == true) {
                        cont.resume(true)
                    } else {
                        cont.resume(false)
                    }
                } else {
                    cont.resumeWithException(RuntimeException(task.exception))
                }
            }
    }
}
