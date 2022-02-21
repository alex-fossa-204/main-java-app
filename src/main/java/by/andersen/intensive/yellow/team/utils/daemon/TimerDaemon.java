package by.andersen.intensive.yellow.team.utils.daemon;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import by.andersen.intensive.yellow.team.utils.daemon.connector.HttpConnector;
import static by.andersen.intensive.yellow.team.utils.daemon.connector.constant.HttpMethod.*;

public class TimerDaemon extends TimerTask {

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
				
				//Thread.sleep(24 * 60 * 60 * 1000 - 5000);
				
			} catch (IOException ioException) {
				System.out.println(ioException);
			}
		}
	}
	
    public void runTimer() {
        Calendar startDataTime = Calendar.getInstance();
        startDataTime.set(2022, 1, 21, 18, 00);
        Calendar currentTime = Calendar.getInstance();
        Date date = new Date();
        TimerTask timerTask = new TimerDaemon();
        Timer timer = new Timer();
        if (currentTime.getTime().compareTo(startDataTime.getTime()) < 0) {
            startDataTime.set(2022, date.getMonth(), date.getDay(), 18, 00);
        }
        timer.scheduleAtFixedRate(timerTask, startDataTime.getTimeInMillis() - currentTime.getTimeInMillis(), 24 * 60 * 60 * 1000);
    }
}
