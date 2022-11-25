package com.berners.truecaller.data.repositories

import com.berners.truecaller.data.datasources.IncomingEventDataSource
import javax.inject.Inject

class IncomingEventRepository @Inject constructor(
//    val remotePhoneDataSource: PhoneDataSource,
    val localIncomingStateDataSource: IncomingEventDataSource
) {
    fun test() {

    }
}