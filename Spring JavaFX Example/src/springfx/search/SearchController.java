package springfx.search;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import springfx.model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable{
    
    @FXML
    private TextField searchField ;
    
    private final Model model ;
    
    public SearchController(Model model) {
        this.model = model ;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        searchField.textProperty().addListener((obs, oldValue, newValue) -> 
//            model.setSearchFilter(newValue));
        searchField.textProperty().bindBidirectional(model.searchFilterProperty());
    }
    
}
