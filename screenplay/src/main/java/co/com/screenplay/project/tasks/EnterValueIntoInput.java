package co.com.screenplay.project.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterValueIntoInput implements Task {

    private final Target inputField;
    private final String value;
    private final boolean clearFirst;

    public EnterValueIntoInput(Target inputField, String value, boolean clearFirst) {
        this.inputField = inputField;
        this.value = value;
        this.clearFirst = clearFirst;
    }

    @Override
    @Step("{0} ingresa valor en el campo")
    public <T extends Actor> void performAs(T actor) {
        List<Performable> actions = new ArrayList<>();

        actions.add(WaitUntil.the(inputField, isVisible()));

        if (clearFirst) {
            actions.add(Clear.field(inputField));
        }

        actions.add(Enter.theValue(value).into(inputField));

        actor.attemptsTo(actions.toArray(new Performable[0]));
    }

    public static EnterValueIntoInput with(Target inputField, String value) {
        return new EnterValueIntoInput(inputField, value, true);
    }

    public static EnterValueIntoInput withoutClearing(Target inputField, String value) {
        return new EnterValueIntoInput(inputField, value, false);
    }

    public static EnterValueIntoInput appendedTo(Target inputField, String value) {
        return new EnterValueIntoInput(inputField, value, false);
    }
}