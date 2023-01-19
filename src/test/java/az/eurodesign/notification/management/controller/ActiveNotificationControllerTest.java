package az.eurodesign.notification.management.controller;

import az.eurodesign.notification.management.model.ActiveNotification;
import az.eurodesign.notification.management.model.enums.NotificationType;
import az.eurodesign.notification.management.dto.GroupDTO;
import az.eurodesign.notification.management.repository.ActiveNotificationRepository;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.junit.jupiter.MockServerExtension;
import org.mockserver.junit.jupiter.MockServerSettings;
import org.mockserver.model.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.StringBody.exact;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith(MockServerExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
//@AutoConfigureMockMvc
//@Sql(scripts = {"classpath:sql/create-templates-before.sql", "classpath:sql/drop-active-notifications.sql"},
//        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(scripts = {"classpath:sql/create-templates-after.sql", "classpath:sql/drop-active-notifications.sql"},
//        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//@MockServerSettings(ports = {10000})
class ActiveNotificationControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ActiveNotificationRepository activeNotificationRepository;
//
//    private final ClientAndServer client;
//
//    public ActiveNotificationControllerTest(ClientAndServer client) {
//        this.client = client;
//    }
//
//    @BeforeEach
//    void setUp() {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId("one");
//        userDTO.setMobile("mobile one");
//        userDTO.setEmail("email one");
//        userDTO.setNotifiedBySMS(true);
//        userDTO.setNotifiedByEmail(null);
//        userDTO.setNotifiedByPush(false);
//
//        UserDTO userDTO2 = new UserDTO();
//        userDTO2.setId("two");
//        userDTO2.setMobile("mobile two");
//        userDTO2.setEmail("email two");
//        userDTO2.setNotifiedBySMS(false);
//        userDTO2.setNotifiedByEmail(true);
//        userDTO2.setNotifiedByPush(null);
//
//        GroupDTO groupDTO = new GroupDTO();
//        groupDTO.setId("one");
//        groupDTO.setNotifiedByEmail(true);
//        groupDTO.setNotifiedBySMS(false);
//        groupDTO.setNotifiedByPush(true);
//        groupDTO.setUsers(List.of(userDTO, userDTO2));
//
//        client.when(
//                request()
//                        .withMethod("GET").withPath("/user/one")
//        ).respond(
//                response()
//                        .withBody(exact(new Gson().toJson(userDTO)))
//                        .withStatusCode(200)
//                        .withHeader(new Header("Content-Type", "application/json; charset=utf-8"))
//        );
//
//
//        client.when(
//                request()
//                        .withMethod("GET").withPath("/group/one")
//        ).respond(
//                response()
//                        .withBody(exact(new Gson().toJson(groupDTO)))
//                        .withStatusCode(200)
//                        .withHeader(new Header("Content-Type", "application/json; charset=utf-8"))
//        );
//    }
//
//    @Test
//    void create_WhenTemplateNotFound() throws Exception {
//        ActiveNotificationPayload activeNotificationPayload = new ActiveNotificationPayload();
//        activeNotificationPayload.setUid("seven");
//        activeNotificationPayload.setLink("link seven");
//        activeNotificationPayload.setTemplateId(34L);
//        activeNotificationPayload.setParameters(new HashMap<>());
//
//        String body = new Gson().toJson(activeNotificationPayload);
//
//        mockMvc.perform(
//                post("/active-notification")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    void create_WhenUserNotFound() throws Exception {
//        ActiveNotificationPayload activeNotificationPayload = new ActiveNotificationPayload();
//        activeNotificationPayload.setUid("seven");
//        activeNotificationPayload.setLink("link seven");
//        activeNotificationPayload.setTemplateId(1L);
//        activeNotificationPayload.setParameters(new HashMap<>());
//
//        String body = new Gson().toJson(activeNotificationPayload);
//
//        mockMvc.perform(
//                post("/active-notification")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    void create_WhenFoundForUser() throws Exception {
//        ActiveNotificationPayload activeNotificationPayload = new ActiveNotificationPayload();
//        activeNotificationPayload.setUid("one");
//        activeNotificationPayload.setLink("link seven");
//        activeNotificationPayload.setTemplateId(1L);
//        activeNotificationPayload.setParameters(new HashMap<>());
//
//        String body = new Gson().toJson(activeNotificationPayload);
//
//        mockMvc.perform(
//                post("/active-notification")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andDo(print())
//                .andExpect(status().isOk());
//
//        List<ActiveNotification> notifications = activeNotificationRepository.findAll();
//
//        assertEquals(1, notifications.size());
//
//        Optional<ActiveNotification> optionalSms = notifications.stream()
//                .filter(x -> x.getUid().equals("one") && x.getType() == NotificationType.SMS).findFirst();
//
//        assertTrue(optionalSms.isPresent());
//
//    }
//
//    @Test
//    void create_WhenFoundForGroup() throws Exception {
//        ActiveNotificationPayload activeNotificationPayload = new ActiveNotificationPayload();
//        activeNotificationPayload.setLink("link seven");
//        activeNotificationPayload.setTemplateId(1L);
//        activeNotificationPayload.setParameters(new HashMap<>());
//
//        String body = new Gson().toJson(activeNotificationPayload);
//
//        mockMvc.perform(
//                post("/active-notification")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andDo(print())
//                .andExpect(status().isOk());
//
//        List<ActiveNotification> notifications = activeNotificationRepository.findAll();
//
//        assertEquals(4, notifications.size());
//
//        Optional<ActiveNotification> optionalSms = notifications.stream()
//                .filter(x -> x.getUid().equals("one") && x.getType() == NotificationType.SMS).findFirst();
//
//        Optional<ActiveNotification> optionalEmail = notifications.stream()
//                .filter(x -> x.getUid().equals("one") && x.getType() == NotificationType.EMAIL).findFirst();
//
//        Optional<ActiveNotification> optionalPush = notifications.stream()
//                .filter(x -> x.getUid().equals("two") && x.getType() == NotificationType.PUSH).findFirst();
//
//        Optional<ActiveNotification> optionalEmail2 = notifications.stream()
//                .filter(x -> x.getUid().equals("two") && x.getType() == NotificationType.EMAIL).findFirst();
//
//
//        assertTrue(optionalSms.isPresent());
//        assertTrue(optionalEmail.isPresent());
//        assertTrue(optionalEmail2.isPresent());
//        assertTrue(optionalPush.isPresent());
//    }
}