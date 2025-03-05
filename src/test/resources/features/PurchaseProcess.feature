Feature: Gestion de la compra de productos
  Como usuario con credenciales validas
  Quiero hacer login
  Para agregar productos al carrito de compras y completar la compra

  Scenario: Proceso de compra exitoso completado
    Given el usuario hace login con credenciales validas
    When ordena los productos por criterio
    And agrega dos productos y elimina uno de ellos
    And procede a confirmar la compra
    Then el usuario deberia recibir un mensaje de confirmacion
