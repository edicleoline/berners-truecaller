package com.berners.truecaller.data.domain.observers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u000bB\u000f\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\t2\u0006\u0010\n\u001a\u00020\u0002H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/berners/truecaller/data/domain/observers/ObserveIncomings;", "Lcom/berners/truecaller/data/domain/SubjectInteractor;", "Lcom/berners/truecaller/data/domain/observers/ObserveIncomings$Params;", "", "Lcom/berners/truecaller/model/Incoming;", "incomingDao", "Lcom/berners/truecaller/data/local/db/daos/IncomingDao;", "(Lcom/berners/truecaller/data/local/db/daos/IncomingDao;)V", "createObservable", "Lkotlinx/coroutines/flow/Flow;", "params", "Params", "data_debug"})
public final class ObserveIncomings extends com.berners.truecaller.data.domain.SubjectInteractor<com.berners.truecaller.data.domain.observers.ObserveIncomings.Params, java.util.List<? extends com.berners.truecaller.model.Incoming>> {
    private final com.berners.truecaller.data.local.db.daos.IncomingDao incomingDao = null;
    
    @javax.inject.Inject()
    public ObserveIncomings(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.daos.IncomingDao incomingDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected kotlinx.coroutines.flow.Flow<java.util.List<com.berners.truecaller.model.Incoming>> createObservable(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.domain.observers.ObserveIncomings.Params params) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/berners/truecaller/data/domain/observers/ObserveIncomings$Params;", "", "count", "", "(I)V", "getCount", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "data_debug"})
    public static final class Params {
        private final int count = 0;
        
        @org.jetbrains.annotations.NotNull()
        public final com.berners.truecaller.data.domain.observers.ObserveIncomings.Params copy(int count) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public Params() {
            super();
        }
        
        public Params(int count) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int getCount() {
            return 0;
        }
    }
}