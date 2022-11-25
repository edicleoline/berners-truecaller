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
public final class OnboardingCompletedUseCase_Factory implements Factory<OnboardingCompletedUseCase> {
  private final Provider<PreferenceStorage> preferenceStorageProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public OnboardingCompletedUseCase_Factory(Provider<PreferenceStorage> preferenceStorageProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.preferenceStorageProvider = preferenceStorageProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public OnboardingCompletedUseCase get() {
    return newInstance(preferenceStorageProvider.get(), dispatcherProvider.get());
  }

  public static OnboardingCompletedUseCase_Factory create(
      Provider<PreferenceStorage> preferenceStorageProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new OnboardingCompletedUseCase_Factory(preferenceStorageProvider, dispatcherProvider);
  }

  public static OnboardingCompletedUseCase newInstance(PreferenceStorage preferenceStorage,
      CoroutineDispatcher dispatcher) {
    return new OnboardingCompletedUseCase(preferenceStorage, dispatcher);
  }
}