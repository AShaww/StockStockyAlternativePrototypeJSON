package com.example.importjson;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> wineList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getJSON();
    }


    public void getJSON() {
        String json;
        try {
            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            JSONObject mainObj = new JSONObject(json);
            JSONArray jsonArray = mainObj.getJSONArray("Categories");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String wineType = obj.getString("Type");
                JSONArray winesList = obj.getJSONArray("Products");
                if (wineType.equals("White")) {
                    processWhiteWines(winesList);
                }
                Toast.makeText(getApplicationContext(), wineList.toString(), Toast.LENGTH_LONG).show();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    private void processWhiteWines(JSONArray wines) {
    for (int i = 0; i < wines.length(); i++)
    {

    }

    }
}
