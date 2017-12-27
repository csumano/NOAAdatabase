package sample;

import org.json.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class dataReader {

    public JSONObject json;

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        URL noa = new URL(url);
        URLConnection yc = noa.openConnection();
        yc.addRequestProperty("token", "drKyOQyMisGTZKhxdmvOxERdrbWEyGQV");
        BufferedReader rd = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String jsonText = readAll(rd);
        JSONObject json = new JSONObject(jsonText);
        return json;
    }

    public void readData() throws IOException, JSONException {
        json = readJsonFromUrl("https://www.ncdc.noaa.gov/cdo-web/api/v2/data?datasetid=GSOM&datatypeid=PRCP&units=standard&startdate=2016-01-01&enddate=2016-12-31&limit=1000");
    }

    public ArrayList<Station> hash() {
        JSONArray array = json.getJSONArray("results");
        ArrayList<Station> ssA = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            String station = array.getJSONObject(i).getString("station");
            Double value = array.getJSONObject(i).getDouble("value");
            Station s = new Station(station, value);
            ssA.add(s);
        }
        return ssA;
    }
}
