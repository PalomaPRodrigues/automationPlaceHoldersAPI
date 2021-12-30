package user;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.json.JSONException;
import org.json.JSONObject;

@Builder
@Data
@Setter
public class UserLombok {

    private String name;
    private String email;
    private String body;

    public JSONObject getJson() throws JSONException {
        return new JSONObject(new Gson().toJson(this));
    }

}
