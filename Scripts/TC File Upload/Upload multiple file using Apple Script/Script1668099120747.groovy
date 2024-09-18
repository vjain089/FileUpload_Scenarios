import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://www.igniteui.com/file-upload/multiple-upload')

WebUI.maximizeWindow()

WebUI.clickOffset(findTestObject('OR File Upload/Page_Multiple Uploads Sample/input_Upload multiple_File'), 0, 0)

String dirName = RunConfiguration.getProjectDir()
println("Project Directory: "+dirName)

Runtime.getRuntime().exec('osascript ' + dirName+'/AppleScript/multiupload 2.scpt')

WebUI.delay(10)

//WebUI.closeBrowser()

