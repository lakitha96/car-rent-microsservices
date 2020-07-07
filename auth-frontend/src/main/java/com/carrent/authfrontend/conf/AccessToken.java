package com.carrent.authfrontend.conf;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

/**
 * @author Lakitha Prabudh on 7/7/20
 */
public class AccessToken {
    public static String getAccessToken(){
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        return details.getTokenType().concat(" ").concat(details.getTokenValue());
    }
}
