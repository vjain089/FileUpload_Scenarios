import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.support.events.EventFiringWebDriver

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.selenium.driver.CRemoteWebDriver

WebUI.openBrowser('https://www.igniteui.com/file-upload/multiple-upload')

WebUI.maximizeWindow()

EventFiringWebDriver driver = DriverFactory.getWebDriver()

WebDriver wrappedDriver = driver.getWrappedDriver()

if (wrappedDriver.class == CRemoteWebDriver) {
	wrappedDriver.setFileDetector(new LocalFileDetector())
}

WebUI.delay(5)

String dirName = RunConfiguration.getProjectDir()

println('Project Directory: ' + dirName)

WebUI.sendKeys(findTestObject('OR File Upload/Page_Multiple Uploads Sample/input_Upload multiple_File'), ((dirName + '/MyTestFile/TestData.xlsx \n') + 
    dirName) + '/MyTestFile/DDT.xlsx')

WebUI.delay(5)

WebUI.click(findTestObject('OR File Upload/Page_Multiple Uploads Sample/btn_Upload'))

not_run: WebUI.closeBrowser()

