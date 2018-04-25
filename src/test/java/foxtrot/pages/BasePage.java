package foxtrot.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;


public class BasePage extends PageObject {

    protected List<String> texts(String locator){
        List<String> result=new ArrayList<>();
        findAll(locator).stream().forEach(webElement->{result.add(webElement.getText());});
        return result;
    }

    protected void clickOnWebElementJS(String xpath) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", findBy(xpath));
    }

    protected void scrollIntoView(String xpath) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", findBy(xpath));
    }

    protected void scrollIntoView(WebElementFacade webElementFacade) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", (WebElement)webElementFacade);
    }

    protected void scrollIntoView(String xpath, int offset_y){
        int y = getDriver().findElement(net.serenitybdd.core.annotations.findby.By.xpath(xpath)).getLocation().getY() + offset_y;
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, " + y + ")");
    }

    protected WebElementFacade moveTo(WebElementFacade webElementFacade){
        Actions actions=new Actions(getDriver());
        actions.moveToElement(webElementFacade);
        return webElementFacade;
    }

    protected WebElementFacade getWebElement(String xpathOrCss,String text) {
        List<String> webElementsText = texts(xpathOrCss);
        for (int i = 0; i < webElementsText.size(); i++) {
            if (webElementsText.get(i).equals(text)) {
                return findBy(xpathOrCss + "[" + (i+1) + "]");
            }
        }
        return null;
    }

    public String getCurrentURL(){
        return getDriver().getCurrentUrl();
    }


    public void clickOn(String xpathOrCss) {
        $(xpathOrCss).click();
    }
}
