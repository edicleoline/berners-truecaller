// Generated by Dagger (https://dagger.dev).
package com.berners.truecaller.data.di;

import com.berners.truecaller.data.local.datasources.LocalIncomingDataSource;
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
public final class LocalModule_ProvideLocalIncomingDataSourceFactory implements Factory<LocalIncomingDataSource> {
  private final Provider<AppDatabase> appDatabaseProvider;

  public LocalModule_ProvideLocalIncomingDataSourceFactory(
      Provider<AppDatabase> appDatabaseProvider) {
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public LocalIncomingDataSource get() {
    return provideLocalIncomingDataSource(appDatabaseProvider.get());
  }

  public static LocalModule_ProvideLocalIncomingDataSourceFactory create(
      Provider<AppDatabase> appDatabaseProvider) {
    return new LocalModule_ProvideLocalIncomingDataSourceFactory(appDatabaseProvider);
  }

  public static LocalIncomingDataSource provideLocalIncomingDataSource(AppDatabase appDatabase) {
    return Preconditions.checkNotNullFromProvides(LocalModule.INSTANCE.provideLocalIncomingDataSource(appDatabase));
  }
}