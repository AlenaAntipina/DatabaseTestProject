package internet;

import utils.JsonUtils;
import utils.PathUtils;

public class InternetPage {
    private static String path = PathUtils.getAbsolutePath("internetPage.json");

    private InternetPage() {
    }

    public static void setPath(String path) {
        InternetPage.path = path;
    }

    public static String getMainUrl() {
        return JsonUtils.getStringData(FieldInJsonInternetPage.MAIN_URL.getUrl(), path);
    }
}
