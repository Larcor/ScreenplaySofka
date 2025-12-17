package co.com.screenplay.project.factories;

import co.com.screenplay.project.models.CustomerData;
import com.github.javafaker.Faker;

import java.util.Locale;


public class CustomerDataFactory {

    private static final Faker faker = new Faker(new Locale("es"));

    private CustomerDataFactory() {
    }

    public static CustomerData randomGuest() {
        return CustomerData.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .phone(faker.phoneNumber().cellPhone())
                .address(faker.address().streetAddress())
                .city(faker.address().city())
                .postcode(faker.address().zipCode())
                .country("Colombia")
                .zone("Bogota D.C.")
                .comment("Pedido de prueba automatizada - " + faker.lorem().sentence())
                .build();
    }

    public static CustomerData colombianGuest() {
        return CustomerData.builder()
                .firstName("Juan")
                .lastName("Pérez")
                .email("juan.perez@test.com")
                .phone("3001234567")
                .address("Calle 123 # 45-67")
                .city("Bogotá")
                .postcode("110111")
                .country("Colombia")
                .zone("Bogota D.C.")
                .comment("Pedido de prueba")
                .build();
    }

    public static CustomerData withDetails(String firstName, String lastName, String email) {
        return CustomerData.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phone(faker.phoneNumber().cellPhone())
                .address(faker.address().streetAddress())
                .city("Bogotá")
                .postcode("110111")
                .country("Colombia")
                .zone("Bogota D.C.")
                .comment("Pedido personalizado")
                .build();
    }
}
