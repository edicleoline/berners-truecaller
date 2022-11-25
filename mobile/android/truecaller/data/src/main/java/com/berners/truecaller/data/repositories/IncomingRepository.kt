package com.berners.truecaller.data.repositories

import com.berners.truecaller.data.datasources.PhoneDataSource
import com.berners.truecaller.model.Phone
import com.berners.truecaller.data.Result
import com.berners.truecaller.data.Result.Success
import com.berners.truecaller.data.data
import com.berners.truecaller.data.datasources.IncomingDataSource
import com.berners.truecaller.data.succeeded
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class IncomingRepository @Inject constructor(
//    val remotePhoneDataSource: PhoneDataSource,
    val localIncomingDataSource: IncomingDataSource
) {
    fun test() {
//        incomingDao.incomingsObservable().collect {
//            val test = it
//            for (item in it) {
//                val e = item
//                val d = 123
//            }
//        }
    }
}