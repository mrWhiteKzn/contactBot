package com.white.bot.domain;

import com.white.bot.config.Constants;
import com.white.bot.controller.BotController;
import com.white.bot.controller.errors.ContactExistException;
import com.white.bot.service.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import static com.white.bot.config.Constants.*;


public class Bot extends AbilityBot {

    @Autowired
    private BotController botController;

    public Bot(String botToken, String botUsername, DefaultBotOptions botOptions) {
        super(botToken, botUsername, botOptions);
    }

    /**
     * The method receives messages from users.
     *
     * @param update
     */
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            if (message.getText().equals("/start")) {
                sendMsg(message, START_MESSAGE);
                return;
            }

            Command command = Utils.parseCommand(message.getText());
            switch (command.getType()) {
                case "save":
                    try {
                        Contact contact = botController.save(command);
                        sendMsg(message, contact.getName() + " " + SAVE_MESSAGE);
                    } catch (ContactExistException ex) {
                        sendMsg(message, ex.getMessage());
                    }
                    break;
                case "get":
                    Contact resultContact = botController.find(command);
                    String contactMessage = (resultContact == null) ? command.getName() + " " + NOT_FOUND_MESSAGE : resultContact.toString();
                    sendMsg(message, contactMessage);
                    break;
                case "edit":
                    botController.update(command);
                    sendMsg(message, command.getName() + " " + UPDATE_MESSAGE);
                    break;
                case "delete":
                    botController.delete(command);
                    sendMsg(message, command.getName() + " " + DELETE_MESSAGE);
                    break;
                default:
                    sendMsg(message, ERROR_TYPE_COMMAND);
            }
        }
    }

    /**
     * The method returns bots name.
     *
     * @return
     */
    public String getBotUsername() {
        return Constants.BOT_NAME;
    }

    public int creatorId() {
        return 0;
    }

    /**
     * The method returns bots token, used in communicating with a server.
     *
     * @return
     */
    public String getBotToken() {
        return Constants.BOT_TOKEN;
    }

    /**
     * The method sends message to a chat.
     *
     * @param message
     * @param text
     */
    public synchronized void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }
}
