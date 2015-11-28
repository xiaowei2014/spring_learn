package my.learn.spring.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * Created by ’≈–°Œ∞ on 2015/11/21.
 */
public class PatternResolverExample {
    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:my/learn/**/*.class");
        for (Resource resource : resources){
            System.out.println(resource.getURL());
        }
    }
}
