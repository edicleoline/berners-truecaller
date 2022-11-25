package com.berners.truecaller.data.remote.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/berners/truecaller/data/remote/model/PhoneNumberType;", "", "(Ljava/lang/String;I)V", "MOBILE", "FIXED_LINE", "UNKNOWN", "Adapter", "data_debug"})
public enum PhoneNumberType {
    /*public static final*/ MOBILE /* = new MOBILE() */,
    /*public static final*/ FIXED_LINE /* = new FIXED_LINE() */,
    /*public static final*/ UNKNOWN /* = new UNKNOWN() */;
    @org.jetbrains.annotations.NotNull()
    public static final com.berners.truecaller.data.remote.model.PhoneNumberType.Adapter Adapter = null;
    
    PhoneNumberType() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/berners/truecaller/data/remote/model/PhoneNumberType$Adapter;", "", "()V", "fromJson", "Lcom/berners/truecaller/data/remote/model/PhoneNumberType;", "name", "", "toJson", "type", "data_debug"})
    public static final class Adapter {
        
        private Adapter() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @com.squareup.moshi.ToJson()
        public final java.lang.String toJson(@org.jetbrains.annotations.NotNull()
        com.berners.truecaller.data.remote.model.PhoneNumberType type) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @com.squareup.moshi.FromJson()
        public final com.berners.truecaller.data.remote.model.PhoneNumberType fromJson(@org.jetbrains.annotations.NotNull()
        java.lang.String name) {
            return null;
        }
    }
}