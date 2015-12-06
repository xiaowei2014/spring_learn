package my.learn.spring.aop.instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * Created by 张小伟 on 2015/12/6.
 */
public class Agent {
    public static void premain(String agentArgs,Instrumentation inst){
        ClassFileTransformer transformer = new Transformer();
        inst.addTransformer(transformer);

    }
}
