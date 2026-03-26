package tests.lint;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.LoginPage;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class LoginPageMetaTest {

    @Test(groups = "meta", description = "Линтинг xpath селекторов в логин пейдж")
    public void lintLoginPageSelectors() {
        LoginPage page = new LoginPage();
        Field[] fields = page.getClass().getDeclaredFields();
        List<String> errors = new ArrayList<>();

        for (Field field : fields) {

            if (field.isAnnotationPresent(FindBy.class)) {
                FindBy annotation = field.getAnnotation(FindBy.class);

                String xpathSelector = annotation.xpath();

                if (xpathSelector.contains("html") || xpathSelector.contains("body")) {
                    errors.add("Поле [" + field.getName() + "] использует абсолютный путь: " + xpathSelector);
                }

                if (xpathSelector.matches(".*(\\[\\d]).*")) {
                    errors.add("Поле [" + field.getName() + "] использует индекс (например, [1]): " + xpathSelector);
                }

                if (xpathSelector.contains("xpath: ''")) {
                    errors.add("Поле [" + field.getName() + "] пустое!");
                }
            }
        }


        if (!errors.isEmpty()) {
            Assert.fail("Найдены хрупкие локаторы в LoginPage:\n" + String.join("\n", errors));
        }
    }

}
