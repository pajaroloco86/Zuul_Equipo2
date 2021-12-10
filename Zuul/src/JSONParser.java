import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSONParser {
    JSONObject fileData;

    JSONParser(String path) throws Exception {
        this.fileData = getFileData(path);
    }

    private JSONObject getFileData(String path) throws Exception {
        String text = "", line;
        File file = new File(path);
        if (!file.exists()) {
            throw new Exception("Archivo no encontrado");
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));

        while ((line = reader.readLine()) != null) {
            text += line;
        }
        reader.close();

        JSONObject JSON;
        try {
            JSON = new JSONObject(text);
        } catch (JSONException e) {
            throw new Exception("Error en el formato JSON");
        }
        return JSON;
    }

    public String[] getRoomsKeys() {
        return JSONObject.getNames(fileData);
    }

    public String[] getTogetherRooms(String roomKey) throws JSONException {
        String[] roomsTogetherNames = new String[4];
        JSONObject room = fileData.getJSONObject(roomKey);
        roomsTogetherNames[0] = room.getString("northRoom");
        roomsTogetherNames[1] = room.getString("eastRoom");
        roomsTogetherNames[2] = room.getString("westRoom");
        roomsTogetherNames[3] = room.getString("southRoom");
        return roomsTogetherNames;
    }

    public String getRoomDescription(String roomKey) throws JSONException {
        JSONObject room = fileData.getJSONObject(roomKey);
        return (String) room.getString("description");
    }

    @Test
    public void testMapParser() throws Exception{
        String jsonText = "{\"outside\":{\"description\":\"outside, the main entrance of the university.\", \"northRoom\": null,\"eastRoom\":\"theatre\",\"westRoom\":\"pub\",\"southRoom\":\"lab\"},";
        jsonText += "\"theatre\":{\"description\":\"in a lecture theatre\", \"northRoom\": null,\"eastRoom\": null,\"westRoom\":\"outside\",\"southRoom\": null},";
        jsonText += "\"pub\":{\"description\":\"in the campus pub\", \"northRoom\": null,\"eastRoom\":\"outside\",\"westRoom\": null,\"southRoom\": null},";
        jsonText += "\"lab\":{\"description\":\"in a computing lab\", \"northRoom\": \"outside\",\"eastRoom\": \"office\",\"westRoom\": null,\"southRoom\":null},";
        jsonText += "\"office\":{\"description\":\"in the computing admin office\", \"northRoom\": null,\"eastRoom\": null,\"westRoom\": \"lab\",\"southRoom\":null}";
        jsonText += "}";

        Assert.assertTrue(new JSONObject(jsonText).equals(getFileData("src/Example.json")));
    }
}
