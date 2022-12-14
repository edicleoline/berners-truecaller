// Generated by Dagger (https://dagger.dev).
package com.berners.truecaller.shared.domain.prefs;

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
public final class OnboardingCompleteActionUseCase_Factory implements Factory<OnboardingCompleteActionUseCase> {
  private final Provider<PreferenceStorage> preferenceStorageProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public OnboardingCompleteActionUseCase_Factory(
      Provider<PreferenceStorage> preferenceStorageProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.preferenceStorageProvider = preferenceStorageProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public OnboardingCompleteActionUseCase get() {
    return newInstance(preferenceStorageProvider.get(), dispatcherProvider.get());
  }

  public static OnboardingCompleteActionUseCase_Factory create(
      Provider<PreferenceStorage> preferenceStorageProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new OnboardingCompleteActionUseCase_Factory(preferenceStorageProvider, dispatcherProvider);
  }

  public static OnboardingCompleteActionUseCase newInstance(PreferenceStorage preferenceStorage,
      CoroutineDispatcher dispatcher) {
    return new OnboardingCompleteActionUseCase(preferenceStorage, dispatcher);
  }
}
