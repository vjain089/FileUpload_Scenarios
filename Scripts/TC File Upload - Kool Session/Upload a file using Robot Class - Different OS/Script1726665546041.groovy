import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.support.events.EventFiringWebDriver

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.selenium.driver.CRemoteWebDriver as CRemoteWebDriver

WebUI.openBrowser('https://www.igniteui.com/file-upload/multiple-upload')

WebUI.maximizeWindow()

EventFiringWebDriver driver = DriverFactory.getWebDriver()

WebDriver wrappedDriver = driver.getWrappedDriver()

if (wrappedDriver.class == CRemoteWebDriver) {
	wrappedDriver.setFileDetector(new LocalFileDetector())
}

WebUI.clickOffset(findTestObject('OR File Upload/Page_Multiple Uploads Sample/input_Upload multiple_File'), 0, 0)

WebUI.callTestCase(findTestCase('TC File Upload - Kool Session/File_Upload by Robot class- Diff OS'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

