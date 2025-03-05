package screenplay.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screenplay.userinterface.CartPage;

public class GoToCheckoutTask implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoToCheckoutTask.class);

    @Override
    @Step("{0} procede al checkout")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} está procediendo al checkout.", actor.getName());

        actor.attemptsTo(
                Click.on(CartPage.CHECKOUT_BUTTON)
        );
    }

    public static GoToCheckoutTask startCheckout() {
        return Tasks.instrumented(GoToCheckoutTask.class);
    }
}
