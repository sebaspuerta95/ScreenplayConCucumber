package screenplay.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screenplay.userinterface.ProductPage;

public class GoToCartTask implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoToCartTask.class);

    @Override
    @Step("{0} navega al carrito de compras")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} está accediendo al carrito de compras.", actor.getName());

        actor.attemptsTo(
                Click.on(ProductPage.CART_BUTTON)
        );
    }

    public static GoToCartTask openCart() {
        return Tasks.instrumented(GoToCartTask.class);
    }
}
