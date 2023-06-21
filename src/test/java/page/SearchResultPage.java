package page;

import element.BaseElement;
import org.testng.Assert;

import static element.ElementUtils.find;

public class SearchResultPage {
    private final BaseElement cardProductItem = find(".search.results .product-item");

    public void productCardShouldDisplayed() {
        Assert.assertTrue(cardProductItem.isVisible());
    }
}
