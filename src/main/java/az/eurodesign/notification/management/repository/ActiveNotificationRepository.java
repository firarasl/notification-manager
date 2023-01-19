package az.eurodesign.notification.management.repository;

import az.eurodesign.notification.management.model.ActiveNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveNotificationRepository extends JpaRepository<ActiveNotification, Long> {
}