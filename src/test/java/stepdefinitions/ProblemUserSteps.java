package stepdefinitions;

import constantes.Constantes;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import screenplay.hook.OpenBrowser;
import screenplay.questions.ImagesNotLoadedQuestion;
import screenplay.questions.PageTitleQuestion;
import screenplay.tasks.LoginTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class ProblemUserSteps {

    @Given("el usuario esta en la pagina de inicio de sesion")
    public void elUsuarioEstaEnLaPaginaDeInicioDeSesion(){
        OnStage.theActorCalled("Usuario con problemas").attemptsTo(OpenBrowser.openURL(Constantes.WEB_URL));
    }

    @When("intenta hacer inicio de sesion con credenciales con problemas")
    public void intentaHacerInicioDeSesionConCredencialesConProblemas(){
        OnStage.theActorInTheSpotlight().attemptsTo(LoginTask.withCredentials("problem_user", "secret_sauce"));
    }

    @Then("el usuario deberia ser redirigido a la pagina de productos")
    public void elUsuarioDeberiaSerRedirigidoALaPaginaDeProductos(){
        OnStage.theActorInTheSpotlight().should(
                seeThat(PageTitleQuestion.isDisplayed(), is(true)));
    }

    @And("las imagenes de los productos no deberian estar cargadas")
    public void lasImagenesDeLosProductosNoDeberianEstarCargadas(){
        OnStage.theActorInTheSpotlight().should(
                seeThat(ImagesNotLoadedQuestion.areBroken(), is(true)));
    }

}
