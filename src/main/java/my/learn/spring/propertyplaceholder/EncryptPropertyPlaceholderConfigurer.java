package my.learn.spring.propertyplaceholder;

import my.learn.spring.utils.DESUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * Created by 张小伟 on 2015/11/28.
 * 使用加密的属性文件
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer{
    private String[] encryptPropNames = {"userName","password"};

    @Override
    protected String convertProperty(String propertyName,String propertyValue){
        if (isEncryptProp(propertyName)){
            String decryptValue = DESUtils.getDecryptString(propertyValue);
            return decryptValue;
        }else {
            return propertyValue;
        }
    }

    private boolean isEncryptProp(String propertyName) {
        for (String encryptPropName : encryptPropNames){
            if (encryptPropName.equals(propertyName)){
                return true;
            }
        }
        return false;
    }
}
