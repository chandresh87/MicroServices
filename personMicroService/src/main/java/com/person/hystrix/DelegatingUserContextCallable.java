package com.person.hystrix;


import java.util.concurrent.Callable;

import com.person.filter.UserContext;
import com.person.filter.UserContextHolder;


public final class DelegatingUserContextCallable<V> implements Callable<V> {
    private final Callable<V> delegate;
    private UserContext originalUserContext;

    public DelegatingUserContextCallable(Callable<V> delegate,
                                             UserContext userContext) {
        this.delegate = delegate;
        this.originalUserContext = userContext;
    }

    // This method will be called before method protected by the @Hystrixcommand
    public V call() throws Exception {
        UserContextHolder.setContext( originalUserContext ); //context is set in the thread that will call the Hystrix protected code.

        try {
            return delegate.call(); // call the Hystrix protected code.

        }
        finally {
            this.originalUserContext = null;
        }
    }

    public static <V> Callable<V> create(Callable<V> delegate,
                                         UserContext userContext) {
        return new DelegatingUserContextCallable<V>(delegate, userContext);
    }
}