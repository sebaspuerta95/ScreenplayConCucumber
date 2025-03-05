package screenplay.tasks.bayron;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screenplay.userinterface.CartPage;
import screenplay.userinterface.OverviewPage;
import screenplay.userinterface.PersonalInfoPage;
import screenplay.userinterface.ProductPage;

public class EndBuy implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(EndBuy.class);

    @Override
    @Step("Finaliza la compra ingresando datos y confirmando la compra")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Iniciando finalización de la compra");
        actor.attemptsTo(
                Click.on(ProductPage.CART_BUTTON),
                Click.on(CartPage.CHECKOUT_BUTTON),
                Enter.theValue("José").into(PersonalInfoPage.FIRST_NAME_FIELD),
                Enter.theValue("Ramón").into(PersonalInfoPage.LAST_NAME_FIELD),
                Enter.theValue("12345").into(PersonalInfoPage.POSTAL_CODE_FIELD),
                Click.on(PersonalInfoPage.CONTINUE_BUTTON),
                Click.on(OverviewPage.FINISH_BUTTON)
        );
        LOGGER.info("Compra finalizada exitosamente");

    }

    public static EndBuy finalizarCompra() {
        return Tasks.instrumented(EndBuy.class);
    }

}
