package screenplay.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screenplay.userinterface.CartPage;

public class RemoveProductTask implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoveProductTask.class);
    private final String producto;

    public RemoveProductTask(String producto) {
        this.producto = producto;
    }

    @Override
    @Step("{0} elimina el producto '#producto' del carrito")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} está eliminando el producto '{}' del carrito", actor.getName(), producto);
        actor.attemptsTo(
                Click.on(CartPage.REMOVE_BUTTON(producto))
        );
    }

    public static RemoveProductTask eliminarProducto(String producto) {
        return Tasks.instrumented(RemoveProductTask.class, producto);
    }
}
