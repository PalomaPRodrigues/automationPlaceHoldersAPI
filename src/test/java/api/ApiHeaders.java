package api;

import java.util.HashMap;
import java.util.Map;

public class ApiHeaders {
    protected static Map<String, String> headers = new HashMap<>();

    public Map<String, String> placeHeaders() {
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
