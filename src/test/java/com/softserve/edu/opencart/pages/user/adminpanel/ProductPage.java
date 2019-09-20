package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.data.ProductName;
import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.EditProductPage;
import org.openqa.selenium.WebDriver;

public class ProductPage extends LeftSidebarMenuComponent {
    private WebDriver driver;
    private ProductContainerComponent productContainerComponent;
    private ProductComponent productComponent;

    ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        productContainerComponent = new ProductContainerComponent(driver);

    }

    private void searchIphone() {
        productComponent = productContainerComponent.searchByName(ProductName.IPHONE);
    }

    public EditProductPage goToIphoneEditPage() {
        productComponent.goToEditProductPage();
        return new EditProductPage(driver);
    }


}
