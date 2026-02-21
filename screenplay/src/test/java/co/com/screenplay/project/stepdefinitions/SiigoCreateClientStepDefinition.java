package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.factories.SiigoClientDataFactory;
import co.com.screenplay.project.models.SiigoClientData;
import co.com.screenplay.project.questions.TheVisibility;
import co.com.screenplay.project.tasks.CreateClient;
import co.com.screenplay.project.tasks.LoginToSiigo;
import co.com.screenplay.project.ui.SiigoClientManagementPage;
import co.com.screenplay.project.ui.SiigoDashboardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.utils.Constants.SIIGO_EMAIL;
import static co.com.screenplay.project.utils.Constants.SIIGO_PASSWORD;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.is;

/**
 * Step Definitions para el flujo de creación de cliente en Siigo.
 * Implementa los pasos del Scenario Outline TC-E2E-01.
 */
public class SiigoCreateClientStepDefinition {

    @Given("{string} se ha autenticado en Siigo")
    public void seHaAutenticadoEnSiigo(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(
                LoginToSiigo.withCredentials(SIIGO_EMAIL, SIIGO_PASSWORD));
    }

    @And("él se encuentra en la página principal de la aplicación")
    public void elSeEncuentraEnLaPaginaPrincipalDeLaAplicacion() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(SiigoDashboardPage.DASHBOARD_TITLE, isVisible())
                        .forNoMoreThan(30).seconds());
    }

    @When("él intenta realizar la tarea de {string} ingresando {string}, {string}, {string}, {string}, {string}, {string}")
    public void elIntentaRealizarLaTareaDeCrearCliente(String tarea,
                                                        String tipoId, String numeroId,
                                                        String nombre, String apellido,
                                                        String ciudad, String correo) {
        SiigoClientData clientData = SiigoClientDataFactory
                .withDetails(tipoId, numeroId, nombre, apellido, ciudad, correo);

        theActorInTheSpotlight().attemptsTo(
                CreateClient.with(clientData));
    }

    @Then("debería ser redirigido a la pantalla de gestión del cliente")
    public void deberiaSerRedirigidoALaPantallaDeGestionDelCliente() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(SiigoClientManagementPage.CLIENT_MANAGEMENT_BUTTON, isVisible())
                        .forNoMoreThan(20).seconds());

        theActorInTheSpotlight().should(
                seeThat(
                        TheVisibility.of(SiigoClientManagementPage.CLIENT_MANAGEMENT_BUTTON),
                        is(true)));
    }
}
