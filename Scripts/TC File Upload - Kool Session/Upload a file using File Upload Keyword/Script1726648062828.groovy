import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('http://demo.guru99.com/test/upload/')

WebUI.delay(5)

String dirName = RunConfiguration.getProjectDir()

println('Project Directory: ' + dirName)

WebUI.uploadFile(findTestObject('OR File Upload/Page_File Upload Demo/input_Page-6_uploadfile_0'), dirName + '/MyTestFile/TestData.xlsx')

WebUI.delay(5)

WebUI.click(findTestObject('OR File Upload/Page_File Upload Demo/input_I accept_terms (1)'))

WebUI.click(findTestObject('OR File Upload/Page_File Upload Demo/button_Submit File (1)'))

WebUI.verifyElementPresent(findTestObject('OR File Upload/Page_File Upload Demo/center_1 file has been successfully uploaded'), 
    2)

WebUI.delay(5)

not_run: WebUI.closeBrowser()

