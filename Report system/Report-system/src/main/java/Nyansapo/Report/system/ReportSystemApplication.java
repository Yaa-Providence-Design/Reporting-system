package Nyansapo.Report.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

@SpringBootApplication
public class ReportSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportSystemApplication.class, args);

		Jedis jSubscriber = new Jedis();
		jSubscriber.subscribe(new JedisPubSub(){
			@Override
			public void onMessage(String channel, String message){
				System.out.println(message);
			}
		},"IBM", "TESLA");
	}
}
