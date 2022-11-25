package com.berners.truecaller.data.local.db.daos;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.berners.truecaller.data.local.db.entities.EntityEntity;
import com.berners.truecaller.data.local.db.entities.IncomingEntity;
import com.berners.truecaller.data.local.db.entities.IncomingEventEntity;
import com.berners.truecaller.data.local.db.entities.PhoneEntity;
import com.berners.truecaller.data.local.db.resultentities.IncomingEntityDetailed;
import com.berners.truecaller.data.local.db.resultentities.PhoneEntityDetailed;
import com.berners.truecaller.model.EntityType;
import com.berners.truecaller.model.IncomingDecisionType;
import com.berners.truecaller.model.IncomingDirection;
import com.berners.truecaller.model.IncomingEventType;
import com.berners.truecaller.model.Owner;
import com.berners.truecaller.model.PhoneNumberType;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class IncomingDao_Impl extends IncomingDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<IncomingEntity> __insertionAdapterOfIncomingEntity;

  private final EntityInsertionAdapter<IncomingEntity> __insertionAdapterOfIncomingEntity_1;

  private final EntityDeletionOrUpdateAdapter<IncomingEntity> __deletionAdapterOfIncomingEntity;

  private final EntityDeletionOrUpdateAdapter<IncomingEntity> __updateAdapterOfIncomingEntity;

  public IncomingDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIncomingEntity = new EntityInsertionAdapter<IncomingEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `incomings` (`id`,`rid`,`created_at`,`updated_at`,`deleted_at`,`source_id`,`target_id`,`direction`,`decision_owner`,`decision_type`,`decision_spam`,`decision_message`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IncomingEntity value) {
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
        stmt.bindLong(6, value.getSourceId());
        stmt.bindLong(7, value.getTargetId());
        if (value.getDirection() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, __IncomingDirection_enumToString(value.getDirection()));
        }
        if (value.getDecisionOwner() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, __Owner_enumToString(value.getDecisionOwner()));
        }
        if (value.getDecisionType() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, __IncomingDecisionType_enumToString(value.getDecisionType()));
        }
        final Integer _tmp = value.getDecisionSpam() == null ? null : (value.getDecisionSpam() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, _tmp);
        }
        if (value.getDecisionMessage() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getDecisionMessage());
        }
      }
    };
    this.__insertionAdapterOfIncomingEntity_1 = new EntityInsertionAdapter<IncomingEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `incomings` (`id`,`rid`,`created_at`,`updated_at`,`deleted_at`,`source_id`,`target_id`,`direction`,`decision_owner`,`decision_type`,`decision_spam`,`decision_message`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IncomingEntity value) {
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
        stmt.bindLong(6, value.getSourceId());
        stmt.bindLong(7, value.getTargetId());
        if (value.getDirection() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, __IncomingDirection_enumToString(value.getDirection()));
        }
        if (value.getDecisionOwner() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, __Owner_enumToString(value.getDecisionOwner()));
        }
        if (value.getDecisionType() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, __IncomingDecisionType_enumToString(value.getDecisionType()));
        }
        final Integer _tmp = value.getDecisionSpam() == null ? null : (value.getDecisionSpam() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, _tmp);
        }
        if (value.getDecisionMessage() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getDecisionMessage());
        }
      }
    };
    this.__deletionAdapterOfIncomingEntity = new EntityDeletionOrUpdateAdapter<IncomingEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `incomings` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IncomingEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfIncomingEntity = new EntityDeletionOrUpdateAdapter<IncomingEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `incomings` SET `id` = ?,`rid` = ?,`created_at` = ?,`updated_at` = ?,`deleted_at` = ?,`source_id` = ?,`target_id` = ?,`direction` = ?,`decision_owner` = ?,`decision_type` = ?,`decision_spam` = ?,`decision_message` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IncomingEntity value) {
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
        stmt.bindLong(6, value.getSourceId());
        stmt.bindLong(7, value.getTargetId());
        if (value.getDirection() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, __IncomingDirection_enumToString(value.getDirection()));
        }
        if (value.getDecisionOwner() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, __Owner_enumToString(value.getDecisionOwner()));
        }
        if (value.getDecisionType() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, __IncomingDecisionType_enumToString(value.getDecisionType()));
        }
        final Integer _tmp = value.getDecisionSpam() == null ? null : (value.getDecisionSpam() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, _tmp);
        }
        if (value.getDecisionMessage() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getDecisionMessage());
        }
        if (value.getId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getId());
        }
      }
    };
  }

  @Override
  public Object insert(final IncomingEntity entity, final Continuation<? super Long> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfIncomingEntity.insertAndReturnId(entity);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final IncomingEntity[] entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfIncomingEntity_1.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final List<? extends IncomingEntity> entities,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfIncomingEntity.insert(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteEntity(final IncomingEntity entity,
      final Continuation<? super Integer> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__deletionAdapterOfIncomingEntity.handle(entity);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object update(final IncomingEntity entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfIncomingEntity.handle(entity);
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
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> IncomingDao_Impl.super.withTransaction(tx, __cont), $completion);
  }

  @Override
  public Object save(final List<? extends IncomingEntity> entities,
      final Continuation<? super Unit> $completion) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> IncomingDao_Impl.super.save(entities, __cont), $completion);
  }

  @Override
  public Flow<List<IncomingEntity>> incomingsObservable() {
    final String _sql = "SELECT * FROM incomings ORDER BY created_at ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, true, new String[]{"incomings"}, new Callable<List<IncomingEntity>>() {
      @Override
      public List<IncomingEntity> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfRid = CursorUtil.getColumnIndexOrThrow(_cursor, "rid");
            final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
            final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
            final int _cursorIndexOfDeletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "deleted_at");
            final int _cursorIndexOfSourceId = CursorUtil.getColumnIndexOrThrow(_cursor, "source_id");
            final int _cursorIndexOfTargetId = CursorUtil.getColumnIndexOrThrow(_cursor, "target_id");
            final int _cursorIndexOfDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "direction");
            final int _cursorIndexOfDecisionOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "decision_owner");
            final int _cursorIndexOfDecisionType = CursorUtil.getColumnIndexOrThrow(_cursor, "decision_type");
            final int _cursorIndexOfDecisionSpam = CursorUtil.getColumnIndexOrThrow(_cursor, "decision_spam");
            final int _cursorIndexOfDecisionMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "decision_message");
            final List<IncomingEntity> _result = new ArrayList<IncomingEntity>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final IncomingEntity _item;
              final Long _tmpId;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmpId = null;
              } else {
                _tmpId = _cursor.getLong(_cursorIndexOfId);
              }
              final Long _tmpRid;
              if (_cursor.isNull(_cursorIndexOfRid)) {
                _tmpRid = null;
              } else {
                _tmpRid = _cursor.getLong(_cursorIndexOfRid);
              }
              final Long _tmpCreatedAt;
              if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
                _tmpCreatedAt = null;
              } else {
                _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
              }
              final Long _tmpUpdatedAt;
              if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _tmpUpdatedAt = null;
              } else {
                _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
              }
              final Long _tmpDeletedAt;
              if (_cursor.isNull(_cursorIndexOfDeletedAt)) {
                _tmpDeletedAt = null;
              } else {
                _tmpDeletedAt = _cursor.getLong(_cursorIndexOfDeletedAt);
              }
              final long _tmpSourceId;
              _tmpSourceId = _cursor.getLong(_cursorIndexOfSourceId);
              final long _tmpTargetId;
              _tmpTargetId = _cursor.getLong(_cursorIndexOfTargetId);
              final IncomingDirection _tmpDirection;
              _tmpDirection = __IncomingDirection_stringToEnum(_cursor.getString(_cursorIndexOfDirection));
              final Owner _tmpDecisionOwner;
              _tmpDecisionOwner = __Owner_stringToEnum(_cursor.getString(_cursorIndexOfDecisionOwner));
              final IncomingDecisionType _tmpDecisionType;
              _tmpDecisionType = __IncomingDecisionType_stringToEnum(_cursor.getString(_cursorIndexOfDecisionType));
              final Boolean _tmpDecisionSpam;
              final Integer _tmp;
              if (_cursor.isNull(_cursorIndexOfDecisionSpam)) {
                _tmp = null;
              } else {
                _tmp = _cursor.getInt(_cursorIndexOfDecisionSpam);
              }
              _tmpDecisionSpam = _tmp == null ? null : _tmp != 0;
              final String _tmpDecisionMessage;
              if (_cursor.isNull(_cursorIndexOfDecisionMessage)) {
                _tmpDecisionMessage = null;
              } else {
                _tmpDecisionMessage = _cursor.getString(_cursorIndexOfDecisionMessage);
              }
              _item = new IncomingEntity(_tmpId,_tmpRid,_tmpCreatedAt,_tmpUpdatedAt,_tmpDeletedAt,_tmpSourceId,_tmpTargetId,_tmpDirection,_tmpDecisionOwner,_tmpDecisionType,_tmpDecisionSpam,_tmpDecisionMessage);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<IncomingEntityDetailed>> incomingsDetailedObservable() {
    final String _sql = "SELECT * FROM incomings ORDER BY created_at ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, true, new String[]{"incoming_events","entities","phones","incomings"}, new Callable<List<IncomingEntityDetailed>>() {
      @Override
      public List<IncomingEntityDetailed> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfRid = CursorUtil.getColumnIndexOrThrow(_cursor, "rid");
            final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
            final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
            final int _cursorIndexOfDeletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "deleted_at");
            final int _cursorIndexOfSourceId = CursorUtil.getColumnIndexOrThrow(_cursor, "source_id");
            final int _cursorIndexOfTargetId = CursorUtil.getColumnIndexOrThrow(_cursor, "target_id");
            final int _cursorIndexOfDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "direction");
            final int _cursorIndexOfDecisionOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "decision_owner");
            final int _cursorIndexOfDecisionType = CursorUtil.getColumnIndexOrThrow(_cursor, "decision_type");
            final int _cursorIndexOfDecisionSpam = CursorUtil.getColumnIndexOrThrow(_cursor, "decision_spam");
            final int _cursorIndexOfDecisionMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "decision_message");
            final LongSparseArray<ArrayList<IncomingEventEntity>> _collectionEvents = new LongSparseArray<ArrayList<IncomingEventEntity>>();
            final LongSparseArray<PhoneEntityDetailed> _collectionSource = new LongSparseArray<PhoneEntityDetailed>();
            final LongSparseArray<PhoneEntityDetailed> _collectionTarget = new LongSparseArray<PhoneEntityDetailed>();
            while (_cursor.moveToNext()) {
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
                ArrayList<IncomingEventEntity> _tmpEventsCollection = _collectionEvents.get(_tmpKey);
                if (_tmpEventsCollection == null) {
                  _tmpEventsCollection = new ArrayList<IncomingEventEntity>();
                  _collectionEvents.put(_tmpKey, _tmpEventsCollection);
                }
              }
              final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfSourceId);
              _collectionSource.put(_tmpKey_1, null);
              final long _tmpKey_2 = _cursor.getLong(_cursorIndexOfTargetId);
              _collectionTarget.put(_tmpKey_2, null);
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipincomingEventsAscomBernersTruecallerDataLocalDbEntitiesIncomingEventEntity(_collectionEvents);
            __fetchRelationshipphonesAscomBernersTruecallerDataLocalDbResultentitiesPhoneEntityDetailed(_collectionSource);
            __fetchRelationshipphonesAscomBernersTruecallerDataLocalDbResultentitiesPhoneEntityDetailed(_collectionTarget);
            final List<IncomingEntityDetailed> _result = new ArrayList<IncomingEntityDetailed>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final IncomingEntityDetailed _item;
              final IncomingEntity _tmpIncomingEntity;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfRid) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfUpdatedAt) && _cursor.isNull(_cursorIndexOfDeletedAt) && _cursor.isNull(_cursorIndexOfSourceId) && _cursor.isNull(_cursorIndexOfTargetId) && _cursor.isNull(_cursorIndexOfDirection) && _cursor.isNull(_cursorIndexOfDecisionOwner) && _cursor.isNull(_cursorIndexOfDecisionType) && _cursor.isNull(_cursorIndexOfDecisionSpam) && _cursor.isNull(_cursorIndexOfDecisionMessage))) {
                final Long _tmpId;
                if (_cursor.isNull(_cursorIndexOfId)) {
                  _tmpId = null;
                } else {
                  _tmpId = _cursor.getLong(_cursorIndexOfId);
                }
                final Long _tmpRid;
                if (_cursor.isNull(_cursorIndexOfRid)) {
                  _tmpRid = null;
                } else {
                  _tmpRid = _cursor.getLong(_cursorIndexOfRid);
                }
                final Long _tmpCreatedAt;
                if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
                  _tmpCreatedAt = null;
                } else {
                  _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
                }
                final Long _tmpUpdatedAt;
                if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
                  _tmpUpdatedAt = null;
                } else {
                  _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
                }
                final Long _tmpDeletedAt;
                if (_cursor.isNull(_cursorIndexOfDeletedAt)) {
                  _tmpDeletedAt = null;
                } else {
                  _tmpDeletedAt = _cursor.getLong(_cursorIndexOfDeletedAt);
                }
                final long _tmpSourceId;
                _tmpSourceId = _cursor.getLong(_cursorIndexOfSourceId);
                final long _tmpTargetId;
                _tmpTargetId = _cursor.getLong(_cursorIndexOfTargetId);
                final IncomingDirection _tmpDirection;
                _tmpDirection = __IncomingDirection_stringToEnum(_cursor.getString(_cursorIndexOfDirection));
                final Owner _tmpDecisionOwner;
                _tmpDecisionOwner = __Owner_stringToEnum(_cursor.getString(_cursorIndexOfDecisionOwner));
                final IncomingDecisionType _tmpDecisionType;
                _tmpDecisionType = __IncomingDecisionType_stringToEnum(_cursor.getString(_cursorIndexOfDecisionType));
                final Boolean _tmpDecisionSpam;
                final Integer _tmp;
                if (_cursor.isNull(_cursorIndexOfDecisionSpam)) {
                  _tmp = null;
                } else {
                  _tmp = _cursor.getInt(_cursorIndexOfDecisionSpam);
                }
                _tmpDecisionSpam = _tmp == null ? null : _tmp != 0;
                final String _tmpDecisionMessage;
                if (_cursor.isNull(_cursorIndexOfDecisionMessage)) {
                  _tmpDecisionMessage = null;
                } else {
                  _tmpDecisionMessage = _cursor.getString(_cursorIndexOfDecisionMessage);
                }
                _tmpIncomingEntity = new IncomingEntity(_tmpId,_tmpRid,_tmpCreatedAt,_tmpUpdatedAt,_tmpDeletedAt,_tmpSourceId,_tmpTargetId,_tmpDirection,_tmpDecisionOwner,_tmpDecisionType,_tmpDecisionSpam,_tmpDecisionMessage);
              }  else  {
                _tmpIncomingEntity = null;
              }
              ArrayList<IncomingEventEntity> _tmpEventsCollection_1 = null;
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final long _tmpKey_3 = _cursor.getLong(_cursorIndexOfId);
                _tmpEventsCollection_1 = _collectionEvents.get(_tmpKey_3);
              }
              if (_tmpEventsCollection_1 == null) {
                _tmpEventsCollection_1 = new ArrayList<IncomingEventEntity>();
              }
              PhoneEntityDetailed _tmpSource = null;
              final long _tmpKey_4 = _cursor.getLong(_cursorIndexOfSourceId);
              _tmpSource = _collectionSource.get(_tmpKey_4);
              PhoneEntityDetailed _tmpTarget = null;
              final long _tmpKey_5 = _cursor.getLong(_cursorIndexOfTargetId);
              _tmpTarget = _collectionTarget.get(_tmpKey_5);
              _item = new IncomingEntityDetailed();
              _item.incomingEntity = _tmpIncomingEntity;
              _item.events = _tmpEventsCollection_1;
              _item.source = _tmpSource;
              _item.target = _tmpTarget;
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __IncomingDirection_enumToString(final IncomingDirection _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case INCOMING: return "INCOMING";
      case OUTGOING: return "OUTGOING";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __Owner_enumToString(final Owner _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case USER: return "USER";
      case SYSTEM: return "SYSTEM";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __IncomingDecisionType_enumToString(final IncomingDecisionType _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case ALLOW: return "ALLOW";
      case BLOCK: return "BLOCK";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private IncomingDirection __IncomingDirection_stringToEnum(final String _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case "INCOMING": return IncomingDirection.INCOMING;
      case "OUTGOING": return IncomingDirection.OUTGOING;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private Owner __Owner_stringToEnum(final String _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case "USER": return Owner.USER;
      case "SYSTEM": return Owner.SYSTEM;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private IncomingDecisionType __IncomingDecisionType_stringToEnum(final String _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case "ALLOW": return IncomingDecisionType.ALLOW;
      case "BLOCK": return IncomingDecisionType.BLOCK;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private IncomingEventType __IncomingEventType_stringToEnum(final String _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case "CREATED": return IncomingEventType.CREATED;
      case "STARTED": return IncomingEventType.STARTED;
      case "MISSED": return IncomingEventType.MISSED;
      case "DECLINED": return IncomingEventType.DECLINED;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private void __fetchRelationshipincomingEventsAscomBernersTruecallerDataLocalDbEntitiesIncomingEventEntity(
      final LongSparseArray<ArrayList<IncomingEventEntity>> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<ArrayList<IncomingEventEntity>> _tmpInnerMap = new LongSparseArray<ArrayList<IncomingEventEntity>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipincomingEventsAscomBernersTruecallerDataLocalDbEntitiesIncomingEventEntity(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<ArrayList<IncomingEventEntity>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipincomingEventsAscomBernersTruecallerDataLocalDbEntitiesIncomingEventEntity(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`rid`,`created_at`,`updated_at`,`deleted_at`,`incoming_id`,`event_type`,`timestamp` FROM `incoming_events` WHERE `incoming_id` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "incoming_id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfRid = 1;
      final int _cursorIndexOfCreatedAt = 2;
      final int _cursorIndexOfUpdatedAt = 3;
      final int _cursorIndexOfDeletedAt = 4;
      final int _cursorIndexOfIncomingId = 5;
      final int _cursorIndexOfType = 6;
      final int _cursorIndexOfTimestamp = 7;
      while(_cursor.moveToNext()) {
        if (!_cursor.isNull(_itemKeyIndex)) {
          final long _tmpKey = _cursor.getLong(_itemKeyIndex);
          ArrayList<IncomingEventEntity> _tmpRelation = _map.get(_tmpKey);
          if (_tmpRelation != null) {
            final IncomingEventEntity _item_1;
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            final Long _tmpRid;
            if (_cursor.isNull(_cursorIndexOfRid)) {
              _tmpRid = null;
            } else {
              _tmpRid = _cursor.getLong(_cursorIndexOfRid);
            }
            final Long _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            final Long _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            final Long _tmpDeletedAt;
            if (_cursor.isNull(_cursorIndexOfDeletedAt)) {
              _tmpDeletedAt = null;
            } else {
              _tmpDeletedAt = _cursor.getLong(_cursorIndexOfDeletedAt);
            }
            final long _tmpIncomingId;
            _tmpIncomingId = _cursor.getLong(_cursorIndexOfIncomingId);
            final IncomingEventType _tmpType;
            _tmpType = __IncomingEventType_stringToEnum(_cursor.getString(_cursorIndexOfType));
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item_1 = new IncomingEventEntity(_tmpId,_tmpRid,_tmpCreatedAt,_tmpUpdatedAt,_tmpDeletedAt,_tmpIncomingId,_tmpType,_tmpTimestamp);
            _tmpRelation.add(_item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }

  private EntityType __EntityType_stringToEnum(final String _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case "COMPANY": return EntityType.COMPANY;
      case "PEOPLE": return EntityType.PEOPLE;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private void __fetchRelationshipentitiesAscomBernersTruecallerDataLocalDbEntitiesEntityEntity(
      final LongSparseArray<EntityEntity> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<EntityEntity> _tmpInnerMap = new LongSparseArray<EntityEntity>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), null);
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipentitiesAscomBernersTruecallerDataLocalDbEntitiesEntityEntity(_tmpInnerMap);
          _map.putAll(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<EntityEntity>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipentitiesAscomBernersTruecallerDataLocalDbEntitiesEntityEntity(_tmpInnerMap);
        _map.putAll(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`rid`,`created_at`,`updated_at`,`deleted_at`,`entity_type`,`name`,`verified`,`profile_image_url`,`primary_color`,`is_user`,`is_user_premium` FROM `entities` WHERE `id` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfRid = 1;
      final int _cursorIndexOfCreatedAt = 2;
      final int _cursorIndexOfUpdatedAt = 3;
      final int _cursorIndexOfDeletedAt = 4;
      final int _cursorIndexOfType = 5;
      final int _cursorIndexOfName = 6;
      final int _cursorIndexOfVerified = 7;
      final int _cursorIndexOfProfileImageUrl = 8;
      final int _cursorIndexOfPrimaryColor = 9;
      final int _cursorIndexOfIsUser = 10;
      final int _cursorIndexOfIsUserPremium = 11;
      while(_cursor.moveToNext()) {
        if (!_cursor.isNull(_itemKeyIndex)) {
          final long _tmpKey = _cursor.getLong(_itemKeyIndex);
          if (_map.containsKey(_tmpKey)) {
            final EntityEntity _item_1;
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            final Long _tmpRid;
            if (_cursor.isNull(_cursorIndexOfRid)) {
              _tmpRid = null;
            } else {
              _tmpRid = _cursor.getLong(_cursorIndexOfRid);
            }
            final Long _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            final Long _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            final Long _tmpDeletedAt;
            if (_cursor.isNull(_cursorIndexOfDeletedAt)) {
              _tmpDeletedAt = null;
            } else {
              _tmpDeletedAt = _cursor.getLong(_cursorIndexOfDeletedAt);
            }
            final EntityType _tmpType;
            _tmpType = __EntityType_stringToEnum(_cursor.getString(_cursorIndexOfType));
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final boolean _tmpVerified;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfVerified);
            _tmpVerified = _tmp != 0;
            final String _tmpProfileImageUrl;
            if (_cursor.isNull(_cursorIndexOfProfileImageUrl)) {
              _tmpProfileImageUrl = null;
            } else {
              _tmpProfileImageUrl = _cursor.getString(_cursorIndexOfProfileImageUrl);
            }
            final String _tmpPrimaryColor;
            if (_cursor.isNull(_cursorIndexOfPrimaryColor)) {
              _tmpPrimaryColor = null;
            } else {
              _tmpPrimaryColor = _cursor.getString(_cursorIndexOfPrimaryColor);
            }
            final boolean _tmpIsUser;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsUser);
            _tmpIsUser = _tmp_1 != 0;
            final boolean _tmpIsUserPremium;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsUserPremium);
            _tmpIsUserPremium = _tmp_2 != 0;
            _item_1 = new EntityEntity(_tmpId,_tmpRid,_tmpCreatedAt,_tmpUpdatedAt,_tmpDeletedAt,_tmpType,_tmpName,_tmpVerified,_tmpProfileImageUrl,_tmpPrimaryColor,_tmpIsUser,_tmpIsUserPremium);
            _map.put(_tmpKey, _item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }

  private PhoneNumberType __PhoneNumberType_stringToEnum(final String _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case "MOBILE": return PhoneNumberType.MOBILE;
      case "FIXED_LINE": return PhoneNumberType.FIXED_LINE;
      case "UNKNOWN": return PhoneNumberType.UNKNOWN;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private void __fetchRelationshipphonesAscomBernersTruecallerDataLocalDbResultentitiesPhoneEntityDetailed(
      final LongSparseArray<PhoneEntityDetailed> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<PhoneEntityDetailed> _tmpInnerMap = new LongSparseArray<PhoneEntityDetailed>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), null);
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipphonesAscomBernersTruecallerDataLocalDbResultentitiesPhoneEntityDetailed(_tmpInnerMap);
          _map.putAll(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<PhoneEntityDetailed>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipphonesAscomBernersTruecallerDataLocalDbResultentitiesPhoneEntityDetailed(_tmpInnerMap);
        _map.putAll(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`rid`,`created_at`,`updated_at`,`deleted_at`,`phone`,`e164_format`,`national_format`,`dialing_code`,`country_code`,`number_type`,`location_formatted`,`entity_id` FROM `phones` WHERE `id` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, true, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfRid = 1;
      final int _cursorIndexOfCreatedAt = 2;
      final int _cursorIndexOfUpdatedAt = 3;
      final int _cursorIndexOfDeletedAt = 4;
      final int _cursorIndexOfPhone = 5;
      final int _cursorIndexOfE164Format = 6;
      final int _cursorIndexOfNationalFormat = 7;
      final int _cursorIndexOfDialingCode = 8;
      final int _cursorIndexOfCountryCode = 9;
      final int _cursorIndexOfNumberType = 10;
      final int _cursorIndexOfLocationFormatted = 11;
      final int _cursorIndexOfEntityId = 12;
      final LongSparseArray<EntityEntity> _collectionEntity = new LongSparseArray<EntityEntity>();
      while (_cursor.moveToNext()) {
        if (!_cursor.isNull(_cursorIndexOfEntityId)) {
          final long _tmpKey = _cursor.getLong(_cursorIndexOfEntityId);
          _collectionEntity.put(_tmpKey, null);
        }
      }
      _cursor.moveToPosition(-1);
      __fetchRelationshipentitiesAscomBernersTruecallerDataLocalDbEntitiesEntityEntity(_collectionEntity);
      while(_cursor.moveToNext()) {
        final long _tmpKey_1 = _cursor.getLong(_itemKeyIndex);
        if (_map.containsKey(_tmpKey_1)) {
          final PhoneEntityDetailed _item_1;
          final PhoneEntity _tmpPhoneEntity;
          if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfRid) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfUpdatedAt) && _cursor.isNull(_cursorIndexOfDeletedAt) && _cursor.isNull(_cursorIndexOfPhone) && _cursor.isNull(_cursorIndexOfE164Format) && _cursor.isNull(_cursorIndexOfNationalFormat) && _cursor.isNull(_cursorIndexOfDialingCode) && _cursor.isNull(_cursorIndexOfCountryCode) && _cursor.isNull(_cursorIndexOfNumberType) && _cursor.isNull(_cursorIndexOfLocationFormatted) && _cursor.isNull(_cursorIndexOfEntityId))) {
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            final Long _tmpRid;
            if (_cursor.isNull(_cursorIndexOfRid)) {
              _tmpRid = null;
            } else {
              _tmpRid = _cursor.getLong(_cursorIndexOfRid);
            }
            final Long _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            final Long _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            }
            final Long _tmpDeletedAt;
            if (_cursor.isNull(_cursorIndexOfDeletedAt)) {
              _tmpDeletedAt = null;
            } else {
              _tmpDeletedAt = _cursor.getLong(_cursorIndexOfDeletedAt);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpE164Format;
            if (_cursor.isNull(_cursorIndexOfE164Format)) {
              _tmpE164Format = null;
            } else {
              _tmpE164Format = _cursor.getString(_cursorIndexOfE164Format);
            }
            final String _tmpNationalFormat;
            if (_cursor.isNull(_cursorIndexOfNationalFormat)) {
              _tmpNationalFormat = null;
            } else {
              _tmpNationalFormat = _cursor.getString(_cursorIndexOfNationalFormat);
            }
            final String _tmpDialingCode;
            if (_cursor.isNull(_cursorIndexOfDialingCode)) {
              _tmpDialingCode = null;
            } else {
              _tmpDialingCode = _cursor.getString(_cursorIndexOfDialingCode);
            }
            final String _tmpCountryCode;
            if (_cursor.isNull(_cursorIndexOfCountryCode)) {
              _tmpCountryCode = null;
            } else {
              _tmpCountryCode = _cursor.getString(_cursorIndexOfCountryCode);
            }
            final PhoneNumberType _tmpNumberType;
            _tmpNumberType = __PhoneNumberType_stringToEnum(_cursor.getString(_cursorIndexOfNumberType));
            final String _tmpLocationFormatted;
            if (_cursor.isNull(_cursorIndexOfLocationFormatted)) {
              _tmpLocationFormatted = null;
            } else {
              _tmpLocationFormatted = _cursor.getString(_cursorIndexOfLocationFormatted);
            }
            final Long _tmpEntityId;
            if (_cursor.isNull(_cursorIndexOfEntityId)) {
              _tmpEntityId = null;
            } else {
              _tmpEntityId = _cursor.getLong(_cursorIndexOfEntityId);
            }
            _tmpPhoneEntity = new PhoneEntity(_tmpId,_tmpRid,_tmpCreatedAt,_tmpUpdatedAt,_tmpDeletedAt,_tmpPhone,_tmpE164Format,_tmpNationalFormat,_tmpDialingCode,_tmpCountryCode,_tmpNumberType,_tmpLocationFormatted,_tmpEntityId);
          }  else  {
            _tmpPhoneEntity = null;
          }
          EntityEntity _tmpEntity = null;
          if (!_cursor.isNull(_cursorIndexOfEntityId)) {
            final long _tmpKey_2 = _cursor.getLong(_cursorIndexOfEntityId);
            _tmpEntity = _collectionEntity.get(_tmpKey_2);
          }
          _item_1 = new PhoneEntityDetailed();
          _item_1.phoneEntity = _tmpPhoneEntity;
          _item_1.setEntity(_tmpEntity);
          _map.put(_tmpKey_1, _item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
