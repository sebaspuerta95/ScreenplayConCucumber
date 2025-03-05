package screenplay.questions;

import constantes.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screenplay.userinterface.ConfirmationPage;
import screenplay.userinterface.LoginPage;

public class BlockedUserQuestion implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlockedUserQuestion.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        String errorMessage = Text.of(LoginPage.LBL_MESSAGE_ERROR).answeredBy(actor);

        LOGGER.info("Mensaje esperado: {}", Constantes.MESSAGE_ERROR);
        LOGGER.info("Mensaje obtenido: {}", errorMessage);

        return errorMessage.equals(Constantes.MESSAGE_ERROR);
    }

    public static BlockedUserQuestion isDisplayed() {
        return new BlockedUserQuestion();
    }

}
