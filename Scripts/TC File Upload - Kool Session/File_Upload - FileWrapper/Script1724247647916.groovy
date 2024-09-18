import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.remote.LocalFileDetector as LocalFileDetector
import org.openqa.selenium.support.events.EventFiringWebDriver as EventFiringWebDriver
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.selenium.driver.CRemoteWebDriver as CRemoteWebDriver

WebUI.openBrowser('')

WebUI.maximizeWindow()

EventFiringWebDriver driver = DriverFactory.getWebDriver()

WebDriver wrappedDriver = driver.getWrappedDriver()

if (wrappedDriver.class == CRemoteWebDriver) {
    wrappedDriver.setFileDetector(new LocalFileDetector())
}

String dirName = RunConfiguration.getProjectDir()

println('Project Directory: ' + dirName)

String filePath = new File((RunConfiguration.getProjectDir() + '/') + 'MyTestFile/Technical Proposal Template V.1 (2) (002).docx').getCanonicalPath()

WebUI.navigateToUrl('https://www.filemail.com')

WebUI.click(findTestObject('OR File Upload/Page_Send Large Files Free - Fast Secure File Transfer - Filemail/a_Log in'))

WebUI.setText(findTestObject('OR File Upload/Page_Login - Filemail - Filemail/input_Email_Email'), 'vjain089@gmail.com')

WebUI.setEncryptedText(findTestObject('OR File Upload/Page_Login - Filemail - Filemail/input_Password_Password'), 'l4rHfn9ZkQZikqoROYKz3g==')

WebUI.click(findTestObject('OR File Upload/Page_Login - Filemail - Filemail/button_Log in'))

WebUI.delay(2)

WebUI.setText(findTestObject('OR File Upload/Page_Hub - Filemail/input_Transfer in progress_ui-widget-conten_9e29d3'), 'vaibhav.jain@katalon.com')

WebUI.click(findTestObject('OR File Upload/Page_Hub - Filemail/div_Send as emailSend as linkTransfer in pr_17b1aa'))

WebUI.setText(findTestObject('OR File Upload/Page_Hub - Filemail/input_Transfer in progress_FilemailSubject'), 'Demo')

WebUI.uploadFile(findTestObject('OR File Upload/Page_Hub - Filemail/label_Add Files'), filePath)

WebUI.delay(5)

WebUI.scrollToElement(findTestObject('OR File Upload/Page_Hub - Filemail/button_Send'), 0)

WebUI.click(findTestObject('OR File Upload/Page_Hub - Filemail/button_Send'))

WebUI.delay(2)

//WebUI.click(findTestObject('OR File Upload/Page_Hub - Filemail/button_Send_1'))
//WebUI.verifyElementText(findTestObject('OR File Upload/Page_Hub - Filemail/h3_Files transferred'), 'Files transferred!')
not_run: WebUI.click(findTestObject('OR File Upload/Page_Hub - Filemail/a_Log out'))

not_run: WebUI.click(findTestObject('OR File Upload/Page_Hub - Filemail/button_Yes'))

