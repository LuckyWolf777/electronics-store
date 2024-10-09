package com.example.electronicsstore.service.telegramBot;

import com.example.electronicsstore.config.telegram.BotConfig;
import com.example.electronicsstore.models.dto.ProductDto;
import com.example.electronicsstore.models.entity.Product;
import com.example.electronicsstore.service.product.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;
    private final ProductServiceImp service;
    private static String botState = "ON HOLD";

    @Autowired
    public TelegramBot(BotConfig botConfig, ProductServiceImp service) { //
        this.botConfig = botConfig;
        this.service = service;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();
            StringBuilder newMessageText = new StringBuilder("Привет " + "\n");
            if (botState.equals("WAITING")) {
                Product product = service.findById(Long.valueOf(message.getText()));
                newMessageText.append("Ваш товар: ").append(product);
                botState = "ON HOLD";
            }
            if (message.getText().contains("/getallproduct")) {
                newMessageText.append("Все продукты в базе данных: ");
                List<Product> products = service.getAllProducts();
                products.forEach(x -> newMessageText.append(x.toString()).append("\n"));
            } else if (message.getText().contains("/getid")) {
                newMessageText.append("Отправьте id товара который вам нужен");
                botState = "WAITING";

            } else if (message.getText().contains("/createproduct")) {
                Product product = new Product();
                Message message1 = update.getMessage();
                message1.getText().contains(product.getBrand());
                newMessageText.append("Для добавление товара введите следующие параметры: ");
                newMessageText.append(product);
//                botState = "WAITING";
            }
            sendMessage(chatId, newMessageText.toString());
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    private void sendMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendMessageReply(Long chatId, String text, Integer replyToMessageId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        message.setReplyToMessageId(replyToMessageId);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
