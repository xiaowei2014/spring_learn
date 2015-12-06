package my.learn.spring.aop.instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Created by 张小伟 on 2015/12/6.
 */
public class Transformer implements ClassFileTransformer{
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("my.learn.spring.aop.instrument.Transformer.transform()");
        return null;
    }
}
