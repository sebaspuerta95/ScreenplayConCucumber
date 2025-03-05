package screenplay.questions;

import constantes.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screenplay.userinterface.ProductPage;

public class PageTitleQuestion implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageTitleQuestion.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        String productsMessage = Text.of(ProductPage.PRODUCT_TITLE).answeredBy(actor);

        LOGGER.info("Mensaje esperado: {}", Constantes.PRODUCT_TEXT);
        LOGGER.info("Mensaje obtenido: {}", productsMessage);

        return productsMessage.equals(Constantes.PRODUCT_TEXT);
    }

    public static PageTitleQuestion isDisplayed() {
        return new PageTitleQuestion();
    }

}
