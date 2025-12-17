# Proyecto de Automatización - OpenCart

## Descripción

Proyecto de automatización de pruebas E2E para la tienda OpenCart utilizando el patrón **Screenplay** con Serenity BDD. Implementa un flujo de compra completo como invitado, demostrando las mejores prácticas de automatización.

## 🏗️ Arquitectura del Proyecto

Este proyecto sigue el patrón **Screenplay**, que proporciona una estructura clara, mantenible y escalable:

```
screenplay/
├── src/
│   ├── main/java/co/com/screenplay/project/
│   │   ├── factories/         # Generadores de datos (JavaFaker)
│   │   │   ├── CustomerDataFactory.java    # Datos aleatorios de cliente
│   │   │   └── ProductDataFactory.java     # Catálogo de productos
│   │   ├── hook/              # Configuración del navegador
│   │   │   └── OpenWeb.java
│   │   ├── models/            # DTOs con Lombok
│   │   │   ├── CustomerData.java
│   │   │   └── ProductData.java
│   │   ├── questions/         # Verificaciones genéricas
│   │   │   ├── TheText.java        # Obtener texto de elementos
│   │   │   ├── TheVisibility.java  # Verificar visibilidad
│   │   │   └── TheValue.java       # Obtener valores de inputs
│   │   ├── tasks/             # Acciones de negocio
│   │   │   ├── AddProductToCart.java
│   │   │   ├── NavigateTo.java
│   │   │   ├── ProceedToCheckout.java  # Orquestador
│   │   │   ├── EnterValueIntoInput.java
│   │   │   └── checkout/      # Tasks atómicas (SRP)
│   │   │       ├── SelectGuestCheckout.java
│   │   │       ├── FillBillingDetails.java
│   │   │       ├── AddOrderComment.java
│   │   │       └── AcceptTermsAndConfirm.java
│   │   ├── ui/                # Elementos de la UI (Targets estáticos)
│   │   │   ├── HeaderPage.java
│   │   │   ├── HomePage.java
│   │   │   ├── ShoppingCartPage.java
│   │   │   ├── CheckoutFormPage.java
│   │   │   └── OrderSuccessfullyPage.java
│   │   └── utils/             # Constantes
│   │       └── Constants.java
│   └── test/
│       ├── java/co/com/screenplay/project/
│       │   ├── runners/
│       │   │   └── RunnerOpenWeb.java
│       │   └── stepdefinitions/
│       │       ├── hook/Hook.java
│       │       └── OpenCartStepDefinition.java
│       └── resources/
│           ├── data/         # Datos de prueba (YAML)
│           ├── features/     # Archivos .feature (Gherkin)
│           └── serenity.conf # Configuración
```

## 🛠️ Tecnologías

| Tecnología | Versión | Descripción |
|------------|---------|-------------|
| Java | 17 | JDK LTS |
| Gradle | 8.10 | Build tool |
| Serenity BDD | 4.2.34 | Framework de pruebas |
| Cucumber | 4.2.34 | BDD/Gherkin |
| JUnit | 5.11.4 | Test runner |
| Selenium | 4.33.0 | Automatización web |
| Lombok | 1.18.32 | Reducción de boilerplate |
| JavaFaker | 1.0.2 | Datos aleatorios |
| Chrome | - | Navegador (autodownload) |

## 📋 Pre-requisitos

- **Java JDK 17** o superior
- **Gradle 8.x**
- **Google Chrome** (se descarga automáticamente ChromeDriver)

## 🚀 Instalación

```bash
# Clonar el repositorio
git clone https://github.com/Larcor/Screenplay.git
cd Screenplay/screenplay

# Verificar Java
java -version  # Debe mostrar 17.x

# Descargar dependencias
./gradlew build
```

## ▶️ Ejecución de Pruebas

### Ejecutar todas las pruebas
```bash
./gradlew clean test
```

### Ejecutar con tags específicos
```bash
# Solo pruebas de humo
./gradlew clean test -Dcucumber.filter.tags="@smoke"

# Prueba principal
./gradlew clean test -Dcucumber.filter.tags="@prueba"
```

### Generar reportes
```bash
./gradlew clean test aggregate
```

📊 Los reportes se generan en: `target/site/serenity/index.html`

## 🧪 Caso de Prueba

### Feature: Compra de productos en OpenCart

```gherkin
@prueba @smoke
Scenario Outline: Compra exitosa de artículos como invitado
  Given "<actor>" abre el navegador
  When el actor agrega los productos al carrito
  And el actor visualiza el carrito
  And el actor completa la información de la compra
  Then debería ver el mensaje de confirmación del pedido
```

**Productos agregados:** MacBook, iPhone

## 📝 Ejemplos de Código

### Agregar productos con Factory
```java
theActorInTheSpotlight().attemptsTo(
    AddProductToCart.product(ProductDataFactory.macBook()),
    AddProductToCart.product(ProductDataFactory.iPhone())
);
```

### Checkout con datos aleatorios
```java
CustomerData customer = CustomerDataFactory.randomGuest();
theActorInTheSpotlight().attemptsTo(
    ProceedToCheckout.with(customer)
);
```

### Verificar texto con Question genérica
```java
theActorInTheSpotlight().should(
    seeThat(
        TheText.of(OrderSuccessfullyPage.ORDER_SUCCESS_MESSAGE),
        containsString("Your order has been placed!")
    )
);
```

## ⚙️ Configuración

### serenity.conf

```hocon
webdriver {
  driver = chrome
  autodownload = true
  
  capabilities {
    browserName = "chrome"
    "goog:chromeOptions" {
      args = [
        "--start-maximized",
        "--ignore-certificate-errors"
      ]
    }
  }
}

environments {
  default {
    webdriver.base.url = "https://opencart.abstracta.us/"
  }
}
```

### Cambiar navegador
```hocon
webdriver {
  driver = firefox  # o edge
}
```

## 🏷️ Tags Disponibles

| Tag | Descripción |
|-----|-------------|
| `@prueba` | Escenario principal de compra |
| `@smoke` | Pruebas de humo |
| `@opencart` | Feature tag |

## 📂 Estructura de Clases Principales

### Tasks
| Clase | Responsabilidad |
|-------|-----------------|
| `ProceedToCheckout` | Orquestador del checkout (delega a sub-tasks) |
| `AddProductToCart` | Agrega productos usando ProductData |
| `NavigateTo` | Navegación genérica entre páginas |
| `SelectGuestCheckout` | Selecciona checkout como invitado |
| `FillBillingDetails` | Rellena formulario con CustomerData |
| `AddOrderComment` | Agrega comentario al pedido |
| `AcceptTermsAndConfirm` | Acepta términos y confirma |

### Questions
| Clase | Retorna |
|-------|---------|
| `TheText.of(Target)` | `String` - Texto del elemento |
| `TheVisibility.of(Target)` | `Boolean` - Visible o no |
| `TheValue.of(Target)` | `String` - Valor de input |

### Factories
| Clase | Uso |
|-------|-----|
| `CustomerDataFactory.randomGuest()` | Cliente con datos aleatorios |
| `CustomerDataFactory.colombianGuest()` | Cliente predefinido CO |
| `ProductDataFactory.macBook()` | Datos de MacBook |
| `ProductDataFactory.iPhone()` | Datos de iPhone |

## 📖 Convenciones

- **Clases**: PascalCase
- **Métodos**: camelCase
- **Archivos feature**: snake_case
- **Gherkin**: Español
- **Código**: Inglés

## 👤 Autor

**Manuel Bobadilla**

---

*Proyecto desarrollado siguiendo principios SOLID y las mejores prácticas del patrón Screenplay.*
