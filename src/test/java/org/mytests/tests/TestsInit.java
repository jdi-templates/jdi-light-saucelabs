package org.mytests.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import org.mytests.uiobjects.example.site.SiteJdi;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.elements.init.InitActions.INTERFACES;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static org.mytests.uiobjects.example.site.SiteJdi.homePage;

public class TestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        INTERFACES.update(IsCombobox.class, DataListOptions.class);
        initSite(SiteJdi.class);
        homePage.open();
        logger.info("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }
}
