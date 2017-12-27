package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.ArrayList;


public class Controller {

    @FXML
    private ComboBox<Station> comboBox;

    @FXML
    private ListView lets;

    dataReader dr = new dataReader();
    HashTables hashTable = new HashTables();

    public void dataPull() throws IOException {
        dr.readData();
        System.out.println("Done");
        ArrayList<Station> hash = dr.hash();
        for(Station s: hash){
            hashTable.put(s.getName(), s.getPcp());
        }
        ObservableList<Station> cbList2 = FXCollections.observableArrayList(hash);
        comboBox.setItems(cbList2);
    }

    public ArrayList similarity(String key){
        double bound = 1;
        double sum = 0.5;
        double x = hashTable.getVal(key);
        ArrayList gg = new ArrayList();
        for (int i = 0; i < hashTable.mSize; i++) {
            // Problem 1 Fixed so that it actually traverses
            if(hashTable.entrys[i] != null){
                double dist = Math.sqrt(sum + Math.pow(x - hashTable.entrys[i].getValue(), 2));
                if(dist < bound){
                    gg.add(hashTable.entrys[i].getKey() + " | " + hashTable.entrys[i].getValue());
                }
            }
        }
        return gg;
    }

    public void buttonPressed() {
        ArrayList pp = similarity(comboBox.getValue().getName());
        ObservableList cbList3 = FXCollections.observableArrayList(pp);
        lets.setItems(cbList3);
    }
}
