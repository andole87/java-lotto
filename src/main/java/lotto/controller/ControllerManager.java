package lotto.controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerManager {
    private static final Map<String, TicketController> controllers;

    static {
        controllers = new HashMap<>();
    }

    private ControllerManager() {

    }


}
