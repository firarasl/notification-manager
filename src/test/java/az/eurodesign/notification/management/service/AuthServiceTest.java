package az.eurodesign.notification.management.service;

import az.eurodesign.notification.management.exception.NotFoundException;
import az.eurodesign.notification.management.exception.UnauthorizedException;
import az.eurodesign.notification.management.dto.GroupDTO;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.junit.jupiter.MockServerExtension;
import org.mockserver.junit.jupiter.MockServerSettings;
import org.mockserver.model.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.StringBody.exact;

//@ExtendWith(MockServerExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
//@MockServerSettings(ports = {10000})
class AuthServiceTest {
//
//    private ClientAndServer client;
//
//    @Autowired
//    private AuthService authService;
//
//    public AuthServiceTest(ClientAndServer client) {
//        this.client = client;
//    }
//
//    private UserDTO userDTO;
//
//    private GroupDTO groupDTO;
//
//    @BeforeEach
//    void setUp() {
//        userDTO = new UserDTO();
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
//        groupDTO = new GroupDTO();
//        groupDTO.setId("seven");
//        groupDTO.setNotifiedByEmail(true);
//        groupDTO.setNotifiedBySMS(false);
//        groupDTO.setNotifiedByPush(true);
//        groupDTO.setUsers(List.of(userDTO, userDTO2));
//
//        client.when(
//                request()
//                    .withMethod("GET").withPath("/user/one")
//        ).respond(
//                response()
//                    .withBody(exact(new Gson().toJson(userDTO)))
//                    .withStatusCode(200)
//                    .withHeader(new Header("Content-Type", "application/json; charset=utf-8"))
//        );
//
//        client.when(
//                request()
//                        .withMethod("GET").withPath("/user/three")
//        ).respond(
//                response()
//                        .withStatusCode(404)
//                        .withHeader(new Header("Content-Type", "application/json; charset=utf-8"))
//        );
//
//        client.when(
//                request()
//                        .withMethod("GET").withPath("/user/four")
//        ).respond(
//                response()
//                        .withStatusCode(401)
//                        .withHeader(new Header("Content-Type", "application/json; charset=utf-8"))
//        );
//
//        client.when(
//                request()
//                        .withMethod("GET").withPath("/group/seven")
//        ).respond(
//                response()
//                        .withBody(exact(new Gson().toJson(groupDTO)))
//                        .withStatusCode(200)
//                        .withHeader(new Header("Content-Type", "application/json; charset=utf-8"))
//        );
//
//        client.when(
//                request()
//                        .withMethod("GET").withPath("/group/one")
//        ).respond(
//                response()
//                        .withStatusCode(404)
//                        .withHeader(new Header("Content-Type", "application/json; charset=utf-8"))
//        );
//
//        client.when(
//                request()
//                        .withMethod("GET").withPath("/group/two")
//        ).respond(
//                response()
//                        .withStatusCode(401)
//                        .withHeader(new Header("Content-Type", "application/json; charset=utf-8"))
//        );
//
//
//    }
//
//    @Test
//    void getUser_Exists() {
//        UserDTO payload = authService.getUser("one");
//        assertEquals(userDTO.getId(), payload.getId());
//        assertEquals(userDTO.getMobile(), payload.getMobile());
//        assertEquals(userDTO.getEmail(), payload.getEmail());
//        assertEquals(userDTO.getNotifiedBySMS(), payload.getNotifiedBySMS());
//        assertEquals(userDTO.getNotifiedByEmail(), payload.getNotifiedByEmail());
//        assertEquals(userDTO.getNotifiedByPush(), payload.getNotifiedByPush());
//    }
//
//    @Test
//    void getUser_NotFound() {
//        assertThrows(NotFoundException.class, () -> authService.getUser("three"));
//    }
//
//    @Test
//    void getUser_Unauthorized() {
//        assertThrows(UnauthorizedException.class, () -> authService.getUser("four"));
//    }
//
//    @Test
//    void getGroup() {
//        GroupDTO payload = authService.getGroup("seven");
//        assertEquals(groupDTO.getId(), payload.getId());
//        assertEquals(groupDTO.isNotifiedBySMS(), payload.isNotifiedBySMS());
//        assertEquals(groupDTO.isNotifiedByEmail(), payload.isNotifiedByEmail());
//        assertEquals(groupDTO.isNotifiedByPush(), payload.isNotifiedByPush());
//
//        Optional<UserDTO> up1 = payload.getUsers().stream().filter(x -> x.getId().equals("one")).findFirst();
//        Optional<UserDTO> up2 = payload.getUsers().stream().filter(x -> x.getId().equals("two")).findFirst();
//
//        assertTrue(up1.isPresent());
//        assertTrue(up2.isPresent());
//    }
//
//    @Test
//    void getGroup_NotFound() {
//        assertThrows(NotFoundException.class, () -> authService.getGroup("one"));
//    }
//
//    @Test
//    void getGroup_Unauthorized() {
//        assertThrows(UnauthorizedException.class, () -> authService.getGroup("two"));
//    }

}