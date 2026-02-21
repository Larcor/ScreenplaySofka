package co.com.screenplay.project.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Page Object para el Dashboard de Siigo.
 * Contiene los elementos del menú principal y el botón "Crear".
 */
public final class SiigoDashboardPage {

    private SiigoDashboardPage() {
    }

    public static final Target CREATE_BUTTON = Target
            .the("botón Crear")
            .locatedBy(".button-container.color-primary-green");

    public static final Target CLIENTS_OPTION = Target
            .the("opción Clientes del menú Crear")
            .locatedBy("//a[@data-value='Clientes']");

    public static final Target DASHBOARD_TITLE = Target
            .the("título del dashboard Inicio")
            .locatedBy("//*[@id=\"main\"]/menu-ai/div/div[1]/div/div[1]");
}
