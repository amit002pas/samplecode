

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;



   public class APICheck {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");

        headers.setAll(map);

        Map req_payload = new HashMap();
        req_payload.put("username", "akumar23");
        req_payload.put("password", "Aadiku@632");

        HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
        String url = "https://firemem.tools.yodlee.com/hammer/R/A/L";

        ResponseEntity<?> response = new RestTemplate().postForEntity(url, request, String.class);
        response.getBody();
      //  System.out.println(entityResponse.getData());
    }

}