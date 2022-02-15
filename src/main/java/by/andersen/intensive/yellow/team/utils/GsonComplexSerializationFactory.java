package by.andersen.intensive.yellow.team.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonComplexSerializationFactory {
	
	private GsonBuilder gsonBuilder;
	
	private GsonComplexSerializationFactory() {
		this.gsonBuilder = new GsonBuilder();
		gsonBuilder.disableHtmlEscaping();
		gsonBuilder.enableComplexMapKeySerialization();
	}
	
	public Gson getGsonInstance() {
		return gsonBuilder.create();
	}

}
