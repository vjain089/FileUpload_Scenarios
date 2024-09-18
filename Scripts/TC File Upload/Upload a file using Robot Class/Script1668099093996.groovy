import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://www.igniteui.com/file-upload/multiple-upload')

WebUI.maximizeWindow()

WebUI.clickOffset(findTestObject('OR File Upload/Page_Multiple Uploads Sample/input_Upload multiple_File'), 0, 0)

WebUI.callTestCase(findTestCase('TC File Upload/File Uplaod by Robot Class'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

WebUI.closeBrowser()