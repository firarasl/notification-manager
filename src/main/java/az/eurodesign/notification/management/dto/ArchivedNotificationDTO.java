package az.eurodesign.notification.management.dto;

import az.eurodesign.notification.management.model.ArchivedNotification;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArchivedNotificationDTO {

    private long id;

    private String text;

    private String link;

    private boolean watched;

    public ArchivedNotificationDTO(ArchivedNotification archivedNotification) {
        id = archivedNotification.getId();
        text = archivedNotification.getText();
        link = archivedNotification.getLink();
        watched = archivedNotification.getWatched() == null ? false : archivedNotification.getWatched();
    }
}
