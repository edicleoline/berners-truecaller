package com.berners.truecaller.data.domain.observers

import com.berners.truecaller.data.domain.SubjectInteractor
import com.berners.truecaller.data.local.db.daos.IncomingDao
import com.berners.truecaller.data.local.db.entities.toModel
import com.berners.truecaller.data.local.db.resultentities.toModel
import com.berners.truecaller.model.Incoming
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ObserveIncomings @Inject constructor(
    private val incomingDao: IncomingDao
) : SubjectInteractor<ObserveIncomings.Params, List<Incoming>>() {

    override fun createObservable(params: Params): Flow<List<Incoming>> {
        return incomingDao.incomingsDetailedObservable().map { items ->
//            val list = ArrayList<Incoming>()
//            for (item in items) {
//                list.add(item.toModel())
//            }
//            list.toList()
            items.toModel()
        }
    }

    data class Params(val count: Int = 20)
}