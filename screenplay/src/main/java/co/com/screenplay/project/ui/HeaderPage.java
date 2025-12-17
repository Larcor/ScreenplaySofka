package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;


public final class HeaderPage {

        private HeaderPage() {
        }

        public static final Target SHOPPING_CART = Target.the("shopping cart link")
                        .locatedBy("#cart-total");

        public static final Target CHECKOUT_LINK = Target.the("checkout link")
                        .locatedBy("a[title='Checkout']");

        public static final Target WISHLIST_LINK = Target.the("wishlist link")
                        .locatedBy("#wishlist-total");

        public static final Target MY_ACCOUNT_DROPDOWN = Target.the("my account dropdown")
                        .locatedBy("a[title='My Account']");
}