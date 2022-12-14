// Generated by Dagger (https://dagger.dev).
package com.berners.truecaller.data.remote.datasources;

import com.berners.truecaller.data.remote.services.PhoneService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RemotePhoneDataSource_Factory implements Factory<RemotePhoneDataSource> {
  private final Provider<PhoneService> serviceProvider;

  public RemotePhoneDataSource_Factory(Provider<PhoneService> serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  @Override
  public RemotePhoneDataSource get() {
    return newInstance(serviceProvider.get());
  }

  public static RemotePhoneDataSource_Factory create(Provider<PhoneService> serviceProvider) {
    return new RemotePhoneDataSource_Factory(serviceProvider);
  }

  public static RemotePhoneDataSource newInstance(PhoneService service) {
    return new RemotePhoneDataSource(service);
  }
}
