package az.eurodesign.notification.management.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class TokenPayload {

    private String accessToken;

    private String refreshToken;
}
