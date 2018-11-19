package com.white.bot.config;

public class Constants {
    private Constants() {
    }

    public static final String BOT_NAME = "PersonsFinderBot";
    public static final String BOT_TOKEN = "724772737:AAElBAeskZijjTekctL-D4VTIE9nxHdSabE";

    public static final String PROXY_HOST = "176.118.55.245";
    public static final Integer PROXY_PORT = 38861;

    public static final String START_MESSAGE = "Welcome to personal contact book service." + "\n" +
            "To save a contact: save <name> <phone number> <company>" + "\n" +
            "To get contact: get <name>" + "\n" +
            "To edit contact: edit <name> <phone number> <new company>" + "\n" +
            "To delete contact: delete <name> <phone>";
    public static final String ERROR_TYPE_COMMAND = "The command is not recognized. To save a person write: save <name> <phone number> <company>.";

    public static final String SAVE_MESSAGE = "is saved";
    public static final String UPDATE_MESSAGE = "is updated";
    public static final String DELETE_MESSAGE = "is deleted";
    public static final String NOT_FOUND_MESSAGE = "not found";
}
