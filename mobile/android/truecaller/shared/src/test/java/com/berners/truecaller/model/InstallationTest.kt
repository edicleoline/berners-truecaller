package com.berners.truecaller.model

import org.hamcrest.CoreMatchers.`is` as Is
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.assertThat
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
