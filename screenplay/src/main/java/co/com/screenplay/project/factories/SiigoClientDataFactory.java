package co.com.screenplay.project.factories;

import co.com.screenplay.project.models.SiigoClientData;
import com.github.javafaker.Faker;

import java.util.Locale;

/**
 * Factory para la creación de datos de cliente Siigo.
 * Sigue el patrón del proyecto con constructor privado y métodos estáticos.
 */
public class SiigoClientDataFactory {

    private static final Faker faker = new Faker(new Locale("es"));

    private SiigoClientDataFactory() {
    }

    /**
     * Crea un cliente con datos específicos provenientes del Scenario Outline.
     */
    public static SiigoClientData withDetails(String tipoId, String numeroId,
                                               String nombre, String apellido,
                                               String ciudad, String correo) {
        return SiigoClientData.builder()
                .tipoId(tipoId)
                .numeroId(numeroId)
                .nombre(nombre)
                .apellido(apellido)
                .ciudad(ciudad)
                .correo(correo)
                .build();
    }

    /**
     * Crea un cliente con datos aleatorios usando JavaFaker.
     */
    public static SiigoClientData random() {
        return SiigoClientData.builder()
                .tipoId("Cédula de ciudadanía")
                .numeroId(faker.number().digits(9))
                .nombre(faker.name().firstName())
                .apellido(faker.name().lastName())
                .ciudad("Bogotá")
                .correo(faker.internet().emailAddress())
                .build();
    }
}
