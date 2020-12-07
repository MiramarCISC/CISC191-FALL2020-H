package FX.fx_model;


import H2Database.db_model.Book;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.util.Map;

public class ItemCellFactory implements Callback<ListView<Map.Entry<Book,Integer>>, ListCell<Map.Entry<Book,Integer>>> {

    @Override
    public ListCell<Map.Entry<Book, Integer>> call(ListView<Map.Entry<Book, Integer>> entryListView) {
        return new Item();
    }
}
