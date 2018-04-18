package foxtrot.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

public class MyPageObject extends PageObject {

    @Step
    public List<String> texts(String locator){
        List<String> result=new ArrayList<>();
        findAll(locator).stream().forEach(webElement->{result.add(webElement.getText());});
        return result;
    }

    protected void clickOnWebElementJS(String xpath) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", findBy(xpath));
    }

    public void scrollIntoView(String xpath) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", findBy(xpath));
    }

    public void scrollIntoView(String xpath, int offset_y){
        int y = getDriver().findElement(net.serenitybdd.core.annotations.findby.By.xpath(xpath)).getLocation().getY() + offset_y;
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, " + y + ")");
    }

}
