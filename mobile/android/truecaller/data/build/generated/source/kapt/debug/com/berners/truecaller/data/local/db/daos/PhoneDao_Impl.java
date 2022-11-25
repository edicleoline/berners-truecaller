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
import com.berners.truecaller.data.local.db.entities.PhoneEntity;
import com.berners.truecaller.model.PhoneNumberType;
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
public final class PhoneDao_Impl extends PhoneDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PhoneEntity> __insertionAdapterOfPhoneEntity;

  private final EntityInsertionAdapter<PhoneEntity> __insertionAdapterOfPhoneEntity_1;

  private final EntityDeletionOrUpdateAdapter<PhoneEntity> __deletionAdapterOfPhoneEntity;

  private final EntityDeletionOrUpdateAdapter<PhoneEntity> __updateAdapterOfPhoneEntity;

  public PhoneDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPhoneEntity = new EntityInsertionAdapter<PhoneEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `phones` (`id`,`rid`,`created_at`,`updated_at`,`deleted_at`,`phone`,`e164_format`,`national_format`,`dialing_code`,`country_code`,`number_type`,`location_formatted`,`entity_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PhoneEntity value) {
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
        if (value.getPhone() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPhone());
        }
        if (value.getE164Format() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getE164Format());
        }
        if (value.getNationalFormat() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNationalFormat());
        }
        if (value.getDialingCode() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDialingCode());
        }
        if (value.getCountryCode() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCountryCode());
        }
        if (value.getNumberType() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, __PhoneNumberType_enumToString(value.getNumberType()));
        }
        if (value.getLocationFormatted() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLocationFormatted());
        }
        if (value.getEntityId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getEntityId());
        }
      }
    };
    this.__insertionAdapterOfPhoneEntity_1 = new EntityInsertionAdapter<PhoneEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `phones` (`id`,`rid`,`created_at`,`updated_at`,`deleted_at`,`phone`,`e164_format`,`national_format`,`dialing_code`,`country_code`,`number_type`,`location_formatted`,`entity_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PhoneEntity value) {
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
        if (value.getPhone() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPhone());
        }
        if (value.getE164Format() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getE164Format());
        }
        if (value.getNationalFormat() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNationalFormat());
        }
        if (value.getDialingCode() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDialingCode());
        }
        if (value.getCountryCode() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCountryCode());
        }
        if (value.getNumberType() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, __PhoneNumberType_enumToString(value.getNumberType()));
        }
        if (value.getLocationFormatted() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLocationFormatted());
        }
        if (value.getEntityId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getEntityId());
        }
      }
    };
    this.__deletionAdapterOfPhoneEntity = new EntityDeletionOrUpdateAdapter<PhoneEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `phones` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PhoneEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfPhoneEntity = new EntityDeletionOrUpdateAdapter<PhoneEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `phones` SET `id` = ?,`rid` = ?,`created_at` = ?,`updated_at` = ?,`deleted_at` = ?,`phone` = ?,`e164_format` = ?,`national_format` = ?,`dialing_code` = ?,`country_code` = ?,`number_type` = ?,`location_formatted` = ?,`entity_id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PhoneEntity value) {
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
        if (value.getPhone() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPhone());
        }
        if (value.getE164Format() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getE164Format());
        }
        if (value.getNationalFormat() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNationalFormat());
        }
        if (value.getDialingCode() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDialingCode());
        }
        if (value.getCountryCode() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCountryCode());
        }
        if (value.getNumberType() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, __PhoneNumberType_enumToString(value.getNumberType()));
        }
        if (value.getLocationFormatted() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLocationFormatted());
        }
        if (value.getEntityId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getEntityId());
        }
        if (value.getId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getId());
        }
      }
    };
  }

  @Override
  public Object insert(final PhoneEntity entity, final Continuation<? super Long> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfPhoneEntity.insertAndReturnId(entity);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final PhoneEntity[] entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPhoneEntity_1.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final List<? extends PhoneEntity> entities,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPhoneEntity.insert(entities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteEntity(final PhoneEntity entity, final Continuation<? super Integer> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__deletionAdapterOfPhoneEntity.handle(entity);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object update(final PhoneEntity entity, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPhoneEntity.handle(entity);
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
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> PhoneDao_Impl.super.withTransaction(tx, __cont), $completion);
  }

  @Override
  public Object save(final List<? extends PhoneEntity> entities,
      final Continuation<? super Unit> $completion) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> PhoneDao_Impl.super.save(entities, __cont), $completion);
  }

  @Override
  public Object getPhoneById(final long id, final Continuation<? super PhoneEntity> arg1) {
    final String _sql = "SELECT * FROM phones WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PhoneEntity>() {
      @Override
      public PhoneEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfRid = CursorUtil.getColumnIndexOrThrow(_cursor, "rid");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
          final int _cursorIndexOfDeletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "deleted_at");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfE164Format = CursorUtil.getColumnIndexOrThrow(_cursor, "e164_format");
          final int _cursorIndexOfNationalFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "national_format");
          final int _cursorIndexOfDialingCode = CursorUtil.getColumnIndexOrThrow(_cursor, "dialing_code");
          final int _cursorIndexOfCountryCode = CursorUtil.getColumnIndexOrThrow(_cursor, "country_code");
          final int _cursorIndexOfNumberType = CursorUtil.getColumnIndexOrThrow(_cursor, "number_type");
          final int _cursorIndexOfLocationFormatted = CursorUtil.getColumnIndexOrThrow(_cursor, "location_formatted");
          final int _cursorIndexOfEntityId = CursorUtil.getColumnIndexOrThrow(_cursor, "entity_id");
          final PhoneEntity _result;
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
            _result = new PhoneEntity(_tmpId,_tmpRid,_tmpCreatedAt,_tmpUpdatedAt,_tmpDeletedAt,_tmpPhone,_tmpE164Format,_tmpNationalFormat,_tmpDialingCode,_tmpCountryCode,_tmpNumberType,_tmpLocationFormatted,_tmpEntityId);
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

  @Override
  public Object getPhoneByE164Format(final String e164Format,
      final Continuation<? super PhoneEntity> arg1) {
    final String _sql = "SELECT * FROM phones WHERE e164_format like ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (e164Format == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, e164Format);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PhoneEntity>() {
      @Override
      public PhoneEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfRid = CursorUtil.getColumnIndexOrThrow(_cursor, "rid");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
          final int _cursorIndexOfDeletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "deleted_at");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfE164Format = CursorUtil.getColumnIndexOrThrow(_cursor, "e164_format");
          final int _cursorIndexOfNationalFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "national_format");
          final int _cursorIndexOfDialingCode = CursorUtil.getColumnIndexOrThrow(_cursor, "dialing_code");
          final int _cursorIndexOfCountryCode = CursorUtil.getColumnIndexOrThrow(_cursor, "country_code");
          final int _cursorIndexOfNumberType = CursorUtil.getColumnIndexOrThrow(_cursor, "number_type");
          final int _cursorIndexOfLocationFormatted = CursorUtil.getColumnIndexOrThrow(_cursor, "location_formatted");
          final int _cursorIndexOfEntityId = CursorUtil.getColumnIndexOrThrow(_cursor, "entity_id");
          final PhoneEntity _result;
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
            _result = new PhoneEntity(_tmpId,_tmpRid,_tmpCreatedAt,_tmpUpdatedAt,_tmpDeletedAt,_tmpPhone,_tmpE164Format,_tmpNationalFormat,_tmpDialingCode,_tmpCountryCode,_tmpNumberType,_tmpLocationFormatted,_tmpEntityId);
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

  @Override
  public Object getPhoneByRid(final long rid, final Continuation<? super PhoneEntity> arg1) {
    final String _sql = "SELECT * FROM phones WHERE rid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, rid);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PhoneEntity>() {
      @Override
      public PhoneEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfRid = CursorUtil.getColumnIndexOrThrow(_cursor, "rid");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
          final int _cursorIndexOfDeletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "deleted_at");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfE164Format = CursorUtil.getColumnIndexOrThrow(_cursor, "e164_format");
          final int _cursorIndexOfNationalFormat = CursorUtil.getColumnIndexOrThrow(_cursor, "national_format");
          final int _cursorIndexOfDialingCode = CursorUtil.getColumnIndexOrThrow(_cursor, "dialing_code");
          final int _cursorIndexOfCountryCode = CursorUtil.getColumnIndexOrThrow(_cursor, "country_code");
          final int _cursorIndexOfNumberType = CursorUtil.getColumnIndexOrThrow(_cursor, "number_type");
          final int _cursorIndexOfLocationFormatted = CursorUtil.getColumnIndexOrThrow(_cursor, "location_formatted");
          final int _cursorIndexOfEntityId = CursorUtil.getColumnIndexOrThrow(_cursor, "entity_id");
          final PhoneEntity _result;
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
            _result = new PhoneEntity(_tmpId,_tmpRid,_tmpCreatedAt,_tmpUpdatedAt,_tmpDeletedAt,_tmpPhone,_tmpE164Format,_tmpNationalFormat,_tmpDialingCode,_tmpCountryCode,_tmpNumberType,_tmpLocationFormatted,_tmpEntityId);
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

  private String __PhoneNumberType_enumToString(final PhoneNumberType _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case MOBILE: return "MOBILE";
      case FIXED_LINE: return "FIXED_LINE";
      case UNKNOWN: return "UNKNOWN";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
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
}
