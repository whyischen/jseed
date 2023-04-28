package wang.chenguang.learn.question.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloProxy {

    public static void main(String[] args) {

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);

                switch (method.getName()) {
                    case "hello":
                        System.out.println("Hello, " + args[0]);
                        break;
                    case "morning":
                        System.out.println("Good morning, " + args[0]);
                        break;
                }
                return null;
            }
        };

        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                handler
        );

        hello.hello("Bob ~");
        hello.morning("Bob ~");
    }

}
