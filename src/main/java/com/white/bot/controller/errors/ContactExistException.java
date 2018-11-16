package com.white.bot.controller.errors;

import javax.ws.rs.BadRequestException;

public class ContactExistException extends BadRequestException {

    private static final long serialVerionUID = 1L;

    public ContactExistException() {
        super("Contact with such name and phone already exists!");
    }
}
