package az.eurodesign.notification.management.service;

import az.eurodesign.notification.management.dto.Token;

public interface TokenStorage {
    Token get();
    void update();
}