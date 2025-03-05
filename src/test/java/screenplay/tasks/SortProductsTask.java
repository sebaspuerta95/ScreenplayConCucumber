package screenplay.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import screenplay.interactions.SelectSortingOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SortProductsTask implements Task {

    private final String option;
    private static final Logger LOGGER = LoggerFactory.getLogger(SortProductsTask.class);

    public SortProductsTask(String option) {
        this.option = option;
    }

    @Override
    @Step("{0} sorts products by #option")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} está ordenando productos por la opción: {}", actor.getName(), option);
        actor.attemptsTo(SelectSortingOption.byValue(option));
    }

    public static SortProductsTask by(String option) {
        return instrumented(SortProductsTask.class, option);
    }

}
