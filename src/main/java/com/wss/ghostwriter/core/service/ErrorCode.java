package com.wss.ghostwriter.core.service;

public class ErrorCode {

    // server connection
    public static final int TYPE_SERVER_CONNECTION = 100;
    public static final int INSTANTIATION = TYPE_SERVER_CONNECTION + 10;

    public static final String getText( int errno ) {

        switch (errno) {

            case INSTANTIATION:
                return "Unable to instantiate server connection";
            case TYPE_SERVER_CONNECTION:
                return "Unknown server connection error";
            default:
                return null;
        }
    }
}
