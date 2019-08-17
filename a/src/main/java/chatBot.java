import static spark.Spark.*;

import java.util.Base64;

import org.json.simple.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.*;

public class chatBot {
	private String amount ="";
	private String billID = "";
	public static void enCode(String link) {
		String url = "https://gpcoder.com/4144-base64-encoding-va-decoding-trong-java-8/";
		String encodedUrl = Base64.getUrlEncoder().encodeToString(url.getBytes());
		System.out.println(encodedUrl);
		// aHR0cHM6Ly9ncGNvZGVyLmNvbS80MTQ0LWJhc2U2NC1lbmNvZGluZy12YS1kZWNvZGluZy10cm9uZy1qYXZhLTgv

		byte[] decodedBytes = Base64.getUrlDecoder().decode(encodedUrl);
		String decodedUrl = new String(decodedBytes);
		System.out.println(decodedUrl);
		// https://gpcoder.com/4144-base64-encoding-va-decoding-trong-java-8/
	}

	public static void main(String[] args) {
//        post("/hello", (req, res) -> {
//        	System.out.println(req.body() + "haha");
//        	return req.body();
//        });

		post("/", (req, res) -> {
			// var payload = req.body;
			// res.sendStatus(200);

			String body = req.body();
			System.out.println(body);

			SlackClient client = new SlackClient("xoxb-720128571077-722455947671-QhL8XOp2gxMWM7gFKHs8nlb0");

			// System.out.println(body.substring(body.indexOf("type") + 8));

//			  JSONParser jsonParser = new JSONParser();
//			  JSONObject json = (JSONObject) jsonParser.parse(body);
			JSONObject jo1 = new JSONObject(new JSONObject(req.body()).get("event").toString());
			// JSONObject jo2 = new JSONObject(jo1.get("event").toString());

			// System.out.println(jo2.get("type").toString()) ;
			if (jo1.get("type").toString().equals("app_mention")) {

				JSONObject jo = new JSONObject();
				jo.put("channel", "CM5JYT6CC");
				jo.put("text", "Bạn muốn mua gì?");

				// Replace with your Bot user Oauth Token. client.post(jo.toString());
				client.post(jo.toString());
			} else if (jo1.get("type").toString().equals("message")) {
				if (jo1.get("text").toString().contains("Xem ao")) {
//        			 JSONObject jo = new JSONObject(); 
//       			  jo.put("channel","CM5JYT6CC");
//       			  jo.put("text","1.Ao thun\n2.Ao ba lo");
//       			// SlackClient client = new SlackClient("xoxb-720128571077-722455947671-GX5fWo5rairpQkmf1n2m1PR7");
//   			  //Replace with your Bot user Oauth Token. client.post(jo.toString());
//   			  client.post(jo.toString());

					JSONObject jo2 = new JSONObject();
					jo2.put("channel", "CM5JYT6CC");
					JSONArray jsArr = new JSONArray();
					JSONObject objectJS = new JSONObject();
					objectJS.put("text", "1. Áo thun - 100.000 VND");
					objectJS.put("type", "image");
					objectJS.put("image_url", "https://i.imgur.com/oB6hBMA.jpg");
					jsArr.add(objectJS);

				
					JSONObject objectJS2 = new JSONObject();
					objectJS2.put("text", "2. Áo thun ngộ nghĩnh - 200.000 VND");
					objectJS2.put("type", "image");
					objectJS2.put("image_url", "https://i.imgur.com/U4iGx1j.jpg");
					jsArr.add(objectJS2);

					jo2.put("attachments", jsArr);
					jo2.put("text", "Chọn 1 hoặc 2");
					// jo2.put("text","1.Ao thun\n2.Ao ba lo");
					// SlackClient client = new
					// SlackClient("xoxb-720128571077-722455947671-GX5fWo5rairpQkmf1n2m1PR7");
					// Replace with your Bot user Oauth Token. client.post(jo.toString());
					client.post(jo2.toString());
				} else if (jo1.get("type").toString().equals("message")) {
					String i = "";
					if (jo1.get("text").toString().equals("1")) {
						//System.out.println("1");
						JSONObject jo3 = new JSONObject();
						String link = "https://api.qrserver.com/v1/create-qr-code/?size=250x250&data={output";
						//System.out.println("Link 1: " + link);
						enCode(link);
						//System.out.println("Link 2: " + link);
						JSONObject objectJS3 = new JSONObject();
						jo3.put("channel", "CM5JYT6CC");
						JSONArray jsArr1 = new JSONArray();
						objectJS3.put("text", "");
						objectJS3.put("type", "image");
						objectJS3.put("image_url", link);
						jsArr1.add(objectJS3);

						jo3.put("attachments", jsArr1);
						jo3.put("text", "Thanh toán");
						client.post(jo3.toString());
					}

				}
			}
			return body;
			// return body;
			// return req.body();

//			 if (req.body() === "app_mention") { if
//			 (payload.event.text.includes("tell me a joke")) { // Make call to
//			 chat.postMessage using bot's token } }

		});
	}
}
