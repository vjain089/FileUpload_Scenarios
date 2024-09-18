import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.support.events.EventFiringWebDriver

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.selenium.driver.CRemoteWebDriver

WebUI.openBrowser('')

WebUI.navigateToUrl('https://imgur.com/upload?beta')

EventFiringWebDriver driver = DriverFactory.getWebDriver()

WebDriver wrappedDriver = driver.getWrappedDriver()

if (wrappedDriver.class == CRemoteWebDriver) {
	wrappedDriver.setFileDetector(new LocalFileDetector())
}

def filePath = RunConfiguration.getProjectDir() + '/Katalon-Devices.JPG'

def filePath1 = RunConfiguration.getProjectDir() + '/Katalon-Devices 1.JPG'

def filePath2 = RunConfiguration.getProjectDir() + '/Katalon-Devices 2.JPG'

def concatenatedFilePath = (((filePath + '\n') + filePath1) + '\n') + filePath2

WebUI.uploadFileWithDragAndDrop(concatenatedFilePath)

WebUI.delay(10)

not_run: WebUI.closeBrowser()