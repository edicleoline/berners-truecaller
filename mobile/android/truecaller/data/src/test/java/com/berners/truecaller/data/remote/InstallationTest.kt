package com.berners.truecaller.remote

import com.berners.truecaller.model.Device
import com.berners.truecaller.model.Installation
import org.junit.Test

class InstallationTest {

    val installation1 = Installation("pt", "BR", Device("PIXEL 5"))

    @Test
    fun tag_differentId_notEqual() {
//        assertThat(androidTagId1, Is(not(equalTo(webTagId2))))
//        Log.DEBUG(installation1)
        println("asd123")
    }
}
