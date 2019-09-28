package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.data.ProductName;
import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.EditProductPage;
import org.openqa.selenium.WebDriver;

public class ProductPage extends LeftSidebarMenuComponent {
    private WebDriver driver;
    private ProductContainerComponent productContainerComponent;
    private ProductComponent productComponent;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        productContainerComponent = new ProductContainerComponent(driver);

    }

    private ProductComponent searchIphone() {
        return productContainerComponent.searchByName(ProductName.IPHONE);
    }

    private ProductComponent searchNikon() {
        return productContainerComponent.searchByName(ProductName.NIKON);
    }

    public EditProductPage goToIphoneEditPage() {
         return searchIphone().goToEditProductPage();

    }

    public EditProductPage goToNikonEditPage() {
        return searchNikon().goToEditProductPage();

    }




}
