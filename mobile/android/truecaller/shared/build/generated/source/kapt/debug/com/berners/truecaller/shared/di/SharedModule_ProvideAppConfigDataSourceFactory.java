// Generated by Dagger (https://dagger.dev).
package com.berners.truecaller.shared.di;

import com.berners.truecaller.shared.data.config.AppConfigDataSource;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SharedModule_ProvideAppConfigDataSourceFactory implements Factory<AppConfigDataSource> {
  private final SharedModule module;

  private final Provider<FirebaseRemoteConfig> remoteConfigProvider;

  private final Provider<FirebaseRemoteConfigSettings> configSettingsProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  public SharedModule_ProvideAppConfigDataSourceFactory(SharedModule module,
      Provider<FirebaseRemoteConfig> remoteConfigProvider,
      Provider<FirebaseRemoteConfigSettings> configSettingsProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    this.module = module;
    this.remoteConfigProvider = remoteConfigProvider;
    this.configSettingsProvider = configSettingsProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
  }

  @Override
  public AppConfigDataSource get() {
    return provideAppConfigDataSource(module, remoteConfigProvider.get(), configSettingsProvider.get(), ioDispatcherProvider.get());
  }

  public static SharedModule_ProvideAppConfigDataSourceFactory create(SharedModule module,
      Provider<FirebaseRemoteConfig> remoteConfigProvider,
      Provider<FirebaseRemoteConfigSettings> configSettingsProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    return new SharedModule_ProvideAppConfigDataSourceFactory(module, remoteConfigProvider, configSettingsProvider, ioDispatcherProvider);
  }

  public static AppConfigDataSource provideAppConfigDataSource(SharedModule instance,
      FirebaseRemoteConfig remoteConfig, FirebaseRemoteConfigSettings configSettings,
      CoroutineDispatcher ioDispatcher) {
    return Preconditions.checkNotNullFromProvides(instance.provideAppConfigDataSource(remoteConfig, configSettings, ioDispatcher));
  }
}
