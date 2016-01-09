package util;


import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by lcj on 15-6-13.
 */

public class JsonUtil {


    private static ObjectMapper jsonMapper = new ObjectMapper();

    public static <T> String writeObjectToJson(T t) {
        String json = "";
        try {
            json = jsonMapper.writeValueAsString(t);
        } catch (Exception e) {

        }
        return json;
    }
}
