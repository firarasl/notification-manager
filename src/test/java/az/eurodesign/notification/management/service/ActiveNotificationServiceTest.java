//package az.eurodesign.notification.management.service;
//
//import az.eurodesign.notification.management.exception.NotFoundException;
//import az.eurodesign.notification.management.model.ActiveNotification;
//import az.eurodesign.notification.management.model.Template;
//import az.eurodesign.notification.management.payload.ActiveNotificationPayload;
//import az.eurodesign.notification.management.dto.GroupDTO;
//import az.eurodesign.notification.management.dto.UserDTO;
//import az.eurodesign.notification.management.repository.ActiveNotificationRepository;
//import az.eurodesign.notification.management.repository.TemplateRepository;
//import az.eurodesign.notification.management.helper.ActiveNotificationHelper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.ArgumentMatchers.anyLong;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//class ActiveNotificationServiceTest {
//
//    @Autowired
//    private ActiveNotificationService activeNotificationService;
//
//    @MockBean
//    private ActiveNotificationRepository notificationRepository;
//
//    @MockBean
//    private TemplateRepository templateRepository;
//
//    @MockBean
//    private AuthService authService;
//
//    @MockBean
//    private ActiveNotificationHelper helper;
//
//    private ActiveNotificationPayload payload;
//
//    private UserDTO userDTO;
//
//    private Template template;
//
//    private GroupDTO groupDTO;
//
//    @BeforeEach
//    void setUp() {
//        payload = new ActiveNotificationPayload();
//        payload.setTemplateId(17L);
//
//        userDTO = new UserDTO();
//        userDTO.setId("one");
//
//        UserDTO userDTO2 = new UserDTO();
//
//        template = new Template();
//        template.setGroupId("gid");
//
//        groupDTO = new GroupDTO();
//        groupDTO.setId("gid");
//        groupDTO.setUsers(List.of(userDTO, userDTO2));
//    }
//
//    @Test
//    void create_WhenTemplateNotFound() {
//        Mockito.doReturn(Optional.empty()).when(templateRepository).findById(17L);
//        assertThrows(NotFoundException.class, () -> activeNotificationService.create(payload));
//    }
//
//    @Test
//    void create_WhenUidNotNull() {
//        payload.setUid("one");
//        Mockito.doReturn(Optional.of(template)).when(templateRepository).findById(anyLong());
//        Mockito.doReturn(userDTO).when(authService).getUser("one");
//        Mockito.doReturn(null).when(helper).create(
//                any(UserDTO.class), any(ActiveNotificationPayload.class), any(Template.class)
//        );
//        activeNotificationService.create(payload);
//        Mockito.verify(helper, Mockito.times(1)).create(
//                any(UserDTO.class), any(ActiveNotificationPayload.class), any(Template.class)
//        );
//    }
//
//    @Test
//    void create_WhenUidNull() {
//        Mockito.doReturn(Optional.of(template)).when(templateRepository).findById(anyLong());
//        Mockito.doReturn(groupDTO).when(authService).getGroup("gid");
//        Mockito.doReturn(new ArrayList<>()).when(helper).create(
//                any(UserDTO.class), any(ActiveNotificationPayload.class),
//                any(Template.class), any(GroupDTO.class)
//        );
//
//        activeNotificationService.create(payload);
//
//        Mockito.verify(helper, Mockito.times(2)).create(
//                any(UserDTO.class), any(ActiveNotificationPayload.class),
//                any(Template.class), any(GroupDTO.class)
//        );
//    }
//
//    @Test
//    void save() {
//        List<ActiveNotification> list = new ArrayList<>();
//        Mockito.doReturn(list).when(notificationRepository).saveAll(list);
//        activeNotificationService.save(list);
//        Mockito.verify(notificationRepository, Mockito.times(1)).saveAll(list);
//    }
//}