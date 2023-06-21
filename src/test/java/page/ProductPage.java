package page;

import element.BaseElement;

import static element.ElementUtils.find;

public class ProductPage {
    private final BaseElement productTitle = find(".product-info-main [itemprop=name]");

    public ProductPage productTitleShouldDisplayed() {
        productTitle.isVisible();
        // Print the product title
        System.out.println(productTitle.getText());
        return this;
    }
}
