package by.andersen.intensive.yellow.team.utils.daemon.connector;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

import by.andersen.intensive.yellow.team.utils.daemon.connector.constant.HttpMethod;

public class HttpConnector implements Serializable{
	
	private static final long serialVersionUID = -5898315217138634798L;
	
	private HttpURLConnection httpURLConnection;
	
	public HttpConnector(URL url) throws IOException {
		super();
		this.httpURLConnection = (HttpURLConnection) url.openConnection();
		System.out.println("Connection Opened");
	}

	public void sendRequest(HttpMethod httpMethod) throws IOException {
		this.httpURLConnection.setRequestMethod(httpMethod.name());
		this.httpURLConnection.getInputStream();
		this.httpURLConnection.disconnect();
		System.out.println("Request sent");
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(httpURLConnection);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HttpConnector other = (HttpConnector) obj;
		return Objects.equals(httpURLConnection, other.httpURLConnection);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HttpConnector [httpURLConnection=");
		builder.append(httpURLConnection);
		builder.append("]");
		return builder.toString();
	}

}
