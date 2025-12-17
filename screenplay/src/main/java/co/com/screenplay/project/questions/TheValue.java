package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.targets.Target;


@Subject("el valor del campo")
public class TheValue implements Question<String> {

    private final Target target;

    private TheValue(Target target) {
        this.target = target;
    }

    public static TheValue of(Target target) {
        return new TheValue(target);
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveFor(actor).getValue().trim();
    }
}
