package org.example.javaotel.constant;

public class RestApis {
    private static final String VERSION = "/v1";
    private static final String API = "/api";
    private static final String DEVELOPER = "/dev";
    private static final String TEST = "/test";
    private static final String PROD = "/prod";

    private static final String ROOT = VERSION+ DEVELOPER;

    public static final String RESERVATION = ROOT+ "/reservation";
    public static final String ADD_RESERVATION = "/add-Reservation";
    
    public static final String ROOM = ROOT+ "/room";
    public static final String ADD_ROOM = "/add-Room";




}