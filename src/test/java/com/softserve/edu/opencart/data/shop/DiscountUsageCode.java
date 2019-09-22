package com.softserve.edu.opencart.data.shop;

public class DiscountUsageCode {
    private String couponCode;
    private String giftCertificationCode;

    public DiscountUsageCode(String couponCode, String giftCertificationCode) {
        this.couponCode = couponCode;
        this.giftCertificationCode = giftCertificationCode;
    }

    public String getGiftCertificationCode() {
        return giftCertificationCode;
    }

    public void setGiftCertificationCode(String giftCertificationCode) {
        this.giftCertificationCode = giftCertificationCode;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
}
