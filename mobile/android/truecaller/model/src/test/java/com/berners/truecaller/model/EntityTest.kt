package com.berners.truecaller.model

import org.junit.Test

class EntityTest {

    @Test
    fun entity_firstname() {
        val entity = Entity(id = 123456, type = EntityType.PEOPLE, name = "Edicleo Oliveira", verified = true, profileImageUrl = null, defaultProfileImage = true)
        println(entity.firstName)
    }

    @Test
    fun entity_lastname() {
        val entity = Entity(id = 123456, type = EntityType.COMPANY, name = "Edicleo Souza Oliveira", verified = true, profileImageUrl = null, defaultProfileImage = true)
        println(entity.lastName)
    }
}