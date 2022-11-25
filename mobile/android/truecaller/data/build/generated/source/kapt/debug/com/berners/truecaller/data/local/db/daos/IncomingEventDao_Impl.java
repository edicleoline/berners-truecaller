package com.berners.truecaller.data.local.db.daos;

import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.berners.truecaller.data.local.db.entities.IncomingEventEntity;
import com.berners.truecaller.model.IncomingEventType;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

@SuppressWarnings({"unchecked", "deprecation"})
public final class IncomingEventDao_Impl extends IncomingEventDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<IncomingEventEntity> __insertionAdapterOfIncomingEventEntity;

  private final EntityInsertionAdapter<IncomingEventEntity> __insertionAdapterOfIncomingEventEntity_1;

  private final EntityDeletionOrUpdateAdapter<IncomingEventEntity> __deletionAdapterOfIncomingEventEntity;

  private final EntityDeletionOrUpdateAdapter<IncomingEventEntity> __updateAdapterOfIncomingEventEntity;

  public IncomingEventDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIncomingEventEntity = new EntityInsertionAdapter<IncomingEventEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `incoming_events` (`id`,`rid`,`created_at`,`updated_at`,`deleted_at`,`incoming_id`,`event_type`,`timestamp`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IncomingEventEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getRid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getRid());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getCreatedAt());
        }
        if (value.getUpdatedAt() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getUpdatedAt());
        }
        if (value.getDeletedAt() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getDeletedAt());
        }
        stmt.bindLong(6, value.getIncomingId());
        if (value.getType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, __IncomingEventType_enumToString(value.getType()));
        }
        stmt.bindLong(8, value.getTimestamp());
      }
    };
    this.__insertionAdapterOfIncomingEventEntity_1 = new EntityInsertionAdapter<IncomingEventEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `incoming_events` (`id`,`rid`,`created_at`,`updated_at`,`deleted_at`,`incoming_id`,`event_type`,`timestamp`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IncomingEventEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getRid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getRid());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getCreatedAt());
        }
        if (value.getUpdatedAt() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getUpdatedAt());
        }
        if (value.getDeletedAt() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getDeletedAt());
        }
        stmt.bindLong(6, value.getIncomingId());
        if (value.getType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, __IncomingEventType_enumToString(value.getType()));
        }
        stmt.bindLong(8, value.getTimestamp());
      }
    };
    this.__deletionAdapterOfIncomingEventEntity = new EntityDeletionOrUpdateAdapter<IncomingEventEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `incoming_events` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IncomingEventEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfIncomingEventEntity = new EntityDeletionOrUpdateAdapter<IncomingEventEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `incoming_events` SET `id` = ?,`rid` = ?,`created_at` = ?,`updated_at` = ?,`deleted_at` = ?,`incoming_id` = ?,`event_type` = ?,`timestamp` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IncomingEventEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getRid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getRid());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getCreatedAt());
        }
        if (value.getUpdatedAt() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getUpdatedAt());
        }
        if (value.getDeletedAt() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getDeletedAt());
        }
        stmt.bindLong(6, value.getIncomingId());
        if (value.getType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, __IncomingEventType_enumToString(value.getType()));
        }
        stmt.bindLong(8, value.getTimestamp());
        if (value.getId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getId());
        }
      }
    };
  }

  @Override
  public Object insert(final IncomingEventEntity entity, final Continuation<? super Long> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfIncomingEventEntity.insertAndReturnId(entity);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final IncomingEventEntity[] entity,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfIncomingEventEntity_1.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final List<? extends IncomingEventEntity> entities,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfIncomingEventEntity.insert(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteEntity(final IncomingEventEntity entity,
      final Continuation<? super Integer> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__deletionAdapterOfIncomingEventEntity.handle(entity);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object update(final IncomingEventEntity entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfIncomingEventEntity.handle(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object withTransaction(final Function1<? super Continuation<? super Unit>, ?> tx,
      final Continuation<? super Unit> $completion) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> IncomingEventDao_Impl.super.withTransaction(tx, __cont), $completion);
  }

  @Override
  public Object save(final List<? extends IncomingEventEntity> entities,
      final Continuation<? super Unit> $completion) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> IncomingEventDao_Impl.super.save(entities, __cont), $completion);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __IncomingEventType_enumToString(final IncomingEventType _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case CREATED: return "CREATED";
      case STARTED: return "STARTED";
      case MISSED: return "MISSED";
      case DECLINED: return "DECLINED";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }
}
