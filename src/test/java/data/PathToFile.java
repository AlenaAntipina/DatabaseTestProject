package data;

import utils.PathUtils;

public enum PathToFile {
    PATH_TO_AVATAR("avatar.JPG");

    private String path;

    private PathToFile(String path) {
        this.path = path;
    }

    public String getPath() {
        return PathUtils.getAbsolutePath(path);
    }
}
