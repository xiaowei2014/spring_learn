package my.learn.spring.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

/**
 * Created by ’≈–°Œ∞ on 2015/11/21.
 */
public class ClassPathResourceExample {
    public static void main(String[] args) throws IOException {
        Resource resource = new ClassPathResource("applicationContext.xml");
       File file = resource.getFile();
        System.out.println(file.exists());
    }
}
