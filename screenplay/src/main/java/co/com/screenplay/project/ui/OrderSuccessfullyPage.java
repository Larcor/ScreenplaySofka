package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;


public final class OrderSuccessfullyPage {

   private OrderSuccessfullyPage() {
   }

   public static final Target ORDER_SUCCESS_MESSAGE = Target.the("order success confirmation message")
         .locatedBy("#content h1");

   public static final Target CONTINUE_BUTTON = Target.the("continue shopping button")
         .locatedBy("a.btn.btn-primary");
}