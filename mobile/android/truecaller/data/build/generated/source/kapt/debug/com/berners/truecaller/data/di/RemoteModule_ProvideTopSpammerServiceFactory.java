// Generated by Dagger (https://dagger.dev).
package com.berners.truecaller.data.di;

import com.berners.truecaller.data.remote.services.TopSpammerService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RemoteModule_ProvideTopSpammerServiceFactory implements Factory<TopSpammerService> {
  private final RemoteModule module;

  private final Provider<Retrofit> retrofitProvider;

  public RemoteModule_ProvideTopSpammerServiceFactory(RemoteModule module,
      Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public TopSpammerService get() {
    return provideTopSpammerService(module, retrofitProvider.get());
  }

  public static RemoteModule_ProvideTopSpammerServiceFactory create(RemoteModule module,
      Provider<Retrofit> retrofitProvider) {
    return new RemoteModule_ProvideTopSpammerServiceFactory(module, retrofitProvider);
  }

  public static TopSpammerService provideTopSpammerService(RemoteModule instance,
      Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(instance.provideTopSpammerService(retrofit));
  }
}