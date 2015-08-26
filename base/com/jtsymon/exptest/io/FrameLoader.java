package com.jtsymon.exptest.io;

import com.jtsymon.exptest.impl.gui.Frame;
import com.jtsymon.exptest.impl.items.Text;
import com.jtsymon.exptest.items.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrameLoader {
    public static String escape (String src) {
        return src.replaceAll("\\\\", "\\\\\\\\").replaceAll("\n", "\\\\n");
    }
    public static String unescape (String src) {
        return src.replaceAll("\\\\n", "\n").replaceAll("\\\\\\\\", "\\\\");
    }
    public static String saveItem (Object first, Object... src) {
        StringBuilder sb = new StringBuilder();
        sb.append(first.toString()).append("\n");
        for (int i = 0; i < src.length; i++) {
            Object o = src[i];
            sb.append(" ");
            if (o instanceof Integer || o instanceof Long || o instanceof Double || o instanceof Float) {
                sb.append (o.toString());
            } else {
                sb.append (escape (o.toString()));
            }
            if (i < src.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static Item loadItem (String type, Scanner sc) {
        switch (type) {
            case "Text":
                Text item = new Text(sc.nextInt());
                item.setPosition(
                        sc.nextInt(),
                        sc.nextInt()
                );
                sc.nextLine();
                item.setFont(unescape(sc.nextLine().substring(1)), sc.nextInt());
                sc.nextLine();
                item.setText(unescape(sc.nextLine().substring(1)));
                return item;
        }
        return null;
    }

    public static Frame loadFrame (String filename) {
        Frame frame = new Frame();
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext()) {
                String type = sc.nextLine();
                if (type.startsWith(" ")) {
                    System.err.println ("Error in frame file: Expected start of item");
                    continue;
                }
                Item item = loadItem(type, sc);
                if (item != null) {
                    frame.addItem(item);
                } else {
                    System.err.println ("Error in frame file: Failed to parse item");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println ("Failed to open frame file");
        }
        return frame;
    }
}
