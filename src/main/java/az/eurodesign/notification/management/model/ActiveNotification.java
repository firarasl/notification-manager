package az.eurodesign.notification.management.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "active_notifications")
@Getter @Setter @NoArgsConstructor
public class ActiveNotification extends Notification {
}
