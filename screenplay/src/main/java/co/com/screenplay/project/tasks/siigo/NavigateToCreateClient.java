package co.com.screenplay.project.tasks.siigo;

import co.com.screenplay.project.ui.SiigoClientFormPage;
import co.com.screenplay.project.ui.SiigoDashboardPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Sub-task para navegar desde el Dashboard al formulario de creación de cliente.
 * Hace click en "Crear" y selecciona "Clientes" del menú desplegable.
 */
public class NavigateToCreateClient implements Task {

    @Override
    @Step("{0} navega a la opción Crear → Clientes desde el dashboard")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SiigoDashboardPage.CREATE_BUTTON, isClickable())
                        .forNoMoreThan(15).seconds(),
                Click.on(SiigoDashboardPage.CREATE_BUTTON),
                WaitUntil.the(SiigoDashboardPage.CLIENTS_OPTION, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(SiigoDashboardPage.CLIENTS_OPTION),
                WaitUntil.the(SiigoClientFormPage.FORM_TITLE, isVisible())
                        .forNoMoreThan(15).seconds());
    }

    public static Performable fromDashboard() {
        return instrumented(NavigateToCreateClient.class);
    }
}
