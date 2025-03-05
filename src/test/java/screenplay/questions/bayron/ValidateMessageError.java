package screenplay.questions.bayron;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import screenplay.userinterface.LoginPage;

public class ValidateMessageError implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return LoginPage.LBL_MESSAGE_ERROR.resolveFor(actor).getText();
    }

    public static ValidateMessageError es() {
        return new ValidateMessageError();
    }

}
