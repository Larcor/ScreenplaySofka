@siigo
Feature: Creación exitosa de Cliente en Siigo
  Como usuario de Siigo
  Quiero crear un cliente desde el Dashboard
  Para verificar el funcionamiento del flujo de creación de clientes

  @e2e @crear_cliente
  Scenario Outline: El Actor completa exitosamente la creación de un cliente
    Given "<actor>" se ha autenticado en Siigo
    And él se encuentra en la página principal de la aplicación
    When él intenta realizar la tarea de "Crear - Cliente" ingresando "<tipoId>", "<numeroId>", "<nombre>", "<apellido>", "<ciudad>", "<correo>"
    Then debería ser redirigido a la pantalla de gestión del cliente

    Examples:
      | actor  | tipoId | numeroId  | nombre    | apellido | ciudad | correo         |
      | Manuel | Cédula | 123456789 | Alejandro | Restrepo | Bogotá | test@siigo.com |
