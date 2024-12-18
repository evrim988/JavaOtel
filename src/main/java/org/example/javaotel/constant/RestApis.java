package org.example.javaotel.constant;

public class RestApis {
    private static final String VERSION = "/v1";
    private static final String API = "/api";
    private static final String DEVELOPER = "/dev";
    private static final String TEST = "/test";
    private static final String PROD = "/prod";

    private static final String ROOT = VERSION+ DEVELOPER;

    public static final String RESERVATION = ROOT+ "/reservation";
    public static final String ROOM = ROOT+ "/room";
    public static final String ADMIN = ROOT+ "/admin";


    public static final String ADD_ROOM = "/add-room";
    public static final String ROOM_LIST = "/room-list";
    public static final String ROOM_UPDATE = "/room-update";
    public static final String ROOM_DELETE = "/room-delete";

    public static final String ADD_RESERVATION = "/add-Reservation";
    public static final String RESERVATION_LIST = "/reservation-list";
    public static final String RESERVATION_UPDATE = "/reservation-update";
    public static final String RESERVATION_DELETE = "/reservation-delete";

    public static final String ADMIN_LOGIN = "/admin-login";
    public static final String ADMIN_ADD = "/admin-add";
    public static final String GET_PROFILE = "/get-profile";

}