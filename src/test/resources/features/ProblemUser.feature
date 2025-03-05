Feature: Inicio de sesión con usuario problema
  Como usuario
  Quiero hacer login con un usuario con problemas
  Para verificar que las imagenes de los productos no se muestren

  Scenario: Intento de inicio de sesión con usuario problema donde no cargan imagenes
    Given el usuario esta en la pagina de inicio de sesion
    When intenta hacer inicio de sesion con credenciales con problemas
    Then el usuario deberia ser redirigido a la pagina de productos
    And las imagenes de los productos no deberian estar cargadas