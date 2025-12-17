package co.com.screenplay.project.tasks.checkout;

import co.com.screenplay.project.tasks.EnterValueIntoInput;
import co.com.screenplay.project.ui.CheckoutFormPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class AddOrderComment implements Task {

    private final String comment;

    public AddOrderComment(String comment) {
        this.comment = comment;
    }

    @Override
    @Step("{0} agrega comentario al pedido y confirma envío")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterValueIntoInput.with(CheckoutFormPage.COMMENT_TEXTAREA, comment),
                Click.on(CheckoutFormPage.DELIVERY_CONTINUE_BUTTON));
    }

    public static AddOrderComment withText(String comment) {
        return instrumented(AddOrderComment.class, comment);
    }

    public static AddOrderComment defaultComment() {
        return instrumented(AddOrderComment.class, "Pedido de prueba automatizada");
    }
}
