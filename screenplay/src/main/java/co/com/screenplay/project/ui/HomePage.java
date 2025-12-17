package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;

public final class HomePage {

    private HomePage() {
    }

    public static final Target ADD_TO_CART_BUTTON = Target
            .the("botón de agregar al carrito")
            .locatedBy("//button[contains(@onclick,\"cart.add('{0}')\")]");

    public static final Target PRODUCT_NAME = Target
            .the("nombre del producto")
            .locatedBy(".product-layout .caption h4 a");
}