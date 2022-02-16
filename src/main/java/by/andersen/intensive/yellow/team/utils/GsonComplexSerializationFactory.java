package by.andersen.intensive.yellow.team.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonComplexSerializationFactory {
	
	private static GsonBuilder gsonBuilder;
	
	private GsonComplexSerializationFactory() {
		gsonBuilder = new GsonBuilder();
		gsonBuilder.disableHtmlEscaping();
		gsonBuilder.enableComplexMapKeySerialization();
	}
	
	public static Gson getGsonInstance() {
		return gsonBuilder.create();
	}

}
