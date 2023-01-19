package az.eurodesign.notification.management.payload;

import az.eurodesign.notification.management.model.enums.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public class ArchivedNotificationPayload {

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class GetPayload {
        @NotNull
        private String uid;

        private int page = 1;

        private int size = 5;

        @NotNull
        private NotificationType type;
    }

    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
    public static class PatchPayload {
        private boolean watched;
    }
}
