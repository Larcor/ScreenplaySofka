package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;

public final class CheckoutFormPage {

        private CheckoutFormPage() {
        }

        // Checkout Options
        public static final Target GUEST_CHECKOUT_RADIO = Target.the("guest checkout radio option")
                        .locatedBy("//label[contains(., 'Guest Checkout')]/input");

        public static final Target CONTINUE_BUTTON = Target.the("continue button")
                        .locatedBy("#button-account");

        // Billing Details
        public static final Target FIRSTNAME_INPUT = Target.the("first name input")
                        .locatedBy("#input-payment-firstname");

        public static final Target LASTNAME_INPUT = Target.the("last name input")
                        .locatedBy("#input-payment-lastname");

        public static final Target EMAIL_INPUT = Target.the("email input")
                        .locatedBy("#input-payment-email");

        public static final Target PHONE_INPUT = Target.the("phone input")
                        .locatedBy("#input-payment-telephone");

        public static final Target ADDRESS_INPUT = Target.the("address input")
                        .locatedBy("#input-payment-address-1");

        public static final Target CITY_INPUT = Target.the("city input")
                        .locatedBy("#input-payment-city");

        public static final Target POSTCODE_INPUT = Target.the("post code input")
                        .locatedBy("#input-payment-postcode");

        public static final Target PAYMENT_COUNTRY_DROPBOX = Target.the("payment country dropbox")
                        .locatedBy("#input-payment-country");

        public static final Target PAYMENT_ZONE_DROPBOX = Target.the("payment zone dropbox")
                        .locatedBy("#input-payment-zone");

        public static final Target BILLING_CONTINUE_BUTTON = Target.the("billing continue button")
                        .locatedBy("#button-guest");

        // Delivery Details
        public static final Target COMMENT_TEXTAREA = Target.the("comment textarea")
                        .locatedBy("textarea[name='comment'].form-control");

        public static final Target DELIVERY_CONTINUE_BUTTON = Target.the("delivery continue button")
                        .locatedBy("#button-shipping-method");

        // Payment Method
        public static final Target AGREE_CHECKBOX = Target.the("agree terms and conditions checkbox")
                        .locatedBy("//input[@name='agree']");

        public static final Target PAYMENT_CONTINUE_BUTTON = Target.the("payment continue button")
                        .locatedBy("#button-payment-method");

        // Confirm Order
        public static final Target CONFIRM_ORDER_BUTTON = Target.the("Confirm order button")
                        .locatedBy("#button-confirm");
}
