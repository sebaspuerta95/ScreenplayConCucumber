# language: es

Característica: Inicio de sesión con usuario bloqueado

  @login_bloqueado
  Escenario: Intento de inicio de sesión con usuario bloqueado
    Dado que el usuario intentó iniciar sesión con Username "locked_out_user" y Password "secret_sauce"
    Cuando se verifica el mensaje de error
    Entonces se mostrará el mensaje "Epic sadface: Sorry, this user has been locked out."