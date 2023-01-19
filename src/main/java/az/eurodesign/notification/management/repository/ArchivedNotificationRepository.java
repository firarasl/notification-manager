package az.eurodesign.notification.management.repository;

import az.eurodesign.notification.management.model.ArchivedNotification;
import az.eurodesign.notification.management.model.enums.NotificationType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchivedNotificationRepository extends PagingAndSortingRepository<ArchivedNotification, Long> {
   // List<ArchivedNotification> findAllByUidAndType(String uid, NotificationType type, Pageable pageable);
}