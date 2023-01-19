//package az.eurodesign.notification.management.controller;
//
//import az.eurodesign.notification.management.model.ArchivedNotification;
//import az.eurodesign.notification.management.model.enums.NotificationType;
//import az.eurodesign.notification.management.payload.ArchivedNotificationPayload;
//import az.eurodesign.notification.management.repository.ArchivedNotificationRepository;
//import com.google.gson.Gson;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Optional;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@Sql(scripts = {"classpath:sql/create-archived-notifications-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(scripts = {"classpath:sql/create-archived-notifications-after.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//class ArchivedNotificationControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ArchivedNotificationRepository archivedNotificationRepository;
//
//    @Test
//    void get_PageZero() throws Exception {
//        ArchivedNotificationPayload.GetPayload getPayload = new ArchivedNotificationPayload.GetPayload();
//        getPayload.setUid("one");
//        getPayload.setType(NotificationType.PUSH);
//        getPayload.setPage(1);
//        getPayload.setSize(3);
//
//        mockMvc.perform(
//                get("/archived-notification")
//                        .queryParam("uid", "one")
//                        .queryParam("type", "PUSH")
//                        .queryParam("page", "1").queryParam("size", "3"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("\"id\":11")))
//                .andExpect(content().string(containsString("\"id\":9")))
//                .andExpect(content().string(containsString("\"id\":7")));
//    }
//
//    @Test
//    void get_PageFive() throws Exception {
//        ArchivedNotificationPayload.GetPayload getPayload = new ArchivedNotificationPayload.GetPayload();
//        getPayload.setUid("one");
//        getPayload.setType(NotificationType.PUSH);
//        getPayload.setPage(1);
//        getPayload.setSize(3);
//
//        mockMvc.perform(
//                get("/archived-notification")
//                        .queryParam("uid", "one")
//                        .queryParam("type", "PUSH")
//                        .queryParam("page", "5")
//                        .queryParam("size", "3"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("[]")));
//    }
//
//    @Test
//    void update_WhenNotFound() throws Exception {
//        ArchivedNotificationPayload.PatchPayload patchPayload = new ArchivedNotificationPayload.PatchPayload();
//        patchPayload.setWatched(true);
//
//        mockMvc.perform(
//                patch("/archived-notification/34/watched")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new Gson().toJson(patchPayload)))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//
//    }
//
//    @Test
//    void update_WhenFound() throws Exception {
//        ArchivedNotificationPayload.PatchPayload patchPayload = new ArchivedNotificationPayload.PatchPayload();
//        patchPayload.setWatched(true);
//        Gson gson = new Gson();
//        String body = gson.toJson(patchPayload);
//
//        mockMvc.perform(
//                patch("/archived-notification/1/watched")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andDo(print())
//                .andExpect(status().isOk());
//
//        Optional<ArchivedNotification> optional = archivedNotificationRepository.findById(1L);
//        assertTrue(optional.isPresent());
//        assertTrue(optional.get().getWatched());
//    }
//
//}