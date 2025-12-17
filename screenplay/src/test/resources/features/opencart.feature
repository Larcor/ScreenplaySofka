@opencart
Feature: Compra de productos en OpenCart
  Como usuario de la tienda OpenCart
  Quiero realizar una compra completa
  Para verificar el funcionamiento del flujo de checkout

  @prueba @smoke
  Scenario Outline: Compra exitosa de artículos como invitado
    Given "<actor>" abre el navegador
    When el actor agrega los productos al carrito
    And el actor visualiza el carrito
    And el actor completa la información de la compra
    Then debería ver el mensaje de confirmación del pedido

    Examples:
      | actor  |
      | Manuel |