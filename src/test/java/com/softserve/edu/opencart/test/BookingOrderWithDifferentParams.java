package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.SearchFilter;
import com.softserve.edu.opencart.data.SearchFilterRepository;
import com.softserve.edu.opencart.data.shop.ShopRepository;
import com.softserve.edu.opencart.pages.user.shop.ShoppingCartPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BookingOrderWithDifferentParams extends ParallelTestRunner {

    @DataProvider
    public Object[][] dataProvider(){
        return new Object[][]{
                {SearchFilterRepository.searchIPhone(), SearchFilterRepository.searchMacBook(),
                SearchFilterRepository.searchNikon(), ShopRepository.massOfSymbols()}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void bookingOrdersWithUnexpectedParams(SearchFilter searchIPhone,SearchFilter searchIMac,
                                                  SearchFilter searchNikon, String[] mass){
        ShoppingCartPage shoppingCartPage = loadMaxParallelApplication()
                .successfulSearch(searchIPhone.getProduct())
                .addProductToCartByProductCriteriaComponent(searchIPhone)
                .successfulSearch(searchIMac.getProduct())
                .addProductToCartByProductCriteriaComponent(searchIMac)
                .successfulSearch(searchNikon.getProduct())
                .addProductToCartByProductCriteriaComponent(searchNikon)
                .gotoShoppingCartPage()
                .tryToChangeSomething()
                .changeCountOfSomeOrderByName(searchIPhone.getProduct()
                        , searchIPhone.getProduct().getPrice(Currencies.TEST))
                .tryToChangeSomething()
                .changeCountOfSomeOrderByName(searchIMac.getProduct(),
                        searchIMac.getProduct().getPrice(Currencies.TEST))
                .tryToChangeSomething()
                .changeCountOfSomeOrderByName(searchNikon.getProduct(),
                        searchNikon.getProduct().getPrice(Currencies.TEST))
                .tryToChangeSomething()
                .changeCountOfSomeOrderByName(searchIPhone.getProduct()
                        , searchIPhone.getProduct().getPrice(Currencies.US_DOLLAR))
                .tryToChangeSomething()
                .changeCountOfSomeOrderByName(searchIPhone.getProduct()
                        , searchIPhone.getProduct().getPrice(Currencies.US_DOLLAR).replaceAll("1",""))
                ;
                 assertEquals(shoppingCartPage.getBodyOfEmptyCart(),
                "Your shopping cart is empty!",
                "Shopping cart has active orders");
    }

    @DataProvider
    public Object[][] dataProviderForTheFirst(){
        return new Object[][]{
                {SearchFilterRepository.searchIPhone(), ShopRepository.massOfSymbols()}
        };
    }

    @Test(dataProvider = "dataProviderForTheFirst")
    public void bookingOrdersWithUnexpectedParamsFirstPart(SearchFilter searchIPhone,String[] mass){
        ShoppingCartPage shoppingCartPage = loadMaxParallelApplication()
                .successfulSearch(searchIPhone.getProduct())
                .addProductToCartByProductCriteriaComponent(searchIPhone)
                .gotoShoppingCartPage()
                .tryToChangeSomething()
                .changeCountOfSomeOrderByName(searchIPhone.getProduct()
                        , searchIPhone.getProduct().getPrice(Currencies.TEST));
        for(int i =mass.length/3;i<12;i++){
            shoppingCartPage.gotoHomePageFromShoppingCart();
            shoppingCartPage.successfulSearch(searchIPhone.getProduct())
                    .addProductToCartByProductCriteriaComponent(searchIPhone)
                    .gotoShoppingCartPage();
            shoppingCartPage.tryToChangeSomething()
                    .clickInputACountOfOrderByName(searchIPhone.getProduct());
            shoppingCartPage.tryToChangeSomething()
                    .clearInputACountOfOrderByName(searchIPhone.getProduct());
            shoppingCartPage.tryToChangeSomething()
                    .setInputACountOfOrderByName(searchIPhone.getProduct().getName(),mass[i]);
            shoppingCartPage.tryToChangeSomething().clickToSubmitChangesInCartTable();
            assertEquals(shoppingCartPage.getBodyOfEmptyCart(),
                    "Your shopping cart is empty!",
                    "Shopping cart has active orders");
            shoppingCartPage.refreshShoppingCart();        }
    }
    @DataProvider
    public Object[][] dataProviderForTheSecond(){
        return new Object[][]{
                {SearchFilterRepository.searchIPhone(), ShopRepository.massOfSymbols()}
        };
    }

    @Test(dataProvider = "dataProviderForTheSecond")
    public void bookingOrdersWithUnexpectedParamsSecondPart(SearchFilter searchIPhone,String[] mass){
        ShoppingCartPage shoppingCartPage = loadMaxParallelApplication()
                .successfulSearch(searchIPhone.getProduct())
                .addProductToCartByProductCriteriaComponent(searchIPhone)
                .gotoShoppingCartPage()
                .tryToChangeSomething()
                .changeCountOfSomeOrderByName(searchIPhone.getProduct()
                        , searchIPhone.getProduct().getPrice(Currencies.TEST));
        for(int i =0;i<mass.length;i++){
            shoppingCartPage.gotoHomePageFromShoppingCart();
            shoppingCartPage.successfulSearch(searchIPhone.getProduct())
                    .addProductToCartByProductCriteriaComponent(searchIPhone)
                    .gotoShoppingCartPage();
            shoppingCartPage.tryToChangeSomething()
                    .clickInputACountOfOrderByName(searchIPhone.getProduct());
            shoppingCartPage.tryToChangeSomething()
                    .clearInputACountOfOrderByName(searchIPhone.getProduct());
            shoppingCartPage.tryToChangeSomething()
                    .setInputACountOfOrderByName(searchIPhone.getProduct().getName(),mass[i]);
            shoppingCartPage.tryToChangeSomething().clickToSubmitChangesInCartTable();
            assertEquals(shoppingCartPage.getBodyOfEmptyCart(),
                    "Your shopping cart is empty!",
                    "Shopping cart has active orders");
            shoppingCartPage.refreshShoppingCart();        }
    }

    @DataProvider
    public Object[][] dataProviderForTheThird(){
        return new Object[][]{
                {SearchFilterRepository.searchIPhone(), ShopRepository.massOfSymbols()}
        };
    }

    @Test(dataProvider = "dataProviderForTheThird")
    public void bookingOrdersWithUnexpectedParamsThirdPart(SearchFilter searchIPhone,String[] mass){
        ShoppingCartPage shoppingCartPage = loadMaxParallelApplication()
                .successfulSearch(searchIPhone.getProduct())
                .addProductToCartByProductCriteriaComponent(searchIPhone)
                .gotoShoppingCartPage()
                .tryToChangeSomething()
                .changeCountOfSomeOrderByName(searchIPhone.getProduct()
                        , searchIPhone.getProduct().getPrice(Currencies.TEST));
        for(int i =12;i<mass.length;i++){
            shoppingCartPage.gotoHomePageFromShoppingCart();
            shoppingCartPage.successfulSearch(searchIPhone.getProduct())
                    .addProductToCartByProductCriteriaComponent(searchIPhone)
                    .gotoShoppingCartPage();
            shoppingCartPage.tryToChangeSomething()
                    .clickInputACountOfOrderByName(searchIPhone.getProduct());
            shoppingCartPage.tryToChangeSomething()
                    .clearInputACountOfOrderByName(searchIPhone.getProduct());
            shoppingCartPage.tryToChangeSomething()
                    .setInputACountOfOrderByName(searchIPhone.getProduct().getName(),mass[i]);
            shoppingCartPage.tryToChangeSomething().clickToSubmitChangesInCartTable();
            assertEquals(shoppingCartPage.getBodyOfEmptyCart(),
                    "Your shopping cart is empty!",
                    "Shopping cart has active orders");
            shoppingCartPage.refreshShoppingCart();
        }
    }
}
