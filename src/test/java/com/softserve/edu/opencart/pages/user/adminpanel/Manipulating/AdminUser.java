package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AdminUser {
    private String loginName;
    private String password;
}
