package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Page Object para la página de login de Siigo.
 * URL: https://qastaging.siigo.com/#/login
 */
public final class SiigoLoginPage {

    private SiigoLoginPage() {
    }

    public static final Target EMAIL_INPUT = Target
            .the("campo de correo electrónico")
            .locatedBy("#siigoSignInName");

    public static final Target PASSWORD_INPUT = Target
            .the("campo de contraseña")
            .locatedBy("#siigoPassword");

    public static final Target LOGIN_BUTTON = Target
            .the("botón de inicio de sesión")
            .locatedBy("#siigoNext");
}
