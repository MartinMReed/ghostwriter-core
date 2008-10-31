package com.wss.ghostwriter.core.model;

import m.java.util.List;

import org.metova.mobile.util.Base64;
import org.metova.mobile.util.text.Text;

public class Message {

    private static final String DELIMETER = ",";

    private int code;
    private String value;

    public Message(int code) {

        this( code, null );
    }

    public Message(int code, String value) {

        setCode( code );
        setValue( ( value != null ) ? value : "" );
    }

    public byte[] toPacket() {

        String encodedValue = new String( Base64.encode( getValue().getBytes() ) );
        return ( getCode() + DELIMETER + encodedValue ).getBytes();
    }

    public static Message fromPacket( byte[] data, int offset, int length ) {

        return fromPacket( new String( data, offset, length ) );
    }

    public static Message fromPacket( String packet ) {

        List list = Text.getListFromXDelimitedString( packet, DELIMETER );

        int code = Integer.parseInt( (String) list.get( 0 ) );

        if (list.size() > 1) {

            String value = new String( Base64.decode( ( (String) list.get( 1 ) ).getBytes() ) );
            return new Message( code, value );
        }

        return new Message( code );
    }

    public int getCode() {

        return code;
    }

    private void setCode( int code ) {

        this.code = code;
    }

    public String getValue() {

        return value;
    }

    private void setValue( String value ) {

        this.value = value;
    }
}
