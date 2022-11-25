// Generated by Dagger (https://dagger.dev).
package com.berners.truecaller.shared.di;

import com.berners.truecaller.shared.fcm.TopicSubscriber;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SharedModule_ProvideTopicSubscriberFactory implements Factory<TopicSubscriber> {
  private final SharedModule module;

  public SharedModule_ProvideTopicSubscriberFactory(SharedModule module) {
    this.module = module;
  }

  @Override
  public TopicSubscriber get() {
    return provideTopicSubscriber(module);
  }

  public static SharedModule_ProvideTopicSubscriberFactory create(SharedModule module) {
    return new SharedModule_ProvideTopicSubscriberFactory(module);
  }

  public static TopicSubscriber provideTopicSubscriber(SharedModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideTopicSubscriber());
  }
}