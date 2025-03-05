Feature: Bloqueo de inicio de sesión
  Como usuario
  Quiero intentar hacer login con credenciales inválidas
  Para verificar que el sistema no permita el ingreso

  Scenario: El usuario intenta iniciar sesión con credenciales invalidas
    Given el usuario se encuentra en la pagina de inicio de sesion
    When intenta hacer inicio de sesion con credenciales invalidas
    Then el usuario deberia recibir un mensaje de error
