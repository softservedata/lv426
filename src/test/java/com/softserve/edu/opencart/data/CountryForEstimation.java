package com.softserve.edu.opencart.data;

public class CountryForEstimation {
        private String countryName;
        private String regionName;
        private String postCode;


        CountryForEstimation(String countryName, String regionName, String postCode) {
            this.countryName = countryName;
            this.regionName = regionName;
            this.postCode = postCode;
        }

        public String getCountryName() {
            return countryName;
        }

        public String getRegionName() {
            return regionName;
        }

        public String getPostCode() {
            return postCode;
        }
    }

