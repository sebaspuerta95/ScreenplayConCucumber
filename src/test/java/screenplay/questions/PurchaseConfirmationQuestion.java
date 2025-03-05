package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.userinterface.ConfirmationPage;
import constantes.Constantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PurchaseConfirmationQuestion implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseConfirmationQuestion.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        String confirmationMessage = Text.of(ConfirmationPage.CONFIRMATION_MESSAGE).answeredBy(actor);

        LOGGER.info("Mensaje esperado: {}", Constantes.MESSAGE_COMPRA);
        LOGGER.info("Mensaje obtenido: {}", confirmationMessage);

        return confirmationMessage.equals(Constantes.MESSAGE_COMPRA);
    }

    public static PurchaseConfirmationQuestion isDisplayed() {
        return new PurchaseConfirmationQuestion();
    }
}
