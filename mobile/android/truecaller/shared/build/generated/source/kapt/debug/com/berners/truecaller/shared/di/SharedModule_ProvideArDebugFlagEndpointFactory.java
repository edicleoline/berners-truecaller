// Generated by Dagger (https://dagger.dev).
package com.berners.truecaller.shared.di;

import com.berners.truecaller.shared.data.ar.ArDebugFlagEndpoint;
import com.google.firebase.functions.FirebaseFunctions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SharedModule_ProvideArDebugFlagEndpointFactory implements Factory<ArDebugFlagEndpoint> {
  private final SharedModule module;

  private final Provider<FirebaseFunctions> functionsProvider;

  public SharedModule_ProvideArDebugFlagEndpointFactory(SharedModule module,
      Provider<FirebaseFunctions> functionsProvider) {
    this.module = module;
    this.functionsProvider = functionsProvider;
  }

  @Override
  public ArDebugFlagEndpoint get() {
    return provideArDebugFlagEndpoint(module, functionsProvider.get());
  }

  public static SharedModule_ProvideArDebugFlagEndpointFactory create(SharedModule module,
      Provider<FirebaseFunctions> functionsProvider) {
    return new SharedModule_ProvideArDebugFlagEndpointFactory(module, functionsProvider);
  }

  public static ArDebugFlagEndpoint provideArDebugFlagEndpoint(SharedModule instance,
      FirebaseFunctions functions) {
    return Preconditions.checkNotNullFromProvides(instance.provideArDebugFlagEndpoint(functions));
  }
}
