//package az.eurodesign.notification.management.service;
//
//import az.eurodesign.notification.management.exception.NotFoundException;
//import az.eurodesign.notification.management.model.ArchivedNotification;
//import az.eurodesign.notification.management.model.enums.NotificationType;
//import az.eurodesign.notification.management.payload.ArchivedNotificationPayload;
//import az.eurodesign.notification.management.repository.ArchivedNotificationRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.Pageable;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.*;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//class ArchivedNotificationServiceTest {
//
//    @Autowired
//    private ArchivedNotificationService archivedNotificationService;
//
//    @MockBean
//    private ArchivedNotificationRepository archivedNotificationRepository;
//
//    private ArchivedNotification archivedNotification;
//
//    private ArchivedNotificationPayload.GetPayload getPayload;
//
//
//    @BeforeEach
//    void setUp() {
//        archivedNotification = new ArchivedNotification();
//        archivedNotification.setId(1L);
//        archivedNotification.setWatched(null);
//
//        getPayload = new ArchivedNotificationPayload.GetPayload();
//        getPayload.setPage(3);
//        getPayload.setSize(4);
//        getPayload.setType(NotificationType.PUSH);
//        getPayload.setUid("one");
//    }
//
//    @Test
//    void get() {
//        Mockito.doReturn(new ArrayList<>()).when(archivedNotificationRepository)
//                .findAllByUidAndType(anyString(), any(NotificationType.class), any(Pageable.class));
//        archivedNotificationService.get(getPayload);
//        Mockito.verify(archivedNotificationRepository, Mockito.times(1))
//                .findAllByUidAndType(eq("one"), eq(NotificationType.PUSH), any(Pageable.class));
//    }
//
//    @Test
//    void create_WhenNotFound() {
//        ArchivedNotificationPayload.PatchPayload patchPayload = new ArchivedNotificationPayload.PatchPayload();
//        Mockito.doReturn(Optional.empty()).when(archivedNotificationRepository).findById(1L);
//        assertThrows(NotFoundException.class, () -> archivedNotificationService.create(1L, patchPayload));
//    }
//
//    @Test
//    void create_WhenFound() {
//        ArchivedNotificationPayload.PatchPayload patchPayload = new ArchivedNotificationPayload.PatchPayload();
//        patchPayload.setWatched(true);
//
//        Mockito.doReturn(Optional.of(archivedNotification)).when(archivedNotificationRepository).findById(1L);
//        ArchivedNotification archivedNotification = archivedNotificationService.create(1L, patchPayload);
//        assertTrue(archivedNotification.getWatched());
//    }
//
//    @Test
//    void save() {
//        Mockito.doReturn(archivedNotification).when(archivedNotificationRepository).save(archivedNotification);
//        archivedNotificationService.save(archivedNotification);
//        Mockito.verify(archivedNotificationRepository, Mockito.times(1)).save(archivedNotification);
//    }
//}