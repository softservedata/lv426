package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.data.ProductName;
import org.openqa.selenium.WebDriver;

public class ProductPage extends LeftSidebarMenuComponent {

    private ProductContainerComponent productContainerComponent;
    private ProductComponent productComponent;

    ProductPage(WebDriver driver) {
        super(driver);
        productContainerComponent = new ProductContainerComponent(driver);

    }

    private void searchIphone() {
        productComponent = productContainerComponent.searchByName(ProductName.productName.IPHONE.getValue());
    }
    public EditProductPage goToIphoneEditPage() {
        productComponent.goToEditProductPage();
        return new EditProductPage(driver);
    }




}
