// Generated by Dagger (https://dagger.dev).
package com.berners.truecaller.data.di;

import com.berners.truecaller.data.remote.datasources.RemotePhoneDataSource;
import com.berners.truecaller.data.remote.services.PhoneService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RemoteModule_ProvideRemotePhoneDataSourceFactory implements Factory<RemotePhoneDataSource> {
  private final RemoteModule module;

  private final Provider<PhoneService> serviceProvider;

  public RemoteModule_ProvideRemotePhoneDataSourceFactory(RemoteModule module,
      Provider<PhoneService> serviceProvider) {
    this.module = module;
    this.serviceProvider = serviceProvider;
  }

  @Override
  public RemotePhoneDataSource get() {
    return provideRemotePhoneDataSource(module, serviceProvider.get());
  }

  public static RemoteModule_ProvideRemotePhoneDataSourceFactory create(RemoteModule module,
      Provider<PhoneService> serviceProvider) {
    return new RemoteModule_ProvideRemotePhoneDataSourceFactory(module, serviceProvider);
  }

  public static RemotePhoneDataSource provideRemotePhoneDataSource(RemoteModule instance,
      PhoneService service) {
    return Preconditions.checkNotNullFromProvides(instance.provideRemotePhoneDataSource(service));
  }
}
