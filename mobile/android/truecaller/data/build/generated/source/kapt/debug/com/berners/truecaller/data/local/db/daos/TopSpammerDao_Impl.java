package com.berners.truecaller.data.local.db.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.berners.truecaller.data.local.db.entities.TopSpammerEntity;
import com.berners.truecaller.model.IncomingType;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TopSpammerDao_Impl implements TopSpammerDao {
  private final RoomDatabase __db;

  public TopSpammerDao_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public Object all(final Continuation<? super List<TopSpammerEntity>> arg0) {
    final String _sql = "SELECT * FROM top_spammers";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TopSpammerEntity>>() {
      @Override
      public List<TopSpammerEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final int _cursorIndexOfReportsCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reports_count");
          final int _cursorIndexOfPhoneE164Format = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_e164_format");
          final int _cursorIndexOfIncomingType = CursorUtil.getColumnIndexOrThrow(_cursor, "incoming_type");
          final List<TopSpammerEntity> _result = new ArrayList<TopSpammerEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TopSpammerEntity _item;
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
            final int _tmpReportsCount;
            _tmpReportsCount = _cursor.getInt(_cursorIndexOfReportsCount);
            final String _tmpPhoneE164Format;
            if (_cursor.isNull(_cursorIndexOfPhoneE164Format)) {
              _tmpPhoneE164Format = null;
            } else {
              _tmpPhoneE164Format = _cursor.getString(_cursorIndexOfPhoneE164Format);
            }
            final IncomingType _tmpIncomingType;
            _tmpIncomingType = __IncomingType_stringToEnum(_cursor.getString(_cursorIndexOfIncomingType));
            _item = new TopSpammerEntity(_tmpId,_tmpLabel,_tmpReportsCount,_tmpPhoneE164Format,_tmpIncomingType);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg0);
  }

  @Override
  public Object listByIncomingType(final IncomingType incomingType,
      final Continuation<? super List<TopSpammerEntity>> arg1) {
    final String _sql = "SELECT * FROM top_spammers WHERE incoming_type LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (incomingType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, __IncomingType_enumToString(incomingType));
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TopSpammerEntity>>() {
      @Override
      public List<TopSpammerEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final int _cursorIndexOfReportsCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reports_count");
          final int _cursorIndexOfPhoneE164Format = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_e164_format");
          final int _cursorIndexOfIncomingType = CursorUtil.getColumnIndexOrThrow(_cursor, "incoming_type");
          final List<TopSpammerEntity> _result = new ArrayList<TopSpammerEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TopSpammerEntity _item;
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
            final int _tmpReportsCount;
            _tmpReportsCount = _cursor.getInt(_cursorIndexOfReportsCount);
            final String _tmpPhoneE164Format;
            if (_cursor.isNull(_cursorIndexOfPhoneE164Format)) {
              _tmpPhoneE164Format = null;
            } else {
              _tmpPhoneE164Format = _cursor.getString(_cursorIndexOfPhoneE164Format);
            }
            final IncomingType _tmpIncomingType;
            _tmpIncomingType = __IncomingType_stringToEnum(_cursor.getString(_cursorIndexOfIncomingType));
            _item = new TopSpammerEntity(_tmpId,_tmpLabel,_tmpReportsCount,_tmpPhoneE164Format,_tmpIncomingType);
            _result.add(_item);
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

  private IncomingType __IncomingType_stringToEnum(final String _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case "CALL": return IncomingType.CALL;
      case "SMS": return IncomingType.SMS;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private String __IncomingType_enumToString(final IncomingType _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case CALL: return "CALL";
      case SMS: return "SMS";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }
}
