package com.softserve.edu.opencart.data.shop;

import org.apache.commons.lang3.RandomStringUtils;

public class ShopRepository {
    private static CountryForEstimation countryForEstimation;
    private static DiscountUsageCode discountUsageCode;
    private static FinalPriceTableComponent finalPriceTableComponent;

    public static CountryForEstimation builderCountryForEstimation() {

        return countryForEstimation.builder()
                .countryName("Australia")
                .regionName("Victoria")
                .postCode("426")
                .build();
    }

    public static DiscountUsageCode builderCodesForBoth() {
        return discountUsageCode.builder()
                .couponCode(RandomStringUtils.randomAlphabetic(8))
                .giftCertificationCode(RandomStringUtils.randomAlphabetic(8))
                .build();
    }

//    public static FinalPriceTableComponent builderFinalPriceTableForIPhones(){
//        return finalPriceTableComponent.builder()
//                .
//    }
}
