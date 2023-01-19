package az.eurodesign.notification.management.service;
import az.eurodesign.notification.management.helper.ActiveNotificationHelper;
import az.eurodesign.notification.management.model.ActiveNotification;
import az.eurodesign.notification.management.payload.NoTemplateNotificationPayload;
import az.eurodesign.notification.management.repository.ActiveNotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@Transactional
@RequiredArgsConstructor
public class ActiveNotificationServiceImpl implements ActiveNotificationService {

    private final ActiveNotificationHelper helper;

    private final ActiveNotificationRepository notificationRepository;


    @Override
    public ActiveNotification create(NoTemplateNotificationPayload payload) {
        return helper.createNotificationNoTemplate(payload);
    }

    @Override
    public void save(ActiveNotification result) {
        notificationRepository.save(result);
    }


}
