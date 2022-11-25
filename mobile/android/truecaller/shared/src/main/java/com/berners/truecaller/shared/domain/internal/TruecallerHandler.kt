package com.berners.truecaller.shared.domain.internal

import android.os.Handler
import android.os.Looper

/**
 * A forwarding interface for [Handler] to support mocking in tests.
 */
interface TruecallerHandler {
    /**
     * See [Handler.post]
     */
    fun post(runnable: Runnable): Boolean

    /**
     * See [Handler.postDelayed]
     */
    fun postDelayed(runnable: Runnable, millis: Long): Boolean

    /**
     * See [Handler.removeCallbacks]
     */
    fun removeCallbacks(runnable: Runnable)
}

/**
 * Main thread handler to be used across ioshced.
 */
class TruecallerMainHandler : TruecallerHandler {
    private val handler = Handler(Looper.getMainLooper())

    override fun post(runnable: Runnable) = handler.post(runnable)

    override fun postDelayed(runnable: Runnable, millis: Long) =
        handler.postDelayed(runnable, millis)

    override fun removeCallbacks(runnable: Runnable) = handler.removeCallbacks(runnable)
}
