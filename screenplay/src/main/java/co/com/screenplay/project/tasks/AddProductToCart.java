package co.com.screenplay.project.tasks;

import co.com.screenplay.project.models.ProductData;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.screenplay.project.ui.HomePage.ADD_TO_CART_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Task para agregar productos al carrito.
 */
public class AddProductToCart implements Task {

    private final String productId;

    public AddProductToCart(String productId) {
        this.productId = productId;
    }

    @Override
    @Step("{0} agrega el producto al carrito")
    public <T extends Actor> void performAs(T actor) {
        Target button = ADD_TO_CART_BUTTON.of(productId);
        actor.attemptsTo(
                Click.on(button));
    }

    /**
     * Agrega producto por ID.
     */
    public static AddProductToCart withId(String productId) {
        return instrumented(AddProductToCart.class, productId);
    }

    /**
     * Agrega producto usando ProductData.
     */
    public static AddProductToCart product(ProductData product) {
        return instrumented(AddProductToCart.class, product.getId());
    }
}