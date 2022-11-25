// Generated by Dagger (https://dagger.dev).
package com.berners.truecaller.shared.util;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkUtils_Factory implements Factory<NetworkUtils> {
  private final Provider<Context> contextProvider;

  public NetworkUtils_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NetworkUtils get() {
    return newInstance(contextProvider.get());
  }

  public static NetworkUtils_Factory create(Provider<Context> contextProvider) {
    return new NetworkUtils_Factory(contextProvider);
  }

  public static NetworkUtils newInstance(Context context) {
    return new NetworkUtils(context);
  }
}