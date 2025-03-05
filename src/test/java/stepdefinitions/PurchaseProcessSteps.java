package stepdefinitions;

import constantes.Constantes;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import screenplay.hook.OpenBrowser;
import screenplay.questions.PurchaseConfirmationQuestion;
import screenplay.tasks.*;
import static org.hamcrest.Matchers.is;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PurchaseProcessSteps {

    @Given("el usuario hace login con credenciales validas")
    public void elUsuarioHaceLoginConCredencialesValidas() {
        OnStage.theActorCalled("Usuario autorizado").attemptsTo(
                OpenBrowser.openURL(Constantes.WEB_URL),
                LoginTask.withCredentials("standard_user", "secret_sauce")
        );
    }

    @When("ordena los productos por criterio")
    public void ordenaLosProductosPorCriterio() {
        OnStage.theActorInTheSpotlight().attemptsTo(SortProductsTask.by("za"));
    }

    @And("agrega dos productos y elimina uno de ellos")
    public void agregaDosProductosYEliminaUnoDeEllos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProductsTask.toCart(List.of("Sauce Labs Backpack", "Sauce Labs Bike Light")),
                GoToCartTask.openCart(),
                RemoveProductTask.eliminarProducto("Sauce Labs Bike Light")
        );
    }

    @And("procede a confirmar la compra")
    public void procedeAConfirmarLaCompra() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToCheckoutTask.startCheckout(),
                AddPersonalInfoTask.withData("Sebastian", "Puerta", "12345"),
                CompletePurchaseTask.finalizeOrder()
        );
    }

    @Then("el usuario deberia recibir un mensaje de confirmacion")
    public void elUsuarioDeberiaRecebirUnMensajeDeConfirmacion() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(PurchaseConfirmationQuestion.isDisplayed(), is(true))
        );
    }
}
