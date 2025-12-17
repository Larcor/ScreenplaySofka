package co.com.screenplay.project.stepdefinitions.hook;

import co.com.screenplay.project.hook.OpenWeb;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hook {

        @Before
        public void setTheStage() {
                OnStage.setTheStage(new OnlineCast());
        }

        @Given("{string} abre el navegador")
        public void abreElNavegador(String actor) {
                OnStage.theActorCalled(actor).attemptsTo(
                                OpenWeb.browserURL());

                // Verifica que la página principal se cargó correctamente
                theActorInTheSpotlight().should(
                                GivenWhenThen.seeThat(
                                                TheWebPage.title(), Matchers.containsString("Your Store")));
        }
}
