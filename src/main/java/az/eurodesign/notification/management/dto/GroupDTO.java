package az.eurodesign.notification.management.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class GroupDTO {
//
//    public GroupDTO(GroupPayload payload) {
//    }

    private String id;

    private boolean notifiedBySMS;

    private boolean notifiedByEmail;

    private boolean notifiedByPush;

//    List<UserDTO> users;
}
