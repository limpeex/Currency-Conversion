package com.example.currencytranslator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;


abstract class ControllerAbstractions {
    String apiKey = "";
    Double rate;
    public void callAllMethods(ChoiceBox<String> choiceBox, String[] list, Label label) {
        choiceBox.getItems().addAll(list);
        choiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setText(choiceBox.getValue());
            }
        });
    }

    public double doWork(String endpoint, int value, String translated, Label label, ChoiceBox<String> box, TextField field) {
        try {
            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();
            System.out.println(response);
            JSONObject jsonResponse = new JSONObject(response.toString());
            rate = jsonResponse.getJSONObject("conversion_rates").getDouble(translated);  // TRY kuru
        } catch (Exception e) {
            e.printStackTrace();
        }
        label.setText((value*rate) + box.getValue());
        return (value * rate);



    }




}
