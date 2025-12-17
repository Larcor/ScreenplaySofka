package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.targets.Target;


@Subject("el texto del elemento")
public class TheText implements Question<String> {

    private final Target target;

    private TheText(Target target) {
        this.target = target;
    }

    public static TheText of(Target target) {
        return new TheText(target);
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveFor(actor).getText().trim();
    }
}
