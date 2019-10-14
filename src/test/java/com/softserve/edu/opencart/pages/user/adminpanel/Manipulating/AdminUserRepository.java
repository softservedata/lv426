package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

public class AdminUserRepository {
    private AdminUserRepository() {
    }

    public static AdminUser getDefault() {
        return getAdminUser();

    }
    private static AdminUser getAdminUser() {
        return AdminUser.builder()
                .loginName("admin")
                .password("Lv426_Taqc")
                .build();
    }
}
