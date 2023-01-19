package az.eurodesign.notification.management.service;

import az.eurodesign.notification.management.dto.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class TokenStorageImpl implements TokenStorage {

    private final TokenProvider tokenProvider;

    private Token token;

    @Override
    public Token get() {
        return token;
    }

    @Override
    public void update() {
        token = tokenProvider.get();
    }

//    @PostConstruct
//    public void init() {
//        token = tokenProvider.get();
//    }
}
