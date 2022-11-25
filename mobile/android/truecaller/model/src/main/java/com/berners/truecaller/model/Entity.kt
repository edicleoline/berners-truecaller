package com.berners.truecaller.model

data class Entity(

    val id: Long? = null,

    val rid: Long? = null,

    val type: EntityType,

    val name: String? = null,

    val verified: Boolean,

    val profileImageUrl: String? = null,

    val primaryColor: String = "#daceb4",

    val isUser: Boolean,

    val isUserPremium: Boolean
) {
    val firstName: String?
        get() {
            val index = name?.trim()?.indexOf(" ")
            if (index == null || index == -1) {
                return name
            }
            return name?.substring(0, index)?.trim()
        }

    val lastName: String?
        get() {
            val index = name?.trim()?.lastIndexOf(" ")
            if (index == null || index == -1) {
                return null
            }
            return name?.substring(index)?.trim()
        }

    val defaultProfileImage: Boolean
        get() {
            return profileImageUrl.isNullOrEmpty()
        }

}
