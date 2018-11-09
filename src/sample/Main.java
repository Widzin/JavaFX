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

    public void setColumns() {
        TableColumn<Product, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(180);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Product, Double> priceCol = new TableColumn<>("Price");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<Product, Integer> quantityCol = new TableColumn<>("Quantity");
        quantityCol.setMinWidth(100);
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        table.getColumns().addAll(nameCol, priceCol, quantityCol);
    }

    public void setProducts() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 3999.99, 10));
        products.add(new Product("Stuff", 39.22, 6));
        products.add(new Product("Bike", 9.99, 3));
        products.add(new Product("My brain", 44.99, 1));
        table.setItems(products);
    }
}
