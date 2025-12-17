package co.com.screenplay.project.tasks;

import co.com.screenplay.project.ui.HeaderPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class NavigateTo implements Task {

    private final Target menuItem;
    private final String description;

    public NavigateTo(Target menuItem, String description) {
        this.menuItem = menuItem;
        this.description = description;
    }

    @Override
    @Step("{0} navega a {1}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(menuItem, isClickable()),
                Click.on(menuItem));
    }

    public static NavigateTo theShoppingCart() {
        return instrumented(NavigateTo.class, HeaderPage.SHOPPING_CART, "Shopping Cart");
    }

    @Deprecated
    public static NavigateTo open() {
        return theShoppingCart();
    }
    public static NavigateTo element(Target target, String name) {
        return instrumented(NavigateTo.class, target, name);
    }

    @Override
    public String toString() {
        return description;
    }
}