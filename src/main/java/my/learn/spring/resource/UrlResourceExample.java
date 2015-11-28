package my.learn.spring.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

/**
 * Created by ’≈–°Œ∞ on 2015/11/21.
 */
public class UrlResourceExample {
    public static void main(String[] args) throws IOException {
        Resource resource = new UrlResource("http://www.baidu.com");
         InputStream inputStream =  resource.getInputStream();
        StreamUtils.copy(inputStream,System.out);

    }
}
