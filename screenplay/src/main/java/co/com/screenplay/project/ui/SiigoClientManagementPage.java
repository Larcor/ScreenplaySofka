package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Page Object para la pantalla de gestión del cliente en Siigo.
 * Se usa para verificar la redirección exitosa tras crear un cliente.
 */
public final class SiigoClientManagementPage {

    private SiigoClientManagementPage() {
    }

    public static final Target CLIENT_MANAGEMENT_BUTTON = Target
            .the("botón de gestión del cliente")
            .locatedBy("//*[@id='main']/div/app-third-party-view/div/div[1]/div[2]/button");
}
