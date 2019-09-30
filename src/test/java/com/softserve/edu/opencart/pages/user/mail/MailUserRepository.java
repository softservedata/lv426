package com.softserve.edu.opencart.pages.user.mail;

public class MailUserRepository {

    private MailUserRepository() {
    }

    public static MailUser getDefault() {
        return getMailUser();

    }
    private static MailUser getMailUser() {
        return MailUser.builder()
                .loginName(System.getenv().get("EMAIL_LOGIN"))
                .password(System.getenv().get("EMAIL_PASSWORD"))
                .build();
    }
}
