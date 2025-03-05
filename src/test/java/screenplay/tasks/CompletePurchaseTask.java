package screenplay.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screenplay.userinterface.OverviewPage;

public class CompletePurchaseTask implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompletePurchaseTask.class);

    @Override
    @Step("{0} finaliza la compra")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} está finalizando la compra.", actor.getName());

        actor.attemptsTo(
                Click.on(OverviewPage.FINISH_BUTTON)
        );
    }

    public static CompletePurchaseTask finalizeOrder() {
        return Tasks.instrumented(CompletePurchaseTask.class);
    }
}
