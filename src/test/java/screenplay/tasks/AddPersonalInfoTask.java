package screenplay.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import screenplay.userinterface.PersonalInfoPage;

public class AddPersonalInfoTask implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddPersonalInfoTask.class);
    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public AddPersonalInfoTask(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    @Override
    @Step("{0} ingresa la información personal: Nombre: '#firstName', Apellido: '#lastName', Código Postal: '#postalCode'")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} está ingresando la información personal: Nombre: '{}', Apellido: '{}', Código Postal: '{}'",
                actor.getName(), firstName, lastName, postalCode);

        actor.attemptsTo(
                Enter.theValue(firstName).into(PersonalInfoPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(PersonalInfoPage.LAST_NAME_FIELD),
                Enter.theValue(postalCode).into(PersonalInfoPage.POSTAL_CODE_FIELD),
                Click.on(PersonalInfoPage.CONTINUE_BUTTON)
        );
    }

    public static AddPersonalInfoTask withData(String firstName, String lastName, String postalCode) {
        return Tasks.instrumented(AddPersonalInfoTask.class, firstName, lastName, postalCode);
    }
}
