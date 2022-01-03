package api;

import java.util.HashMap;
import java.util.Map;

public class ApiParams {

    protected static Map<String,String> params = new HashMap<>();

    public Map<String,String> placeParams(){
    params.put("postId","");

    return params;
    }
}
