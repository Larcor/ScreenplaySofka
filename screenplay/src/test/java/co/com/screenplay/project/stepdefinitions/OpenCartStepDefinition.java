package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.factories.CustomerDataFactory;
import co.com.screenplay.project.factories.ProductDataFactory;
import co.com.screenplay.project.models.CustomerData;
import co.com.screenplay.project.questions.TheText;
import co.com.screenplay.project.tasks.AddProductToCart;
import co.com.screenplay.project.tasks.NavigateTo;
import co.com.screenplay.project.tasks.ProceedToCheckout;
import co.com.screenplay.project.ui.OrderSuccessfullyPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

/**
 * Step Definitions para el flujo de compra en OpenCart.
 * Usa factories para datos y Questions genéricas.
 */
public class OpenCartStepDefinition {

    @When("el actor agrega los productos al carrito")
    public void elActorAgregaLosProductosAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                AddProductToCart.product(ProductDataFactory.macBook()),
                AddProductToCart.product(ProductDataFactory.iPhone()));
    }

    @When("el actor visualiza el carrito")
    public void elActorVisualizaElCarrito() {
        theActorInTheSpotlight().attemptsTo(
                NavigateTo.theShoppingCart());
    }

    @When("el actor completa la información de la compra")
    public void elActorCompletaLaInformacionDeLaCompra() {
        // Usa factory para generar datos aleatorios de cliente
        CustomerData customer = CustomerDataFactory.randomGuest();

        theActorInTheSpotlight().attemptsTo(
                ProceedToCheckout.with(customer));
    }

    @Then("debería ver el mensaje de confirmación del pedido")
    public void deberiaVerElMensajeDeConfirmacionDelPedido() {
        theActorInTheSpotlight().should(
                seeThat(
                        TheText.of(OrderSuccessfullyPage.ORDER_SUCCESS_MESSAGE),
                        containsString("Your order has been placed!")));
    }
}