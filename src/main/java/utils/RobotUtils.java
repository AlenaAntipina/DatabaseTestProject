package utils;

import aquality.selenium.core.logging.Logger;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.AWTException;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotUtils {

    private RobotUtils() {
    }

    public static void uploadFile(String path) {
        try{
            StringSelection image = new StringSelection(path);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(image, null);

            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
        catch (AWTException exception){
            Logger.getInstance().error(exception.getMessage());
        }
    }
}