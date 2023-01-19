package az.eurodesign.notification.management.service;

import az.eurodesign.notification.management.model.ActiveNotification;
import az.eurodesign.notification.management.payload.NoTemplateNotificationPayload;

public interface ActiveNotificationService {

    void save(ActiveNotification payload);

    ActiveNotification create(NoTemplateNotificationPayload payload);

}
