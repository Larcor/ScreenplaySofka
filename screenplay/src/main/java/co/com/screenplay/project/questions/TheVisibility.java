package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.targets.Target;


@Subject("la visibilidad del elemento")
public class TheVisibility implements Question<Boolean> {

    private final Target target;

    private TheVisibility(Target target) {
        this.target = target;
    }

    public static TheVisibility of(Target target) {
        return new TheVisibility(target);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).isVisible();
    }
}
