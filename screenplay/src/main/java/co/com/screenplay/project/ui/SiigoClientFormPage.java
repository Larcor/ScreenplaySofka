package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Page Object para el formulario de creación de cliente (tercero) en Siigo.
 * Sección "Crear un tercero" con los campos de Datos básicos y facturación.
 */
public final class SiigoClientFormPage {

    private SiigoClientFormPage() {
    }

    // --- Tipo de identificación (MDC Dropdown) ---
    public static final Target TIPO_ID_DROPDOWN = Target
            .the("dropdown tipo de identificación")
            .locatedBy("//*[@id='identification']/parent::*/preceding-sibling::*//div[contains(@class,'mdc-select__anchor')]");

    public static final Target TIPO_ID_OPTION = Target
            .the("opción del dropdown tipo de identificación: {0}")
            .locatedBy("//li[contains(@class,'mdc-list-item') and contains(.,'{0}')]");

    // --- Número de identificación ---
    public static final Target NUMERO_ID_INPUT = Target
            .the("campo número de identificación")
            .locatedBy("//*[@id='identification']//input[contains(@class,'input-identification')]");

    // --- Nombres ---
    public static final Target NOMBRE_INPUT = Target
            .the("campo nombres")
            .locatedBy("//label[contains(text(),'Nombres') and not(contains(text(),'contacto'))]/preceding-sibling::input");

    // --- Apellidos ---
    public static final Target APELLIDO_INPUT = Target
            .the("campo apellidos")
            .locatedBy("//label[contains(text(),'Apellidos') and not(contains(text(),'contacto'))]/preceding-sibling::input");

    // --- Correo electrónico ---
    public static final Target CORREO_INPUT = Target
            .the("campo correo electrónico")
            .locatedBy("//label[contains(text(),'Correo')]/preceding-sibling::input");

    // --- Ciudad ---
    public static final Target CIUDAD_INPUT = Target
            .the("campo ciudad")
            .locatedBy("//label[contains(text(),'Ciudad')]/preceding-sibling::input");

    // --- Botón Guardar ---
    public static final Target SAVE_BUTTON = Target
            .the("botón Guardar")
            .locatedBy("//button[contains(.,'Guardar')]");

    // --- Título del formulario ---
    public static final Target FORM_TITLE = Target
            .the("título del formulario Crear un tercero")
            .locatedBy("//h1[contains(text(),'Crear un tercero')]");
}
