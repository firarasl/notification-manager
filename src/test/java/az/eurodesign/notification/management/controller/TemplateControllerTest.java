//package az.eurodesign.notification.management.controller;
//
//import az.eurodesign.notification.management.payload.TemplatePayload;
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
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@Sql(scripts = {"classpath:sql/create-templates-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(scripts = {"classpath:sql/create-templates-after.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//class TemplateControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void get_All() throws Exception {
//        mockMvc.perform(get("/template"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("\"id\":1")))
//                .andExpect(content().string(containsString("\"id\":2")));
//    }
//
//    @Test
//    void get_One() throws Exception {
//        mockMvc.perform(get("/template/1"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("\"id\":1")));
//    }
//
//    @Test
//    void get_NotFound() throws Exception {
//        mockMvc.perform(get("/template/3"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//
//    @Test
//    void update_WhenFound() throws Exception {
//        TemplatePayload templatePayload = new TemplatePayload();
//        templatePayload.setPattern("strange pattern");
//
//        mockMvc.perform(
//                patch("/template/1/pattern")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new Gson().toJson(templatePayload)))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("strange pattern")));
//
//    }
//
//
//    @Test
//    void update_WhenNotFound() throws Exception {
//        TemplatePayload templatePayload = new TemplatePayload();
//        templatePayload.setPattern("strange pattern");
//
//        mockMvc.perform(
//                patch("/template/34/pattern")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new Gson().toJson(templatePayload)))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//
//    }
//}