import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent

import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.support.events.EventFiringWebDriver

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.selenium.driver.CRemoteWebDriver




EventFiringWebDriver driver = DriverFactory.getWebDriver()

WebDriver wrappedDriver = driver.getWrappedDriver()

if (wrappedDriver.class == CRemoteWebDriver) {
	wrappedDriver.setFileDetector(new LocalFileDetector()) /*
*  Set the file detector for the remote web driver.
*
*  1. Initialize an EventFiringWebDriver using DriverFactory.
*  2. Get the wrapped WebDriver from the EventFiringWebDriver.
*  3. Check if the wrapped driver is an instance of CRemoteWebDriver and set the file detector to LocalFileDetector.
*
*/
}
//Must Read
//Before runnig this script copy the file path path you want to uplaod.

String dirName = RunConfiguration.getProjectDir()
println("Project Directory: "+dirName)

File file = new File(dirName+'/MyTestFile/TestData.xlsx')
StringSelection stringSelection = new StringSelection(file.getAbsolutePath())

Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
clipboard.setContents(stringSelection, null);

//Copy to clipboard Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
Robot robot = new Robot()

// Cmd + Tab is needed since it launches a Java app and the browser looses focus
/*robot.keyPress(KeyEvent.VK_META)

robot.keyPress(KeyEvent.VK_TAB)

robot.keyRelease(KeyEvent.VK_META)

robot.keyRelease(KeyEvent.VK_TAB)*/

robot.delay(5000)

//Open Goto window
robot.keyPress(KeyEvent.VK_META)

robot.keyPress(KeyEvent.VK_SHIFT)

robot.keyPress(KeyEvent.VK_G)

robot.keyRelease(KeyEvent.VK_META)

robot.keyRelease(KeyEvent.VK_SHIFT)

robot.keyRelease(KeyEvent.VK_G)

//Paste the clipboard value
robot.keyPress(KeyEvent.VK_META)

robot.keyPress(KeyEvent.VK_V)

robot.keyRelease(KeyEvent.VK_META)

robot.keyRelease(KeyEvent.VK_V)

//Press Enter key to close the Goto window and Upload window
robot.keyPress(KeyEvent.VK_ENTER)

robot.keyRelease(KeyEvent.VK_ENTER)

robot.delay(5000)

robot.keyPress(KeyEvent.VK_ENTER)

robot.keyRelease(KeyEvent.VK_ENTER)