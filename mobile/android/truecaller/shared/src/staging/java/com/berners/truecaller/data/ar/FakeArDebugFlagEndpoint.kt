package com.berners.truecaller.shared.data.ar

object FakeArDebugFlagEndpoint : ArDebugFlagEndpoint {

    override suspend fun canDemoAr(): Boolean {
        return true
    }
}
