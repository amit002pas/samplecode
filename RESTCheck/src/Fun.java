import org.springframework.web.client.RestTemplate;

import client.User;

public class Fun {
	public static void main(String[] args) {
		String url="https://firemem.tools.yodlee.com/hammer/R/A/L";
		String username="akumar23";
		String password="Aadiku@632";
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		RestTemplate restTemplate=new RestTemplate();
		
		System.out.println(restTemplate.postForObject(url, user, User.class));
		
	}

}
