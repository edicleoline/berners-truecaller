package com.berners.truecaller.data.local.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.berners.truecaller.data.local.db.daos.EntityDao;
import com.berners.truecaller.data.local.db.daos.EntityDao_Impl;
import com.berners.truecaller.data.local.db.daos.IncomingDao;
import com.berners.truecaller.data.local.db.daos.IncomingDao_Impl;
import com.berners.truecaller.data.local.db.daos.IncomingEventDao;
import com.berners.truecaller.data.local.db.daos.IncomingEventDao_Impl;
import com.berners.truecaller.data.local.db.daos.PhoneDao;
import com.berners.truecaller.data.local.db.daos.PhoneDao_Impl;
import com.berners.truecaller.data.local.db.daos.TopSpammerDao;
import com.berners.truecaller.data.local.db.daos.TopSpammerDao_Impl;
import com.berners.truecaller.data.local.db.daos.UserDao;
import com.berners.truecaller.data.local.db.daos.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserDao _userDao;

  private volatile TopSpammerDao _topSpammerDao;

  private volatile EntityDao _entityDao;

  private volatile PhoneDao _phoneDao;

  private volatile IncomingDao _incomingDao;

  private volatile IncomingEventDao _incomingEventDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` INTEGER, `name` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `top_spammers` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `label` TEXT NOT NULL, `reports_count` INTEGER NOT NULL, `phone_e164_format` TEXT NOT NULL, `incoming_type` TEXT)");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_top_spammers_phone_e164_format_incoming_type` ON `top_spammers` (`phone_e164_format`, `incoming_type`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `entities` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `rid` INTEGER, `created_at` INTEGER, `updated_at` INTEGER, `deleted_at` INTEGER, `entity_type` TEXT NOT NULL, `name` TEXT, `verified` INTEGER NOT NULL, `profile_image_url` TEXT, `primary_color` TEXT NOT NULL, `is_user` INTEGER NOT NULL, `is_user_premium` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `phones` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `rid` INTEGER, `created_at` INTEGER, `updated_at` INTEGER, `deleted_at` INTEGER, `phone` TEXT NOT NULL, `e164_format` TEXT NOT NULL, `national_format` TEXT, `dialing_code` TEXT, `country_code` TEXT, `number_type` TEXT, `location_formatted` TEXT, `entity_id` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `incomings` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `rid` INTEGER, `created_at` INTEGER, `updated_at` INTEGER, `deleted_at` INTEGER, `source_id` INTEGER NOT NULL, `target_id` INTEGER NOT NULL, `direction` TEXT NOT NULL, `decision_owner` TEXT, `decision_type` TEXT, `decision_spam` INTEGER, `decision_message` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `incoming_events` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `rid` INTEGER, `created_at` INTEGER, `updated_at` INTEGER, `deleted_at` INTEGER, `incoming_id` INTEGER NOT NULL, `event_type` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, FOREIGN KEY(`incoming_id`) REFERENCES `incomings`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6084775f281db27e39173de6dacb1c60')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `users`");
        _db.execSQL("DROP TABLE IF EXISTS `top_spammers`");
        _db.execSQL("DROP TABLE IF EXISTS `entities`");
        _db.execSQL("DROP TABLE IF EXISTS `phones`");
        _db.execSQL("DROP TABLE IF EXISTS `incomings`");
        _db.execSQL("DROP TABLE IF EXISTS `incoming_events`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(2);
        _columnsUsers.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(_db, "users");
        if (! _infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.berners.truecaller.data.local.db.entities.UserEntity).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsTopSpammers = new HashMap<String, TableInfo.Column>(5);
        _columnsTopSpammers.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopSpammers.put("label", new TableInfo.Column("label", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopSpammers.put("reports_count", new TableInfo.Column("reports_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopSpammers.put("phone_e164_format", new TableInfo.Column("phone_e164_format", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTopSpammers.put("incoming_type", new TableInfo.Column("incoming_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTopSpammers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTopSpammers = new HashSet<TableInfo.Index>(1);
        _indicesTopSpammers.add(new TableInfo.Index("index_top_spammers_phone_e164_format_incoming_type", true, Arrays.asList("phone_e164_format","incoming_type"), Arrays.asList("ASC","ASC")));
        final TableInfo _infoTopSpammers = new TableInfo("top_spammers", _columnsTopSpammers, _foreignKeysTopSpammers, _indicesTopSpammers);
        final TableInfo _existingTopSpammers = TableInfo.read(_db, "top_spammers");
        if (! _infoTopSpammers.equals(_existingTopSpammers)) {
          return new RoomOpenHelper.ValidationResult(false, "top_spammers(com.berners.truecaller.data.local.db.entities.TopSpammerEntity).\n"
                  + " Expected:\n" + _infoTopSpammers + "\n"
                  + " Found:\n" + _existingTopSpammers);
        }
        final HashMap<String, TableInfo.Column> _columnsEntities = new HashMap<String, TableInfo.Column>(12);
        _columnsEntities.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEntities.put("rid", new TableInfo.Column("rid", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEntities.put("created_at", new TableInfo.Column("created_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEntities.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEntities.put("deleted_at", new TableInfo.Column("deleted_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEntities.put("entity_type", new TableInfo.Column("entity_type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEntities.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEntities.put("verified", new TableInfo.Column("verified", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEntities.put("profile_image_url", new TableInfo.Column("profile_image_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEntities.put("primary_color", new TableInfo.Column("primary_color", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEntities.put("is_user", new TableInfo.Column("is_user", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEntities.put("is_user_premium", new TableInfo.Column("is_user_premium", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEntities = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEntities = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEntities = new TableInfo("entities", _columnsEntities, _foreignKeysEntities, _indicesEntities);
        final TableInfo _existingEntities = TableInfo.read(_db, "entities");
        if (! _infoEntities.equals(_existingEntities)) {
          return new RoomOpenHelper.ValidationResult(false, "entities(com.berners.truecaller.data.local.db.entities.EntityEntity).\n"
                  + " Expected:\n" + _infoEntities + "\n"
                  + " Found:\n" + _existingEntities);
        }
        final HashMap<String, TableInfo.Column> _columnsPhones = new HashMap<String, TableInfo.Column>(13);
        _columnsPhones.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhones.put("rid", new TableInfo.Column("rid", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhones.put("created_at", new TableInfo.Column("created_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhones.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhones.put("deleted_at", new TableInfo.Column("deleted_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhones.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhones.put("e164_format", new TableInfo.Column("e164_format", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhones.put("national_format", new TableInfo.Column("national_format", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhones.put("dialing_code", new TableInfo.Column("dialing_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhones.put("country_code", new TableInfo.Column("country_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhones.put("number_type", new TableInfo.Column("number_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhones.put("location_formatted", new TableInfo.Column("location_formatted", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhones.put("entity_id", new TableInfo.Column("entity_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPhones = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPhones = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPhones = new TableInfo("phones", _columnsPhones, _foreignKeysPhones, _indicesPhones);
        final TableInfo _existingPhones = TableInfo.read(_db, "phones");
        if (! _infoPhones.equals(_existingPhones)) {
          return new RoomOpenHelper.ValidationResult(false, "phones(com.berners.truecaller.data.local.db.entities.PhoneEntity).\n"
                  + " Expected:\n" + _infoPhones + "\n"
                  + " Found:\n" + _existingPhones);
        }
        final HashMap<String, TableInfo.Column> _columnsIncomings = new HashMap<String, TableInfo.Column>(12);
        _columnsIncomings.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomings.put("rid", new TableInfo.Column("rid", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomings.put("created_at", new TableInfo.Column("created_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomings.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomings.put("deleted_at", new TableInfo.Column("deleted_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomings.put("source_id", new TableInfo.Column("source_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomings.put("target_id", new TableInfo.Column("target_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomings.put("direction", new TableInfo.Column("direction", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomings.put("decision_owner", new TableInfo.Column("decision_owner", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomings.put("decision_type", new TableInfo.Column("decision_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomings.put("decision_spam", new TableInfo.Column("decision_spam", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomings.put("decision_message", new TableInfo.Column("decision_message", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIncomings = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesIncomings = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoIncomings = new TableInfo("incomings", _columnsIncomings, _foreignKeysIncomings, _indicesIncomings);
        final TableInfo _existingIncomings = TableInfo.read(_db, "incomings");
        if (! _infoIncomings.equals(_existingIncomings)) {
          return new RoomOpenHelper.ValidationResult(false, "incomings(com.berners.truecaller.data.local.db.entities.IncomingEntity).\n"
                  + " Expected:\n" + _infoIncomings + "\n"
                  + " Found:\n" + _existingIncomings);
        }
        final HashMap<String, TableInfo.Column> _columnsIncomingEvents = new HashMap<String, TableInfo.Column>(8);
        _columnsIncomingEvents.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomingEvents.put("rid", new TableInfo.Column("rid", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomingEvents.put("created_at", new TableInfo.Column("created_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomingEvents.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomingEvents.put("deleted_at", new TableInfo.Column("deleted_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomingEvents.put("incoming_id", new TableInfo.Column("incoming_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomingEvents.put("event_type", new TableInfo.Column("event_type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIncomingEvents.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIncomingEvents = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysIncomingEvents.add(new TableInfo.ForeignKey("incomings", "CASCADE", "CASCADE",Arrays.asList("incoming_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesIncomingEvents = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoIncomingEvents = new TableInfo("incoming_events", _columnsIncomingEvents, _foreignKeysIncomingEvents, _indicesIncomingEvents);
        final TableInfo _existingIncomingEvents = TableInfo.read(_db, "incoming_events");
        if (! _infoIncomingEvents.equals(_existingIncomingEvents)) {
          return new RoomOpenHelper.ValidationResult(false, "incoming_events(com.berners.truecaller.data.local.db.entities.IncomingEventEntity).\n"
                  + " Expected:\n" + _infoIncomingEvents + "\n"
                  + " Found:\n" + _existingIncomingEvents);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "6084775f281db27e39173de6dacb1c60", "a765a579f689bb500e0a769b7af5793f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "users","top_spammers","entities","phones","incomings","incoming_events");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `top_spammers`");
      _db.execSQL("DELETE FROM `entities`");
      _db.execSQL("DELETE FROM `phones`");
      _db.execSQL("DELETE FROM `incomings`");
      _db.execSQL("DELETE FROM `incoming_events`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TopSpammerDao.class, TopSpammerDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(EntityDao.class, EntityDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PhoneDao.class, PhoneDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(IncomingDao.class, IncomingDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(IncomingEventDao.class, IncomingEventDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public TopSpammerDao topSpammerDao() {
    if (_topSpammerDao != null) {
      return _topSpammerDao;
    } else {
      synchronized(this) {
        if(_topSpammerDao == null) {
          _topSpammerDao = new TopSpammerDao_Impl(this);
        }
        return _topSpammerDao;
      }
    }
  }

  @Override
  public EntityDao entityDao() {
    if (_entityDao != null) {
      return _entityDao;
    } else {
      synchronized(this) {
        if(_entityDao == null) {
          _entityDao = new EntityDao_Impl(this);
        }
        return _entityDao;
      }
    }
  }

  @Override
  public PhoneDao phoneDao() {
    if (_phoneDao != null) {
      return _phoneDao;
    } else {
      synchronized(this) {
        if(_phoneDao == null) {
          _phoneDao = new PhoneDao_Impl(this);
        }
        return _phoneDao;
      }
    }
  }

  @Override
  public IncomingDao incomingDao() {
    if (_incomingDao != null) {
      return _incomingDao;
    } else {
      synchronized(this) {
        if(_incomingDao == null) {
          _incomingDao = new IncomingDao_Impl(this);
        }
        return _incomingDao;
      }
    }
  }

  @Override
  public IncomingEventDao incomingStateDao() {
    if (_incomingEventDao != null) {
      return _incomingEventDao;
    } else {
      synchronized(this) {
        if(_incomingEventDao == null) {
          _incomingEventDao = new IncomingEventDao_Impl(this);
        }
        return _incomingEventDao;
      }
    }
  }
}
