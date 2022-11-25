package com.berners.truecaller.data.local.db.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.berners.truecaller.data.local.db.entities.EntityEntity;
import com.berners.truecaller.model.EntityType;
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
public final class EntityDao_Impl extends EntityDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EntityEntity> __insertionAdapterOfEntityEntity;

  private final EntityInsertionAdapter<EntityEntity> __insertionAdapterOfEntityEntity_1;

  private final EntityDeletionOrUpdateAdapter<EntityEntity> __deletionAdapterOfEntityEntity;

  private final EntityDeletionOrUpdateAdapter<EntityEntity> __updateAdapterOfEntityEntity;

  public EntityDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEntityEntity = new EntityInsertionAdapter<EntityEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `entities` (`id`,`rid`,`created_at`,`updated_at`,`deleted_at`,`entity_type`,`name`,`verified`,`profile_image_url`,`primary_color`,`is_user`,`is_user_premium`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EntityEntity value) {
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
        if (value.getType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, __EntityType_enumToString(value.getType()));
        }
        if (value.getName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getName());
        }
        final int _tmp = value.getVerified() ? 1 : 0;
        stmt.bindLong(8, _tmp);
        if (value.getProfileImageUrl() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getProfileImageUrl());
        }
        if (value.getPrimaryColor() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getPrimaryColor());
        }
        final int _tmp_1 = value.isUser() ? 1 : 0;
        stmt.bindLong(11, _tmp_1);
        final int _tmp_2 = value.isUserPremium() ? 1 : 0;
        stmt.bindLong(12, _tmp_2);
      }
    };
    this.__insertionAdapterOfEntityEntity_1 = new EntityInsertionAdapter<EntityEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `entities` (`id`,`rid`,`created_at`,`updated_at`,`deleted_at`,`entity_type`,`name`,`verified`,`profile_image_url`,`primary_color`,`is_user`,`is_user_premium`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EntityEntity value) {
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
        if (value.getType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, __EntityType_enumToString(value.getType()));
        }
        if (value.getName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getName());
        }
        final int _tmp = value.getVerified() ? 1 : 0;
        stmt.bindLong(8, _tmp);
        if (value.getProfileImageUrl() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getProfileImageUrl());
        }
        if (value.getPrimaryColor() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getPrimaryColor());
        }
        final int _tmp_1 = value.isUser() ? 1 : 0;
        stmt.bindLong(11, _tmp_1);
        final int _tmp_2 = value.isUserPremium() ? 1 : 0;
        stmt.bindLong(12, _tmp_2);
      }
    };
    this.__deletionAdapterOfEntityEntity = new EntityDeletionOrUpdateAdapter<EntityEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `entities` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EntityEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfEntityEntity = new EntityDeletionOrUpdateAdapter<EntityEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `entities` SET `id` = ?,`rid` = ?,`created_at` = ?,`updated_at` = ?,`deleted_at` = ?,`entity_type` = ?,`name` = ?,`verified` = ?,`profile_image_url` = ?,`primary_color` = ?,`is_user` = ?,`is_user_premium` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EntityEntity value) {
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
        if (value.getType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, __EntityType_enumToString(value.getType()));
        }
        if (value.getName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getName());
        }
        final int _tmp = value.getVerified() ? 1 : 0;
        stmt.bindLong(8, _tmp);
        if (value.getProfileImageUrl() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getProfileImageUrl());
        }
        if (value.getPrimaryColor() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getPrimaryColor());
        }
        final int _tmp_1 = value.isUser() ? 1 : 0;
        stmt.bindLong(11, _tmp_1);
        final int _tmp_2 = value.isUserPremium() ? 1 : 0;
        stmt.bindLong(12, _tmp_2);
        if (value.getId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getId());
        }
      }
    };
  }

  @Override
  public Object insert(final EntityEntity entity, final Continuation<? super Long> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfEntityEntity.insertAndReturnId(entity);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final EntityEntity[] entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEntityEntity_1.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final List<? extends EntityEntity> entities,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEntityEntity.insert(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteEntity(final EntityEntity entity, final Continuation<? super Integer> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__deletionAdapterOfEntityEntity.handle(entity);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object update(final EntityEntity entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfEntityEntity.handle(entity);
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
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> EntityDao_Impl.super.withTransaction(tx, __cont), $completion);
  }

  @Override
  public Object save(final List<? extends EntityEntity> entities,
      final Continuation<? super Unit> $completion) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> EntityDao_Impl.super.save(entities, __cont), $completion);
  }

  @Override
  public Object getEntityByRid(final long rid, final Continuation<? super EntityEntity> arg1) {
    final String _sql = "SELECT * FROM entities WHERE rid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, rid);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<EntityEntity>() {
      @Override
      public EntityEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfRid = CursorUtil.getColumnIndexOrThrow(_cursor, "rid");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
          final int _cursorIndexOfDeletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "deleted_at");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "entity_type");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "verified");
          final int _cursorIndexOfProfileImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_image_url");
          final int _cursorIndexOfPrimaryColor = CursorUtil.getColumnIndexOrThrow(_cursor, "primary_color");
          final int _cursorIndexOfIsUser = CursorUtil.getColumnIndexOrThrow(_cursor, "is_user");
          final int _cursorIndexOfIsUserPremium = CursorUtil.getColumnIndexOrThrow(_cursor, "is_user_premium");
          final EntityEntity _result;
          if(_cursor.moveToFirst()) {
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
            _result = new EntityEntity(_tmpId,_tmpRid,_tmpCreatedAt,_tmpUpdatedAt,_tmpDeletedAt,_tmpType,_tmpName,_tmpVerified,_tmpProfileImageUrl,_tmpPrimaryColor,_tmpIsUser,_tmpIsUserPremium);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg1);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __EntityType_enumToString(final EntityType _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case COMPANY: return "COMPANY";
      case PEOPLE: return "PEOPLE";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
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
}
