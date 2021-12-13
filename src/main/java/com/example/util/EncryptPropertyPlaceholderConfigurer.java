package com.example.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:db.properties") // 加载db.properties配置文件
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    @Value("${db.username}")
    private String JDBC_USERNAME;

    @Value("${db.password}")
    private String JDBC_PASSWORD;

    //属性需与配置文件的KEY保持一直
    private String[] encryptPropNames = { JDBC_USERNAME, JDBC_PASSWORD};

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {

        //如果在加密属性名单中发现该属性
        if (isEncryptProp(propertyName)) {
            String decryptValue = DESUtil.getDecryptString(propertyValue);
            System.out.println(decryptValue);
            return decryptValue;
        } else {
            return propertyValue;
        }

    }

    private boolean isEncryptProp(String propertyName) {
        for (String encryptName : encryptPropNames) {
            if (encryptName.equals(propertyName)) {
                return true;
            }
        }
        return false;
    }
}
