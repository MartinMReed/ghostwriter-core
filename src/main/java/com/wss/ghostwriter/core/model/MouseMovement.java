package com.wss.ghostwriter.core.model;

import m.java.util.Iterator;
import m.java.util.List;

import org.metova.mobile.util.text.Text;

public class MouseMovement {

    private static final String DELIMETER = ",";
    private static final String X = "X:";
    private static final String Y = "Y:";

    private int x;
    private int y;

    public MouseMovement(int x, int y) {

        setX( x );
        setY( y );
    }

    public String toString() {

        return X + getX() + DELIMETER + Y + getY();
    }

    public static MouseMovement fromString( String value ) throws Exception {

        int x = 0;
        int y = 0;

        List list = Text.getListFromXDelimitedString( value, DELIMETER );

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {

            String text = (String) iterator.next();

            if (text.startsWith( X )) {

                String substring = text.substring( X.length() );
                if (Text.isNull( substring ) == false) {

                    x = Integer.parseInt( substring );
                }
            }
            else if (text.startsWith( Y )) {

                String substring = text.substring( Y.length() );
                if (Text.isNull( substring ) == false) {

                    y = Integer.parseInt( substring );
                }
            }
        }

        return new MouseMovement( x, y );
    }

    public int getX() {

        return x;
    }

    private void setX( int x ) {

        this.x = x;
    }

    public int getY() {

        return y;
    }

    private void setY( int y ) {

        this.y = y;
    }
}
