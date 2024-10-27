package Lab1_CDI.Interceptor;

import lombok.NoArgsConstructor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@NoArgsConstructor
public class ProfileInterceptor {

    @AroundInvoke
    public Object profile(InvocationContext ic) throws Exception {
        long initTime = System.nanoTime();
        Object result;

        try {
            result = ic.proceed();
        } finally {
            long diffTime = System.nanoTime() - initTime;
            System.out.println(ic.getMethod() + " took " + diffTime + " ns");
        }

        return result;
    }
}
