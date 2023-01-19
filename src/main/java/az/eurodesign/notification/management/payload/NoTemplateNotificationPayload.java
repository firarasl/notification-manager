package az.eurodesign.notification.management.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class NoTemplateNotificationPayload {

    private String text;

    private String mobile;

    private boolean resent = true;


}
