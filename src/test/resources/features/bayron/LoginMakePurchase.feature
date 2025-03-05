# language: es

Característica: Agregar un producto a la lista de productos

  @login
  Esquema del escenario: Agregar productos, eliminar y realizar compra
    Dado que el usuario inició sesión con Username "standard_user" y Password "secret_sauce"
    Cuando ordena los productos por precio del más bajo al más alto
    Y selecciona agregar al carrito los productos "<productos>"
    Y elimina el producto "Sauce Labs Onesie"
    Y finaliza la compra
    Entonces se mostrará un mensaje de confirmación de la compra

    Ejemplos:
      | productos               |
      | Sauce Labs Onesie       |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |