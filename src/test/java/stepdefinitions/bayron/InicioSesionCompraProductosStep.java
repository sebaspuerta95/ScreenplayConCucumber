package stepdefinitions.bayron;

import constantes.Constantes;
import screenplay.hook.OpenBrowser;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screenplay.questions.bayron.ValidateMessageBuy;
import screenplay.tasks.LoginTask;
import screenplay.tasks.SortProductsTask;
import screenplay.tasks.*;
import screenplay.tasks.bayron.EndBuy;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class InicioSesionCompraProductosStep {

    private static final Logger LOGGER = LoggerFactory.getLogger(InicioSesionCompraProductosStep.class);
    private final Actor usuario = OnStage.theActorCalled("Usuario");

    @Dado("que el usuario inició sesión con Username {string} y Password {string}")
    public void queElUsuarioInicioSesion(String username, String password) {
        LOGGER.info("Iniciando sesión en SauceDemo");
        usuario.attemptsTo(OpenBrowser.openURL(Constantes.WEB_URL));
        usuario.attemptsTo(LoginTask.withCredentials(username, password));
    }

    @Cuando("ordena los productos por precio del más bajo al más alto")
    public void ordenaPorPrecio() {
        LOGGER.info("Ordenando los productos por precio del más bajo al más alto");
        usuario.attemptsTo(SortProductsTask.by("za"));
    }

    @Cuando("selecciona agregar al carrito los productos {string}")
    public void agregaProductos(String productos) {
        LOGGER.info("Agregando productos al carrito: {}", productos);
        //usuario.attemptsTo(AddProducts.addToCart(productos));
    }

    @Cuando("elimina el producto {string}")
    public void eliminaProducto(String producto) {
        LOGGER.info("Eliminando producto {} del carrito", producto);
        usuario.attemptsTo(RemoveProductTask.eliminarProducto(producto));
    }

    @Cuando("finaliza la compra")
    public void finalizaCompra() {
        LOGGER.info("Finalizando la compra");
        usuario.attemptsTo(EndBuy.finalizarCompra());
    }

    @Entonces("se mostrará un mensaje de confirmación de la compra")
    public void mensajeDeCompra() {
        LOGGER.info("Validando mensaje de confirmación de compra");
        usuario.should(seeThat(ValidateMessageBuy.mensajeDeCompra(),
                equalTo(Constantes.MESSAGE_COMPRA)));
    }
}