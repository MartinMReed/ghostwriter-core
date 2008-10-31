package com.wss.ghostwriter.core.service;

public class CommunicationCode {

    public static final int NOP = 0;

    // network status
    public static final int TYPE_NETWORK_STATUS = 100;
    public static final int PING = TYPE_NETWORK_STATUS + 10;
    public static final int PONG = TYPE_NETWORK_STATUS + 20;

    // screen capture
    public static final int SCREEN_CAPTURE = 200;
    public static final int SCREEN_CAPTURE_REQUEST = SCREEN_CAPTURE + 10;
    public static final int SCREEN_CAPTURE_RESPONSE_A = SCREEN_CAPTURE + 20;
    public static final int SCREEN_CAPTURE_RESPONSE_B = SCREEN_CAPTURE + 30;

    // command
    public static final int TYPE_COMMAND = 300;
    public static final int MOUSE_MOVEMENT = TYPE_COMMAND + 10;
    public static final int MOUSE_PRESS = TYPE_COMMAND + 20;
    public static final int MOUSE_RELEASE = TYPE_COMMAND + 30;
    public static final int KEY_PRESS = TYPE_COMMAND + 40;
}
