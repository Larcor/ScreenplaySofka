package co.com.screenplay.project.tasks;

import co.com.screenplay.project.models.SiigoClientData;
import co.com.screenplay.project.tasks.siigo.FillClientForm;
import co.com.screenplay.project.tasks.siigo.NavigateToCreateClient;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Task orquestador para la creación de un cliente en Siigo.
 * Coordina la navegación al formulario y el llenado de datos.
 * Sigue el principio de responsabilidad única delegando a sub-tasks.
 */
public class CreateClient implements Task {

    private final SiigoClientData clientData;

    public CreateClient(SiigoClientData clientData) {
        this.clientData = clientData;
    }

    @Override
    @Step("{0} realiza la tarea de crear un cliente en Siigo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                NavigateToCreateClient.fromDashboard(),
                FillClientForm.with(clientData));
    }

    public static Performable with(SiigoClientData clientData) {
        return instrumented(CreateClient.class, clientData);
    }
}
