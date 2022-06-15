package Handlers;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import static Handlers.DatabaseHandler.getData;
import static Handlers.DatabaseHandler.setData;
import static Handlers.Login.getLoggedInUser;

public class SubmissionHandler {



    public static void submissionHandler(TextField benzineAuto, TextField dieselAuto, TextField elecAuto, TextField OV, TextField vliegtuig, TextField hybridAuto){

        String totalBenzineAutoKM = getData("BenzineAutoKM", getLoggedInUser());
        String totalDieselAutoKM = getData("DieselAutoKM", getLoggedInUser());
        String totalElecAutoKM = getData("ElecAutoKM", getLoggedInUser());
        String totalOVKM = getData("OVKM", getLoggedInUser());
        String totalVliegtuigKM = getData("VliegtuigKM", getLoggedInUser());
        String totalHybridAutoKM = getData("HybridAutoKM", getLoggedInUser());


        if ((!(benzineAuto.getText() == null)) && (!benzineAuto.getText().equals(""))){
            totalBenzineAutoKM = String.valueOf(Integer.parseInt(benzineAuto.getText()) + Integer.parseInt(getData("BenzineAutoKM", getLoggedInUser())));
        }
        if (!(dieselAuto.getText() == null) && !dieselAuto.getText().equals("")){
            totalDieselAutoKM = String.valueOf(Integer.parseInt(dieselAuto.getText()) + Integer.parseInt(getData("DieselAutoKM", getLoggedInUser())));
        }
        if (!(elecAuto.getText() == null) && !(elecAuto.getText().equals(""))){
            totalElecAutoKM = String.valueOf(Integer.parseInt(elecAuto.getText()) + Integer.parseInt(getData("ElecAutoKM", getLoggedInUser())));
        }
        if (!(OV.getText() == null) && !OV.getText().equals("")){
            totalOVKM = String.valueOf(Integer.parseInt(OV.getText()) + Integer.parseInt(getData("OVKM", getLoggedInUser())));
        }
        if (!(vliegtuig.getText() == null) && !vliegtuig.getText().equals("")){
            totalVliegtuigKM = String.valueOf(Integer.parseInt(vliegtuig.getText()) + Integer.parseInt(getData("VliegtuigKM", getLoggedInUser())));
        }
        if (!(hybridAuto.getText() == null) && !hybridAuto.getText().equals("")){
            totalHybridAutoKM = String.valueOf(Integer.parseInt(hybridAuto.getText()) + Integer.parseInt(getData("HybridAutoKM", getLoggedInUser())));
        }

        setData("BenzineAutoKM", totalBenzineAutoKM, getLoggedInUser());
        setData("DieselAutoKM", totalDieselAutoKM, getLoggedInUser());
        setData("ElecAutoKM", totalElecAutoKM, getLoggedInUser());
        setData("OVKM", totalOVKM, getLoggedInUser());
        setData("VliegtuigKM", totalVliegtuigKM, getLoggedInUser());
        setData("HybridAutoKM", totalHybridAutoKM, getLoggedInUser());
    }
    public static void formList(ListView<String> nameListView, ListView<String> KMListView, ListView<String> pointsListView) {
        nameListView.getItems().clear();
        KMListView.getItems().clear();
        pointsListView.getItems().clear();

        String[] punten = {"50pt", "45pt", "40pt", "30pt", "10pt"};

        String totalBenzineAutoKM = getData("BenzineAutoKM", getLoggedInUser());
        String totalDieselAutoKM = getData("DieselAutoKM", getLoggedInUser());
        String totalElecAutoKM = getData("ElecAutoKM", getLoggedInUser());
        String totalOVKM = getData("OVKM", getLoggedInUser());
        String totalVliegtuigKM = getData("VliegtuigKM", getLoggedInUser());
        String totalHybridAutoKM = getData("HybridAutoKM", getLoggedInUser());

        String[] names = {"Benzine Auto","Diesel Auto", "Elektrische Auto", "Openbaar Vervoer", "Vliegtuig", "Hybride Auto"};
        String[] km = {totalBenzineAutoKM + " km", totalDieselAutoKM + " km",totalElecAutoKM + " km",totalOVKM + " km",totalVliegtuigKM + " km",totalHybridAutoKM + " km"};

        nameListView.getItems().addAll(names);
        KMListView.getItems().addAll(km);
        pointsListView.getItems().addAll(punten);
    }
}
