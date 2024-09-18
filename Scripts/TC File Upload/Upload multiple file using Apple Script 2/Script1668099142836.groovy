import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_multiple')

WebUI.maximizeWindow()

WebUI.switchToFrame(findTestObject('OR File Upload/File_upload W3school/iframe_switch'), 5)

WebUI.clickOffset(findTestObject('OR File Upload/File_upload W3school/Click_FileUpload'), 0, 0)

String dirName = RunConfiguration.getProjectDir()
println("Project Directory: "+dirName)

Runtime.getRuntime().exec('osascript ' + dirName+'/AppleScript/multiupload 2.scpt')

WebUI.delay(10)

//WebUI.closeBrowser()

