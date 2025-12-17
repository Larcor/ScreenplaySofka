package co.com.screenplay.project.factories;

import co.com.screenplay.project.models.ProductData;


public class ProductDataFactory {

    private ProductDataFactory() {
    }

    public static ProductData macBook() {
        return ProductData.builder()
                .id("43")
                .name("MacBook")
                .price("$602.00")
                .build();
    }

    public static ProductData iPhone() {
        return ProductData.builder()
                .id("40")
                .name("iPhone")
                .price("$123.20")
                .build();
    }

    public static ProductData appleCinema() {
        return ProductData.builder()
                .id("42")
                .name("Apple Cinema 30\"")
                .price("$122.00")
                .build();
    }

    public static ProductData canon() {
        return ProductData.builder()
                .id("30")
                .name("Canon EOS 5D")
                .price("$98.00")
                .build();
    }

    public static ProductData byId(String productId) {
        return switch (productId) {
            case "43" -> macBook();
            case "40" -> iPhone();
            case "42" -> appleCinema();
            case "30" -> canon();
            default -> ProductData.builder()
                    .id(productId)
                    .name("Unknown Product")
                    .build();
        };
    }
}
