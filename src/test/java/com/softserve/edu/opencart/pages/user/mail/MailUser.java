package com.softserve.edu.opencart.pages.user.mail;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MailUser {
    private String loginName;
    private String password;
}
