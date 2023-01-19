package az.eurodesign.notification.management.service;

import az.eurodesign.notification.management.configuration.ApplicationConfiguration;
import az.eurodesign.notification.management.dto.Token;
import az.eurodesign.notification.management.exception.RemoteServerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.util.JsonSerialization;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenProviderImpl implements TokenProvider {
    @Override
    public Token get() {
        return null;
    }

//    private final ApplicationConfiguration applicationConfiguration;
//
//    @Override
//    public Token get() {
//        CloseableHttpClient client = HttpClientBuilder.create().build();
//
//        HttpPost httpPost = new HttpPost(applicationConfiguration.getAuth().getTokenUrl());
//
//        List<NameValuePair> formParams = List.of(
//                new BasicNameValuePair("grant_type", applicationConfiguration.getAuth().getGrantType()),
//                new BasicNameValuePair("client_id", applicationConfiguration.getAuth().getAdminClientId()),
//                new BasicNameValuePair("username", applicationConfiguration.getAuth().getUsername()),
//                new BasicNameValuePair("password", applicationConfiguration.getAuth().getPassword())
//        );
//
//        UrlEncodedFormEntity form = new UrlEncodedFormEntity(formParams, StandardCharsets.UTF_8);
//        httpPost.setEntity(form);
//
//        try (CloseableHttpResponse response = client.execute(httpPost)) {
//
//            InputStream is = response.getEntity().getContent();
//
//            AccessTokenResponse accessTokenResponse = JsonSerialization.readValue(is, AccessTokenResponse.class);
//
//            return new Token(accessTokenResponse.getToken(),accessTokenResponse.getRefreshToken());
//        } catch (IOException e) {
//            log.error("Token was not read from auth service properly");
//            throw new RemoteServerException("Application cannot be authorized");
//        }
//    }
}
