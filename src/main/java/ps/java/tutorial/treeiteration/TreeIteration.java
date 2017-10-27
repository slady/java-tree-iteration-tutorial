package ps.java.tutorial.treeiteration;

import java.io.File;
import java.util.Stack;

public class TreeIteration {

    public static void main(final String... a) {
        final File root = new File(".");
        final Stack<TreeItem> treeItemList = new Stack<>();
        treeItemList.push(new TreeItem("", false, root));

        while (!treeItemList.isEmpty()) {
            final TreeItem treeItem = treeItemList.pop();

            System.out.println(treeItem.getPrefix()
                    + (treeItem.isInside() ? " +" : " `")
                    + treeItem.getFile().getName());

            final File[] files = treeItem.getFile().listFiles(File::isDirectory);

            if (files == null) {
                continue;
            }

            final int length = files.length;

            for (int i = 0; i < length; i++) {
                treeItemList.push(new TreeItem(treeItem.getPrefix() + (treeItem.isInside() ? " |" : "  "),
                        (i > 0), files[i]));
            }
        }
    }

}
