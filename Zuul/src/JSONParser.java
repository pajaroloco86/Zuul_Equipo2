import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {
    JSONObject fileData;

    JSONParser(String path) throws Exception{
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

    public String[] getRooms(){
        return JSONObject.getNames(fileData);
    }

    public String[] getTogetherRooms(String roomKey) throws JSONException{
        String[] roomsTogetherNames = new String[4];
        JSONObject room = fileData.getJSONObject(roomKey);
        roomsTogetherNames[0] = room.getString("northRoom");
        roomsTogetherNames[1] = room.getString("eastRoom");
        roomsTogetherNames[2] = room.getString("westRoom");
        roomsTogetherNames[3] = room.getString("southRoom");
        return roomsTogetherNames;
    }
}
