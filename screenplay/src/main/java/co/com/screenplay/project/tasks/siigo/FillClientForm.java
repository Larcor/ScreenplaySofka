package co.com.screenplay.project.tasks.siigo;

import co.com.screenplay.project.models.SiigoClientData;
import co.com.screenplay.project.tasks.EnterValueIntoInput;
import co.com.screenplay.project.ui.SiigoClientFormPage;
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
 * Sub-task para llenar el formulario de creación de cliente en Siigo.
 * Selecciona el tipo de identificación del dropdown MDC,
 * ingresa los datos básicos y hace click en Guardar.
 */
public class FillClientForm implements Task {

    private final SiigoClientData clientData;

    public FillClientForm(SiigoClientData clientData) {
        this.clientData = clientData;
    }

    @Override
    @Step("{0} completa el formulario de creación de cliente")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                selectTipoIdentificacion(),
                EnterValueIntoInput.with(SiigoClientFormPage.NUMERO_ID_INPUT, clientData.getNumeroId()),
                EnterValueIntoInput.with(SiigoClientFormPage.NOMBRE_INPUT, clientData.getNombre()),
                EnterValueIntoInput.with(SiigoClientFormPage.APELLIDO_INPUT, clientData.getApellido()),
                EnterValueIntoInput.with(SiigoClientFormPage.CORREO_INPUT, clientData.getCorreo()),
                WaitUntil.the(SiigoClientFormPage.SAVE_BUTTON, isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(SiigoClientFormPage.SAVE_BUTTON));
    }

    /**
     * Selecciona la opción del dropdown MDC de tipo de identificación.
     */
    private Performable selectTipoIdentificacion() {
        return Task.where("{0} selecciona tipo de identificación: " + clientData.getTipoId(),
                WaitUntil.the(SiigoClientFormPage.TIPO_ID_DROPDOWN, isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(SiigoClientFormPage.TIPO_ID_DROPDOWN),
                WaitUntil.the(SiigoClientFormPage.TIPO_ID_OPTION.of(clientData.getTipoId()), isVisible())
                        .forNoMoreThan(5).seconds(),
                Click.on(SiigoClientFormPage.TIPO_ID_OPTION.of(clientData.getTipoId())));
    }

    public static Performable with(SiigoClientData clientData) {
        return instrumented(FillClientForm.class, clientData);
    }
}
