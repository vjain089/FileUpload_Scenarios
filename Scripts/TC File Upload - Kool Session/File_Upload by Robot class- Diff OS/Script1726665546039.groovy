import java.awt.Robot as Robot
import java.awt.datatransfer.StringSelection as StringSelection
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.awt.*
import java.awt.datatransfer.Clipboard as Clipboard
import java.util.concurrent.TimeUnit as TimeUnit

String dirName = RunConfiguration.getProjectDir()

println('Project Directory: ' + dirName)

File file = new File(dirName + '/MyTestFile/TestData.xlsx')

StringSelection stringSelection = new StringSelection(file.getAbsolutePath())

Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard()

clipboard.setContents(stringSelection, null)

println(System.getProperty('os.name'))

if (System.getProperty('os.name').contains('Mac OS X')) {
    Robot robot = new Robot()

    //Copy to clipboard Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    // Robot robot = new Robot()
    // Cmd + Tab is needed since it launches a Java app and the browser looses focus
   /* robot.keyPress(KeyEvent.VK_META)

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
} else if (System.getProperty('os.name').contains('Window')) {
    Robot robot = new Robot()

    robot.delay(250)

    robot.keyPress(KeyEvent.VK_ENTER)

    robot.keyRelease(KeyEvent.VK_ENTER)

    robot.keyPress(KeyEvent.VK_CONTROL)

    robot.keyPress(KeyEvent.VK_V)

    robot.keyRelease(KeyEvent.VK_V)

    robot.keyRelease(KeyEvent.VK_CONTROL)

    robot.keyPress(KeyEvent.VK_ENTER)

    robot.delay(150)

    robot.keyRelease(KeyEvent.VK_ENTER)
} else {
    println('Please try Robot Keyword for Linux')
}