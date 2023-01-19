package az.eurodesign.notification.management.configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "application")
@Getter @Setter @NoArgsConstructor
public class ApplicationConfiguration {

    private int maxCountOfNotificationSending;

    private Auth auth;

    @Getter @Setter @NoArgsConstructor
    public static class Auth {


    }
}
