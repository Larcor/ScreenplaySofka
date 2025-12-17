package co.com.screenplay.project.tasks.checkout;

import co.com.screenplay.project.models.CustomerData;
import co.com.screenplay.project.tasks.EnterValueIntoInput;
import co.com.screenplay.project.ui.CheckoutFormPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class FillBillingDetails implements Task {

    private final CustomerData customerData;

    public FillBillingDetails(CustomerData customerData) {
        this.customerData = customerData;
    }

    @Override
    @Step("{0} completa los detalles de facturación")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterValueIntoInput.with(CheckoutFormPage.FIRSTNAME_INPUT, customerData.getFirstName()),
                EnterValueIntoInput.with(CheckoutFormPage.LASTNAME_INPUT, customerData.getLastName()),
                EnterValueIntoInput.with(CheckoutFormPage.EMAIL_INPUT, customerData.getEmail()),
                EnterValueIntoInput.with(CheckoutFormPage.PHONE_INPUT, customerData.getPhone()),
                EnterValueIntoInput.with(CheckoutFormPage.ADDRESS_INPUT, customerData.getAddress()),
                EnterValueIntoInput.with(CheckoutFormPage.CITY_INPUT, customerData.getCity()),
                EnterValueIntoInput.with(CheckoutFormPage.POSTCODE_INPUT, customerData.getPostcode()),

                WaitUntil.the(CheckoutFormPage.PAYMENT_COUNTRY_DROPBOX, isClickable()),
                SelectFromOptions.byVisibleText(customerData.getCountry())
                        .from(CheckoutFormPage.PAYMENT_COUNTRY_DROPBOX),
                SelectFromOptions.byVisibleText(customerData.getZone()).from(CheckoutFormPage.PAYMENT_ZONE_DROPBOX),

                WaitUntil.the(CheckoutFormPage.BILLING_CONTINUE_BUTTON, isClickable()),
                Click.on(CheckoutFormPage.BILLING_CONTINUE_BUTTON));
    }

    public static FillBillingDetails with(CustomerData customerData) {
        return instrumented(FillBillingDetails.class, customerData);
    }
}
