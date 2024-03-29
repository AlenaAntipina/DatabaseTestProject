package utils;

import aquality.selenium.core.logging.Logger;

import java.io.File;
import java.net.URISyntaxException;

public class PathUtils {
    public static String getAbsolutePath(String filename) {
        try {
            return new File(PathUtils.class.getResource("/" + filename).toURI()).getAbsolutePath();
        } catch (URISyntaxException e) {
            Logger.getInstance().error("RuntimeException: " + e);
            return null;
        }
    }
}
