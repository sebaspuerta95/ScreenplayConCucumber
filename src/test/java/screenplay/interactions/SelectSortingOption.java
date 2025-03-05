package screenplay.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import screenplay.userinterface.ProductPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectSortingOption implements Interaction {

    private final String option;

    public SelectSortingOption(String option) {
        this.option = option;
    }

    @Override
    @Step("{0} selects sorting option #option")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byValue(option).from(ProductPage.SORT_DROPDOWN)
        );
    }

    public static SelectSortingOption byValue(String option) {
        return instrumented(SelectSortingOption.class, option);
    }

}
