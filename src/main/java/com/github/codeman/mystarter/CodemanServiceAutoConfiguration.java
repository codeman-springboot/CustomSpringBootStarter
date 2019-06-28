package com.github.codeman.mystarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CodemanProperties.class)
@ConditionalOnClass(CodemanService.class)
public class CodemanServiceAutoConfiguration {
    @Autowired
    CodemanProperties codemanProperties;

    @Bean
    CodemanService codemanService() {
        CodemanService codemanService = new CodemanService();
        codemanService.setMsg(codemanProperties.getMsg());
        codemanService.setName(codemanProperties.getName());
        return codemanService;
    }
}
