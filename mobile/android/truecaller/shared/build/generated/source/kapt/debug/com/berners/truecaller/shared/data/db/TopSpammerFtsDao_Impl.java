package com.berners.truecaller.shared.data.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TopSpammerFtsDao_Impl implements TopSpammerFtsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TopSpammerFtsEntity> __insertionAdapterOfTopSpammerFtsEntity;

  public TopSpammerFtsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTopSpammerFtsEntity = new EntityInsertionAdapter<TopSpammerFtsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `topSpammersFts` (`top_spammer_id`,`phone_e164_format`,`label`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TopSpammerFtsEntity value) {
        if (value.getTopSpammerId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTopSpammerId());
        }
        if (value.getPhoneE164Format() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPhoneE164Format());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLabel());
        }
      }
    };
  }

  @Override
  public void insertAll(final List<TopSpammerFtsEntity> topSpammers) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTopSpammerFtsEntity.insert(topSpammers);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<String> searchAllTopSpammers(final String query) {
    final String _sql = "SELECT top_spammer_id FROM topSpammersFts WHERE topSpammersFts MATCH ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        final String _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(0);
        }
        _item = _tmp;
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
