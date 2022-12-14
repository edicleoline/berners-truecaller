// Generated by Dagger (https://dagger.dev).
package com.berners.truecaller.shared.domain.settings;

import com.berners.truecaller.shared.data.prefs.PreferenceStorage;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GetNotificationsSettingUseCase_Factory implements Factory<GetNotificationsSettingUseCase> {
  private final Provider<PreferenceStorage> preferenceStorageProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public GetNotificationsSettingUseCase_Factory(
      Provider<PreferenceStorage> preferenceStorageProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.preferenceStorageProvider = preferenceStorageProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public GetNotificationsSettingUseCase get() {
    return newInstance(preferenceStorageProvider.get(), dispatcherProvider.get());
  }

  public static GetNotificationsSettingUseCase_Factory create(
      Provider<PreferenceStorage> preferenceStorageProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new GetNotificationsSettingUseCase_Factory(preferenceStorageProvider, dispatcherProvider);
  }

  public static GetNotificationsSettingUseCase newInstance(PreferenceStorage preferenceStorage,
      CoroutineDispatcher dispatcher) {
    return new GetNotificationsSettingUseCase(preferenceStorage, dispatcher);
  }
}
