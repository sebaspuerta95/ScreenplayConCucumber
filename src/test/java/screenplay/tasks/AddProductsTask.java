package screenplay.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screenplay.userinterface.ProductPage;

import java.util.List;

public class AddProductsTask implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddProductsTask.class);
    private final List<String> productos;

    public AddProductsTask(List<String> productos) {
        this.productos = productos;
    }

    @Override
    @Step("{0} agrega los productos al carrito: #productos")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Agregando productos al carrito: {}", productos);

        for (String producto : productos) {
            actor.attemptsTo(
                    Click.on(ProductPage.ADD_TO_CART(producto))
            );
        }
    }

    public static AddProductsTask toCart(List<String> productos) {
        return Tasks.instrumented(AddProductsTask.class, productos);
    }
}
