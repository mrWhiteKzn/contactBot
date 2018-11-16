package com.white.bot.service.util;

import com.white.bot.domain.Command;

/**
 * Utility class which can parse incoming message to {@link Command}.
 */
public class Utils {
    public static Command parseCommand(String messageText) {
        Command command = new Command();
        String words[] = messageText.split(" ");
        int wordsNumber = words.length;

        if (wordsNumber > 0 && words[0] != null && !words[0].isEmpty()) {
            command.setType(words[0]);
        }
        if (wordsNumber > 1 && words[1] != null && !words[1].isEmpty()) {
            command.setName(words[1]);
        }
        if (wordsNumber > 2 && words[2] != null && !words[2].isEmpty()) {
            command.setPhone(words[2]);
        }
        if (wordsNumber > 3 && words[3] != null && !words[3].isEmpty()) {
            command.setCompany(words[3]);
        }
        return command;
    }
}
