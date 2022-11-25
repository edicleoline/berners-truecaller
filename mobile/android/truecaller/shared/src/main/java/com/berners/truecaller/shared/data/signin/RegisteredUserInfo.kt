package com.berners.truecaller.shared.data.signin

import android.net.Uri

class RegisteredUserInfo(
    private val basicUserInfo: AuthenticatedUserInfoBasic?,
    private val isRegistered: Boolean?
) : AuthenticatedUserInfo {

    override fun isRegistered(): Boolean = isRegistered ?: false

    override fun isSignedIn(): Boolean = basicUserInfo?.isSignedIn() == true

    override fun getEmail(): String? = basicUserInfo?.getEmail()

//    override fun getProviderData(): MutableList<out UserInfo>? = basicUserInfo?.getProviderData()

    override fun isAnonymous(): Boolean? = basicUserInfo?.isAnonymous()

    override fun getPhoneNumber(): String? = basicUserInfo?.getPhoneNumber()

    override fun getUid(): String? = basicUserInfo?.getUid()

    override fun isEmailVerified(): Boolean? = basicUserInfo?.isEmailVerified()

    override fun getDisplayName(): String? = basicUserInfo?.getDisplayName()

    override fun getPhotoUrl(): Uri? = basicUserInfo?.getPhotoUrl()

    override fun getProviderId(): String? = basicUserInfo?.getProviderId()

    override fun getLastSignInTimestamp(): Long? = basicUserInfo?.getLastSignInTimestamp()

    override fun getCreationTimestamp(): Long? = basicUserInfo?.getCreationTimestamp()

    override fun isRegistrationDataReady(): Boolean = isRegistered != null
}