package my.learn.spring.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by ’≈–°Œ∞ on 2015/11/21.
 */
public class EncodedResourceExample {
    public static void main(String[] args) throws IOException {
        Resource resource = new ClassPathResource("applicationContext.xml");
        EncodedResource encodedResource = new EncodedResource(resource,"utf-8");
        String content = FileCopyUtils.copyToString(encodedResource.getReader());

        System.out.println(content);
    }
}
