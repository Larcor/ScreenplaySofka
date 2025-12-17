package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.screenplay.project.ui.OrderSuccessfullyPage.ORDER_SUCCESS_MESSAGE;

@Deprecated
public class TextValidationQuestions implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return TheText.of(ORDER_SUCCESS_MESSAGE).answeredBy(actor);
    }

    @Deprecated
    public static TextValidationQuestions text() {
        return new TextValidationQuestions();
    }
}