
package org.vibhashana.jakarta.interceptors;

import java.util.logging.Logger;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Logging
public class LoggingInterceptor {
    @AroundInvoke
    public Object doLogging(InvocationContext ctx) throws Exception {
        Logger.getLogger(ctx.getClass().getName()).info(ctx.getMethod().getName());
        ctx.proceed();
        return null;
    }
}