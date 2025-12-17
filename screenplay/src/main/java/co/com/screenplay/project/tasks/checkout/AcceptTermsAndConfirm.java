package co.com.screenplay.project.tasks.checkout;

import co.com.screenplay.project.ui.CheckoutFormPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class AcceptTermsAndConfirm implements Task {

    @Override
    @Step("{0} acepta términos y confirma el pedido")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckoutFormPage.AGREE_CHECKBOX),
                Click.on(CheckoutFormPage.PAYMENT_CONTINUE_BUTTON),
                Click.on(CheckoutFormPage.CONFIRM_ORDER_BUTTON));
    }

    public static AcceptTermsAndConfirm order() {
        return instrumented(AcceptTermsAndConfirm.class);
    }
}
