import static spark.Spark.*;

public class chatBot {
	public static void main(String[] args) {
        post("/hello", (req, res) -> {
        	System.out.println(req.body());
        	return req.body();
        });
    }
}
