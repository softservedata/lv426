package com.softserve.edu.opencart.data.shop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
public class DiscountUsageCode {
    private String couponCode;
    private String giftCertificationCode;

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
