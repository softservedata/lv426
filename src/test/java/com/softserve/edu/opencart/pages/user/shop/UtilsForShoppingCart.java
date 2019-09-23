package com.softserve.edu.opencart.pages.user.shop;

public class UtilsForShoppingCart {
    enum Cameras {
        CANON("Canon EOS 5D"),
        NIKON("Nikon D300");

        private String camera;

        Cameras(String camera) {
            this.camera = camera;
        }

        public String getCamera() {
            return camera;
        }
    }

    enum Desktops {
        IMAC("iMac");
        private String desktop;

        Desktops(String desktop) {
            this.desktop = desktop;
        }
        public String getDesktop(){
            return desktop;
        }
        }

        enum LaptopsNotebooks{
            MBAIR("MacBook Air"),
            MBPRO("MacBook Pro"),
            MACBOOK("MacBook"),
            HP("HP LP3065"),
            VAIO("Sony VAIO");

            private String laptop;

            LaptopsNotebooks(String laptop){
                this.laptop = laptop;
            }

            public String getLaptop(){
                return laptop;
            }
        }

    enum Components{
        MICE("Mice and Trackballs"),
        MONITORS("Monitors"),
        PRINTERS("Printers"),
        SCANNERS("Scanners"),
        WEBCAMERAS("Web Cameras");

        private String components;

        Components(String laptop){
            this.components = components;
        }

        public String getComponents(){
            return components;
        }
    }

    enum Tablets{
        SAMSUNG("Samsung Galaxy Tab 10.1");

        private String tablet;

        Tablets(String tablet){
            this.tablet = tablet;
        }

        public String getTablet(){
            return tablet;
        }
    }

    enum Software{
        EMPTYLISTMESS("There are no products to list in this category.");

        private String message;

        Software(String message){
            this.message = message;
        }

        public String getMessage(){
            return message;
        }
    }

    enum Phones{
        IPHONE("iPhone"),
        PALM("Palm Treo Pro"),
        HTC("HTC Touch HD");

        private String phone;

        Phones(String phone){
            this.phone = phone;
        }

        public String getPhone(){
            return phone;
        }
    }

    enum MP3{
        IPOD_CLASSIC("iPod Classic"),
        IPOD_NANO("iPod Nano"),
        IPOD_TOUCH("iPod Touch"),
        IPOD_SHUFFLE("iPod Shuffle");

        private String player;

        MP3(String player){
            this.player = player;
        }

        public String getPlayer(){
            return player;
        }
    }

    enum Monitors {
        APPLE_CINEMA("Apple Cinema 30\""),
        SUMSUNG_SYNCMASTER("Samsung SyncMaster 941BW");

        private String monitor;

        Monitors(String monitor) {
            this.monitor = monitor;
        }

        public String getMonitor() {
            return monitor;
        }
    }



    enum EmptyList{
        EMPTYLISTMESS("There are no products to list in this category.");

        private String message;

        EmptyList(String message){
            this.message = message;
        }

        public String getMessage(){
            return message;
        }
    }

    enum Alert{
        SUCCESSESTIMATION("Success: Your shipping estimate has been applied!\n×"),
        FATALESTIMATION(""),
        HUGECOUNTOFORDER("Products marked with *** are not available in the desired quantity or not in stock!\n×"),
        SUCCESMODIFIED("Success: You have modified your shopping cart!\n×"),
        FATALCOUPON("Warning: Coupon is either invalid, expired or reached its usage limit!\n×"),
        FATALGIFTCERTIFICATION("Warning: Gift Certificate is either invalid or the balance has been used up!\n×");

        private String alertMessage;
         Alert(String alertMessage){
            this.alertMessage = alertMessage;
        }

        public String getAlertMessage(){
             return alertMessage;
        }
    }

}
