package az.eurodesign.notification.management.helper;

import az.eurodesign.notification.management.configuration.ApplicationConfiguration;
import az.eurodesign.notification.management.model.ActiveNotification;
import az.eurodesign.notification.management.model.enums.NotificationStatus;
import az.eurodesign.notification.management.model.enums.NotificationType;
//import az.eurodesign.notification.management.dto.UserDTO;
import az.eurodesign.notification.management.payload.NoTemplateNotificationPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class ActiveNotificationHelper {

    private final ApplicationConfiguration applicationConfiguration;

    public ActiveNotification createNotificationNoTemplate(NoTemplateNotificationPayload payload) {
        ActiveNotification notification = new ActiveNotification();

        notification.setCountOfSending(0);
        notification.setMaxCountOfSending(
                payload.isResent() ? applicationConfiguration.getMaxCountOfNotificationSending() : 1
        );
        notification.setText(payload.getText());
        notification.setStatus(NotificationStatus.READY);
        notification.setType(NotificationType.SMS);
        notification.setTarget(payload.getMobile());
        return notification;
    }


}
