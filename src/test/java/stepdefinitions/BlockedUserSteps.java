package stepdefinitions;

import constantes.Constantes;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import screenplay.hook.OpenBrowser;
import screenplay.questions.BlockedUserQuestion;
import screenplay.tasks.LoginTask;
import static org.hamcrest.Matchers.is;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class BlockedUserSteps {

    @Given("el usuario se encuentra en la pagina de inicio de sesion")
    public void elUsuarioSeEncuentraEnLaPaginaDeInicioDeSesion(){
        OnStage.theActorCalled("Usuario no autorizado").attemptsTo(OpenBrowser.openURL(Constantes.WEB_URL));
    }

    @When("intenta hacer inicio de sesion con credenciales invalidas")
    public void intentaHacerInicioDeSesionConCredencialesInvalidas(){
        OnStage.theActorInTheSpotlight().attemptsTo(LoginTask.withCredentials("locked_out_user", "secret_sauce"));
    }

    @Then("el usuario deberia recibir un mensaje de error")
    public void elUsuarioDeberiaRecebirUnMensajeDeError(){
        OnStage.theActorInTheSpotlight().should(
                seeThat(BlockedUserQuestion.isDisplayed(), is(true)));

    }

}
