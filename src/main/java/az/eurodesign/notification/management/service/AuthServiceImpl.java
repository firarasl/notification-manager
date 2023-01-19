package az.eurodesign.notification.management.service;

//import az.eurodesign.notification.management.configuration.ApplicationConfiguration;
import az.eurodesign.notification.management.dto.GroupDTO;
import az.eurodesign.notification.management.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.apache.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
//
//    private final ApplicationConfiguration applicationConfiguration;
//
//    private final AuthorizedRestTemplate restTemplate;
//
//
//    @Override
//    public GroupDTO getGroup(String groupId) {
//        ResponseEntity<GroupPayload> responseEntity = restTemplate.exchange(
//                applicationConfiguration.getAuth().getGroupUrl().replace("{gid}", groupId),
//                HttpMethod.GET,
//                GroupPayload.class
//        );
//
//        if (responseEntity.getStatusCode() == HttpStatus.NOT_FOUND || responseEntity.getBody() == null)
//            throw new NotFoundException("Group was not found");
//
//        return new GroupDTO(responseEntity.getBody());
//    }
}
