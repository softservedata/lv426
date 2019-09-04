import cart.AddToCart;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.awt.*;


@Tag("Opencart")
@Execution(ExecutionMode.CONCURRENT)

public class OpenCartTest {
    private AddToCart meth = new AddToCart();

    @Test
    public void mostUseFunctionalTest() throws InterruptedException {
        meth.logInSearchingAddDelete();
    }

    @Test
    public void checkFunctionalInCartMainPageTest() throws InterruptedException {
        meth.checkIfSiteShowsRightDataInCart("100", "100", "100");
    }

    @Test
    public void differentWayToBookOrderTest() throws InterruptedException, AWTException {
        meth.bookThingWithRequirements();

    }

    @Test
    public void userForgotToLogInAndBookThingsTest() throws InterruptedException {
        meth.withoutLogInBookingOrder();
    }
    @Test
    public void boundaryValuesTest(){
        meth.bookOrderUsingWrongData();

    }

}
