package co.com.screenplay.project.tasks;

import co.com.screenplay.project.models.CustomerData;
import co.com.screenplay.project.tasks.checkout.AcceptTermsAndConfirm;
import co.com.screenplay.project.tasks.checkout.AddOrderComment;
import co.com.screenplay.project.tasks.checkout.FillBillingDetails;
import co.com.screenplay.project.tasks.checkout.SelectGuestCheckout;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ProceedToCheckout implements Task {

    private final CustomerData customerData;

    public ProceedToCheckout(CustomerData customerData) {
        this.customerData = customerData;
    }

    @Override
    @Step("{0} completa el proceso de checkout")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectGuestCheckout.option(),
                FillBillingDetails.with(customerData),
                AddOrderComment.withText(customerData.getComment()),
                AcceptTermsAndConfirm.order());
    }

    public static ProceedToCheckout with(CustomerData customerData) {
        return instrumented(ProceedToCheckout.class, customerData);
    }

    @Deprecated
    public static ProceedToCheckout complete() {
        CustomerData defaultCustomer = CustomerData.builder()
                .firstName("Test")
                .lastName("User")
                .email("test@automation.com")
                .phone("3001234567")
                .address("Calle Test # 123")
                .city("Bogotá")
                .postcode("110111")
                .country("Colombia")
                .zone("Bogota D.C.")
                .comment("Pedido de prueba")
                .build();
        return instrumented(ProceedToCheckout.class, defaultCustomer);
    }
}
