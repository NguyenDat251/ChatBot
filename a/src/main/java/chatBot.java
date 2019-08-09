import static spark.Spark.*;

import org.json.JSONObject;
import org.json.simple.parser.*;


public class chatBot {
	public static void main(String[] args) {
//        post("/hello", (req, res) -> {
//        	System.out.println(req.body() + "haha");
//        	return req.body();
//        });
        
        post("/", (req, res)->{
            //var payload = req.body;
            //res.sendStatus(200);
        	
        	String body = req.body(); 
        	System.out.println(body);
        	
        	
        	//System.out.println(body.substring(body.indexOf("type") + 8));
			
//			  JSONParser jsonParser = new JSONParser();
//			  JSONObject json = (JSONObject) jsonParser.parse(body);
        	JSONObject jo1 = new JSONObject(new JSONObject(req.body()).get("event").toString());
        	//JSONObject jo2 = new JSONObject(jo1.get("event").toString());
        	
        	//System.out.println(jo2.get("type").toString()) ;
        	if(jo1.get("type").toString().equals("app_mention")) {
			 
			  JSONObject jo = new JSONObject(); 
			  jo.put("channel","CM5JYT6CC");
			  jo.put("text","Hello, world");
			 
			  SlackClient client = new SlackClient("xoxb-720128571077-722455947671-GX5fWo5rairpQkmf1n2m1PR7");
			  //Replace with your Bot user Oauth Token. client.post(jo.toString());
			  client.post(jo.toString());
        	}
        	else if(jo1.get("type").toString().equals("message")) {
        		if(jo1.get("text").toString().contains("Xem ao")) {
        			 JSONObject jo = new JSONObject(); 
       			  jo.put("channel","CM5JYT6CC");
       			  jo.put("text","1.Ao thun\n2.Ao ba lo");
       			 SlackClient client = new SlackClient("xoxb-720128571077-722455947671-GX5fWo5rairpQkmf1n2m1PR7");
   			  //Replace with your Bot user Oauth Token. client.post(jo.toString());
   			  client.post(jo.toString());
        		}
        	}
			  return jo1.toString();
        	//return body;
        	//return req.body();
			
//			 if (req.body() === "app_mention") { if
//			 (payload.event.text.includes("tell me a joke")) { // Make call to
//			 chat.postMessage using bot's token } }
			 
        });
    }
}
