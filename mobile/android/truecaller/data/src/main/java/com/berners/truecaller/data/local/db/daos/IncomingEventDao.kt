package com.berners.truecaller.data.local.db.daos

import androidx.room.Dao
import com.berners.truecaller.data.local.db.entities.IncomingEventEntity

@Dao
abstract class IncomingEventDao : TrueDao<IncomingEventEntity>() {

}
