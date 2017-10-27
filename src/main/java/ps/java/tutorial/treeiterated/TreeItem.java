package ps.java.tutorial.treeiterated;

import java.io.File;

public class TreeItem {

    final private String prefix;

    final private File file;

    final private boolean inside;

    public TreeItem(final String prefix, final boolean inside, final File file) {
        this.prefix = prefix;
        this.file = file;
        this.inside = inside;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isInside() {
        return inside;
    }

    public File getFile() {
        return file;
    }

}
