package dataAccesLayer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;

public class apiDAO {

    public static void main(String[] args) {
        JSONObject p =getJsonOBJ("http://grp4.it3.diplomportal.dk//IT3_Delopgave_2_war/data/aftaler");
        System.out.println(p.toString(1));


    }

    static public JSONObject getJsonOBJ(String http) {
        JSONObject s = (XML.toJSONObject(getString(http)));
        return s;
    }

    static public String getString(String http) {
        String s = null;
        try {
            s = Unirest.get(http).asString().getBody();
            return s;
        } catch (UnirestException e) {
            e.printStackTrace();

            return null;
        }
    }
}
