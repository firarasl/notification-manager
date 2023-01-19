//package az.eurodesign.notification.management.helper;
//
//import az.eurodesign.notification.management.model.ActiveNotification;
//import az.eurodesign.notification.management.model.Template;
//import az.eurodesign.notification.management.model.enums.NotificationStatus;
//import az.eurodesign.notification.management.model.enums.NotificationType;
//import az.eurodesign.notification.management.payload.ActiveNotificationPayload;
//import az.eurodesign.notification.management.dto.GroupDTO;
//import az.eurodesign.notification.management.dto.UserDTO;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//class ActiveNotificationHelperTest {
//
//    @Autowired
//    private ActiveNotificationHelper helper;
//
//    private UserDTO userDTO;
//
//    private ActiveNotificationPayload activeNotificationPayload;
//
//    private Template template;
//
//    private GroupDTO groupDTO;
//
//    @BeforeEach
//    public void setUp() {
//        userDTO = new UserDTO();
//        userDTO.setId("uid");
//        userDTO.setEmail("em@il.com");
//        userDTO.setMobile("mobile");
//
//        activeNotificationPayload = new ActiveNotificationPayload();
//        activeNotificationPayload.setTemplateId(17L);
//        activeNotificationPayload.setLink("notification link");
//        activeNotificationPayload.setScheduledDateTime(LocalDateTime.parse("2020-12-12T12:12:12"));
//
//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("a", "bc");
//        parameters.putIfAbsent("d", "ef");
//
//        activeNotificationPayload.setParameters(parameters);
//
//        template = new Template();
//        template.setId(17L);
//        template.setPattern("QWE {#a#} and {#d#} ASD");
//        template.setGroupId("gid");
//        template.setName("Test");
//        template.setResent(true);
//
//        groupDTO = new GroupDTO();
//
//    }
//
//    @Test
//    public void create_AllNotConfigFieldsAreSet() {
//        userDTO.setNotifiedByEmail(true);
//        userDTO.setNotifiedBySMS(true);
//        userDTO.setNotifiedByPush(true);
//
//        List<ActiveNotification> activeNotifications = helper.create(
//                userDTO, activeNotificationPayload, template, groupDTO
//        );
//
//        for (var a : activeNotifications) {
//            assertEquals("notification link", a.getLink());
//            assertEquals("QWE bc and ef ASD", a.getText());
//            assertEquals("uid", a.getUid());
//            assertEquals(17L, a.getTemplateId());
//            assertEquals(0, a.getCountOfSending());
//            assertNull(a.getWatched());
//            assertEquals(NotificationStatus.READY, a.getStatus());
//            assertEquals(LocalDateTime.parse("2020-12-12T12:12:12"), a.getScheduledDateTime());
//            assertNull(a.getSentDateTime());
//            assertNull(a.getMessageId());
//            assertNull(a.getErrorCode());
//            assertNull(a.getReport());
//        }
//    }
//
//    @Test
//    public void create_ForUserWithoutConfig() {
//        userDTO.setNotifiedByEmail(null);
//        userDTO.setNotifiedBySMS(null);
//        userDTO.setNotifiedByPush(null);
//        groupDTO.setNotifiedByEmail(true);
//        groupDTO.setNotifiedBySMS(true);
//        groupDTO.setNotifiedByPush(false);
//
//        List<ActiveNotification> activeNotifications = helper.create(
//                userDTO, activeNotificationPayload, template, groupDTO
//        );
//
//        assertEquals(2, activeNotifications.size());
//
//        Optional<ActiveNotification> email = activeNotifications.stream()
//                .filter(x -> x.getType() == NotificationType.EMAIL).findFirst();
//
//        assertTrue(email.isPresent());
//        assertEquals("em@il.com", email.get().getTarget());
//
//        Optional<ActiveNotification> sms = activeNotifications.stream()
//                .filter(x -> x.getType() == NotificationType.SMS).findFirst();
//
//        assertTrue(sms.isPresent());
//        assertEquals("mobile", sms.get().getTarget());
//    }
//
//    @Test
//    public void create_ForUserWithConfig() {
//        userDTO.setNotifiedByEmail(true);
//        userDTO.setNotifiedBySMS(true);
//        userDTO.setNotifiedByPush(true);
//
//        List<ActiveNotification> activeNotifications = helper.create(
//                userDTO, activeNotificationPayload, template, groupDTO
//        );
//
//        assertEquals(3, activeNotifications.size());
//
//        Optional<ActiveNotification> email = activeNotifications.stream()
//                .filter(x -> x.getType() == NotificationType.EMAIL).findFirst();
//
//        assertTrue(email.isPresent());
//        assertEquals("em@il.com", email.get().getTarget());
//
//        Optional<ActiveNotification> sms = activeNotifications.stream()
//                .filter(x -> x.getType() == NotificationType.SMS).findFirst();
//
//        assertTrue(sms.isPresent());
//        assertEquals("mobile", sms.get().getTarget());
//
//        Optional<ActiveNotification> push = activeNotifications.stream()
//                .filter(x -> x.getType() == NotificationType.PUSH).findFirst();
//
//        assertTrue(push.isPresent());
//        assertNull(push.get().getTarget());
//    }
//
//    @Test
//    public void create_ForUserWithoutGroup() {
//        userDTO.setNotifiedByEmail(true);
//        userDTO.setNotifiedBySMS(null);
//        userDTO.setNotifiedByPush(null);
//
//        List<ActiveNotification> activeNotifications = helper.create(
//                userDTO, activeNotificationPayload, template
//        );
//
//        assertEquals(1, activeNotifications.size());
//
//        Optional<ActiveNotification> email = activeNotifications.stream()
//                .filter(x -> x.getType() == NotificationType.EMAIL).findFirst();
//
//        assertTrue(email.isPresent());
//        assertEquals("em@il.com", email.get().getTarget());
//
//        Optional<ActiveNotification> sms = activeNotifications.stream()
//                .filter(x -> x.getType() == NotificationType.SMS).findFirst();
//
//        assertTrue(sms.isEmpty());
//
//        Optional<ActiveNotification> push = activeNotifications.stream()
//                .filter(x -> x.getType() == NotificationType.PUSH).findFirst();
//
//        assertTrue(push.isEmpty());
//    }
//}