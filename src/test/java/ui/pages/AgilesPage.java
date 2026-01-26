package ui.pages;

import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

public class AgilesPage extends BaseSeleniumPage {

    public AgilesPage() {
        PageFactory.initElements(driver, this);
    }
}
