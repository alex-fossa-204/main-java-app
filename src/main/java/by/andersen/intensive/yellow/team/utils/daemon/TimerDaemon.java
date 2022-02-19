package by.andersen.intensive.yellow.team.utils.daemon;

import java.io.IOException;
import java.net.URL;

import by.andersen.intensive.yellow.team.utils.daemon.connector.HttpConnector;
import static by.andersen.intensive.yellow.team.utils.daemon.connector.constant.HttpMethod.*;

public class TimerDaemon extends Thread {

	@Override
	public void run() {
		while (true) {
			try {
				URL urlMail = new URL("http://35.203.40.103:8080/mail/run");
				HttpConnector httpConnectorMail = new HttpConnector(urlMail);
				httpConnectorMail.sendRequest(GET);
				
				
				URL urlTelegram = new URL("http://34.82.215.213:8080/telegram/run?command=create_pdf");
				HttpConnector httpConnectorTelegram = new HttpConnector(urlTelegram);
				httpConnectorTelegram.sendRequest(GET);
				
				Thread.sleep(24 * 60 * 60 * 1000 - 5000);
				
			} catch (IOException ioException) {
				System.out.println(ioException);
			} catch (InterruptedException interruptedException) {
				System.out.println(interruptedException);
			}
            
		}
	}
}
