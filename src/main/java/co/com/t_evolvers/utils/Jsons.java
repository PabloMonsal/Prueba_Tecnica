package co.com.t_evolvers.utils;

import java.util.List;
import java.util.Map;

public class Jsons {

    public Jsons() {
    }

    public static String jsonCrearLibro(List<Map<String, String>> data){
        return  "{\n" +
                "  \"firstname\" : \""+data.get(0).get("firstname")+"\",\n" +
                "  \"lastname\" : \""+data.get(0).get("lastname")+"\",\n" +
                "  \"totalprice\" : "+data.get(0).get("totalprice")+",\n" +
                "  \"depositpaid\" : "+data.get(0).get("depositpaid")+",\n" +
                "  \"bookingdates\" : {\n" +
                "    \"checkin\" : \""+data.get(0).get("checkin")+"\",\n" +
                "    \"checkout\" : \""+data.get(0).get("checkout")+"\" \n" +
                "  },\n" +
                "  \"additionalneeds\" : \""+data.get(0).get("additionalneeds")+"\" \n" +
                "}";
    }

    public static String jsonCrearUsuario(List<Map<String, String>> data){
        return  "{\n" +
                "  \"username\" : \""+data.get(0).get("username")+"\",\n" +
                "  \"password\" : \""+data.get(0).get("password")+"\"\n" +
                "}";
    }

}
