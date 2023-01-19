package az.eurodesign.notification.management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Token {

    private String accessValue;

    private String refreshValue;
}
