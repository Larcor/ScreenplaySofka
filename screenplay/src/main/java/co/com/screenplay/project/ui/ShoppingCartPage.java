package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;


public final class ShoppingCartPage {

    private ShoppingCartPage() {
    }

    public static final Target CHECKOUT_BUTTON = Target.the("checkout button")
            .locatedBy("a[href*='checkout/checkout']");

    public static final Target CART_TOTAL = Target.the("cart total")
            .locatedBy("#content .table-responsive table tbody tr:last-child td:last-child");

    public static final Target EMPTY_CART_MESSAGE = Target.the("empty cart message")
            .locatedBy("#content p");
}