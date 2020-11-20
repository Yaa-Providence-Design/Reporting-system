package Nyansapo.Report.system.Publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class Application {

	public static void main(String[] args) { SpringApplication.run(Application.class, args);
		Jedis jedis = null;
		try{
			jedis = new Jedis();
			jedis.publish("IBM", "First message from IBM");
			jedis.publish("TESLA", "First message from TESLA");
		}catch (Exception e){
			System.out.println("Exception :" + e.getMessage());
		}finally {
			if (jedis!=null){
				jedis.close();
			}
		}
	}

}
