package co.com.screenplay.project.tasks.checkout;

import co.com.screenplay.project.ui.CheckoutFormPage;
import co.com.screenplay.project.ui.ShoppingCartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class SelectGuestCheckout implements Task {

    @Override
    @Step("{0} selecciona la opción de checkout como invitado")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ShoppingCartPage.CHECKOUT_BUTTON, isClickable()),
                Click.on(ShoppingCartPage.CHECKOUT_BUTTON),

                WaitUntil.the(CheckoutFormPage.GUEST_CHECKOUT_RADIO, isVisible()),
                Click.on(CheckoutFormPage.GUEST_CHECKOUT_RADIO),

                WaitUntil.the(CheckoutFormPage.CONTINUE_BUTTON, isVisible()),
                Click.on(CheckoutFormPage.CONTINUE_BUTTON));
    }

    public static SelectGuestCheckout option() {
        return instrumented(SelectGuestCheckout.class);
    }
}
