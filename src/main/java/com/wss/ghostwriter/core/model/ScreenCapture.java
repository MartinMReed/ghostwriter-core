package com.wss.ghostwriter.core.model;

import m.java.util.Iterator;
import m.java.util.List;

import org.metova.mobile.util.text.Text;

public class ScreenCapture {

    private static final String DELIMETER = ",";
    private static final String WIDTH = "W:";
    private static final String HEIGHT = "H:";

    private int width;
    private int height;

    public ScreenCapture(int width, int height) {

        setWidth( width );
        setHeight( height );
    }

    public String toString() {

        return WIDTH + getWidth() + DELIMETER + HEIGHT + getHeight();
    }

    public static ScreenCapture fromString( String value ) throws Exception {

        int width = 0;
        int height = 0;

        List list = Text.getListFromXDelimitedString( value, DELIMETER );

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {

            String text = (String) iterator.next();

            if (text.startsWith( WIDTH )) {

                String substring = text.substring( WIDTH.length() );
                if (Text.isNull( substring ) == false) {

                    width = Integer.parseInt( substring );
                }
            }
            else if (text.startsWith( HEIGHT )) {

                String substring = text.substring( HEIGHT.length() );
                if (Text.isNull( substring ) == false) {

                    height = Integer.parseInt( substring );
                }
            }
        }

        return new ScreenCapture( width, height );
    }

    public int getWidth() {

        return width;
    }

    private void setWidth( int width ) {

        this.width = width;
    }

    public int getHeight() {

        return height;
    }

    private void setHeight( int height ) {

        this.height = height;
    }
}
