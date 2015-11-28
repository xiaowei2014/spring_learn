package my.learn.spring.resource;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by ’≈–°Œ∞ on 2015/11/21.
 */
public class FileSystemResourceExample {
    public static void main(String[] args) throws IOException {
//        Resource resource = new FileSystemResource("E:\\github\\spring_learn\\src\\main\\java\\my\\learn\\spring\\resource\\FileSystemResourceExample.java");
        Resource resource = new FileSystemResource("src\\main\\java\\my\\learn\\spring\\resource\\FileSystemResourceExample.java");
       File file = resource.getFile();
        System.out.println(file.exists());
    }

}
