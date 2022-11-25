// Generated by Dagger (https://dagger.dev).
package com.berners.truecaller.data.domain.observers;

import com.berners.truecaller.data.local.db.daos.IncomingDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ObserveIncomings_Factory implements Factory<ObserveIncomings> {
  private final Provider<IncomingDao> incomingDaoProvider;

  public ObserveIncomings_Factory(Provider<IncomingDao> incomingDaoProvider) {
    this.incomingDaoProvider = incomingDaoProvider;
  }

  @Override
  public ObserveIncomings get() {
    return newInstance(incomingDaoProvider.get());
  }

  public static ObserveIncomings_Factory create(Provider<IncomingDao> incomingDaoProvider) {
    return new ObserveIncomings_Factory(incomingDaoProvider);
  }

  public static ObserveIncomings newInstance(IncomingDao incomingDao) {
    return new ObserveIncomings(incomingDao);
  }
}