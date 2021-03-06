package com.hitg;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;

import com.hitg.domain.Country;
import com.hitg.handler.TravelBotHandlers;
import com.hitg.service.GoogleService;

@SpringBootApplication
public class BotEngineApplication {

	public static ApplicationContext CONTEXT;
	
	
	public static void main(String[] args) {
		CONTEXT= SpringApplication.run(BotEngineApplication.class, args);
		Country country = new Country();
		country.setName("Spain");
		country.setCode("ES");
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new TravelBotHandlers());
        } catch (TelegramApiException e) {
           
        }
	}
}
