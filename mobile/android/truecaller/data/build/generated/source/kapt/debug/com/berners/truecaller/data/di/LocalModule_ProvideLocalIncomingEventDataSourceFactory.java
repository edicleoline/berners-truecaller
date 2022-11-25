// Generated by Dagger (https://dagger.dev).
package com.berners.truecaller.data.di;

import com.berners.truecaller.data.local.datasources.LocalIncomingEventDataSource;
import com.berners.truecaller.data.local.db.AppDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LocalModule_ProvideLocalIncomingEventDataSourceFactory implements Factory<LocalIncomingEventDataSource> {
  private final Provider<AppDatabase> appDatabaseProvider;

  public LocalModule_ProvideLocalIncomingEventDataSourceFactory(
      Provider<AppDatabase> appDatabaseProvider) {
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public LocalIncomingEventDataSource get() {
    return provideLocalIncomingEventDataSource(appDatabaseProvider.get());
  }

  public static LocalModule_ProvideLocalIncomingEventDataSourceFactory create(
      Provider<AppDatabase> appDatabaseProvider) {
    return new LocalModule_ProvideLocalIncomingEventDataSourceFactory(appDatabaseProvider);
  }

  public static LocalIncomingEventDataSource provideLocalIncomingEventDataSource(
      AppDatabase appDatabase) {
    return Preconditions.checkNotNullFromProvides(LocalModule.INSTANCE.provideLocalIncomingEventDataSource(appDatabase));
  }
}
