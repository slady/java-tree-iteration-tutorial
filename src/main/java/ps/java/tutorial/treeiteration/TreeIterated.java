package ps.java.tutorial.treeiteration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TreeIterated {

    public static void main(final String... a) {
        final File root = new File(".");
        final List<TreeItem> treeItemList = new ArrayList<>();
        treeItemList.add(new TreeItem("", false, root));

        while (!treeItemList.isEmpty()) {
            final TreeItem treeItem = treeItemList.get(0);
            treeItemList.remove(0);

            System.out.println(treeItem.getPrefix()
                    + (treeItem.isInside() ? " +" : " `")
                    + treeItem.getFile().getName());

            final File[] files = treeItem.getFile().listFiles(File::isDirectory);

            if (files == null) {
                continue;
            }

            final int length = files.length;

            for (int i = 0; i < length; i++) {
                treeItemList.add(i, new TreeItem(treeItem.getPrefix() + (treeItem.isInside() ? " |" : "  "),
                        (i < length - 1), files[i]));
            }
        }
    }

}
