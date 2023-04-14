package cn.qlfbbs.its.assembly.config;

import cn.qlfbbs.its.assembly.properties.AppletProperties;
import cn.qlfbbs.its.assembly.service.AppletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huguangjun
 */
@Configuration
@ConditionalOnWebApplication // web应用情况下才生效
@EnableConfigurationProperties(AppletProperties.class)
public class AppletConfiguration {

    @Autowired
    private AppletProperties appletProperties;

    @Bean
    public AppletService appletService(){
        AppletService appletService = new AppletService();
        appletService.setAppletProperties(appletProperties);
        return appletService;
    }
}
