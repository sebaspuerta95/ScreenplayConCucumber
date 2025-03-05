package screenplay.questions.bayron;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screenplay.userinterface.ConfirmationPage;

public class ValidateMessageBuy implements Question<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateMessageBuy.class);

    @Override
    public String answeredBy(Actor actor) {
        String message = Text.of(ConfirmationPage.CONFIRMATION_MESSAGE).answeredBy(actor);
        LOGGER.info("Validando mensaje de confirmación de compra ");
        return message;
    }

    public static Question<String> mensajeDeCompra() {
        return new ValidateMessageBuy();
    }
}