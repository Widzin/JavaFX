package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    private Stage window;
    private Scene scene;
    private TableView<Product> table;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Hello World");

        table = new TableView<>();
        setColumns();
        setProducts();

        VBox layout = new VBox(10);
        layout.getChildren().addAll(table);

        scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    private void setColumns() {
        TableColumn<Product, String> nameCol = prepareColumn(180, "name");
        TableColumn<Product, Double> priceCol = prepareColumn(100, "price");
        TableColumn<Product, Integer> quantityCol = prepareColumn(100, "quantity");
        table.getColumns().addAll(nameCol, priceCol, quantityCol);
    }

    private <T> TableColumn prepareColumn(int minWidth, String name) {
        TableColumn<Product, T> column = new TableColumn<>(name);
        column.setMinWidth(minWidth);
        column.setCellValueFactory(new PropertyValueFactory(name));
        return column;
    }

    private void setProducts() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 3999.99, 10));
        products.add(new Product("Stuff", 39.22, 6));
        products.add(new Product("Bike", 9.99, 3));
        products.add(new Product("My brain", 44.99, 1));
        table.setItems(products);
    }
}
