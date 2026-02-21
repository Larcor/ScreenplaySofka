package co.com.screenplay.project.tasks;

import co.com.screenplay.project.ui.SiigoLoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.utils.Constants.SIIGO_URL;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Task para autenticarse en la aplicación Siigo.
 * Abre la URL, ingresa credenciales y hace click en el botón de login.
 */
public class LoginToSiigo implements Task {

    private final String email;
    private final String password;

    public LoginToSiigo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    @Step("{0} se autentica en Siigo con las credenciales proporcionadas")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(SIIGO_URL),
                WaitUntil.the(SiigoLoginPage.EMAIL_INPUT, isVisible())
                        .forNoMoreThan(30).seconds(),
                EnterValueIntoInput.with(SiigoLoginPage.EMAIL_INPUT, email),
                EnterValueIntoInput.with(SiigoLoginPage.PASSWORD_INPUT, password),
                WaitUntil.the(SiigoLoginPage.LOGIN_BUTTON, isClickable()),
                Click.on(SiigoLoginPage.LOGIN_BUTTON));
    }

    public static Performable withCredentials(String email, String password) {
        return instrumented(LoginToSiigo.class, email, password);
    }
}
