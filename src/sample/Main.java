package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.commons.lang.StringUtils;


public class Main extends Application {

    private Stage window;
    private Scene scene;

    private TableView<Product> table;
    private TextField nameInput, priceInput, quantityInput;
    private HBox hBox;

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

        hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);

        setTextFields();
        setButtons();

        VBox layout = new VBox(10);
        layout.getChildren().addAll(table, hBox);

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
        TableColumn<Product, T> column = new TableColumn<>(StringUtils.capitalize(name));
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

    private void setTextFields() {
        nameInput = prepareTextField("Name", 180.0);
        priceInput = prepareTextField("Price", null);
        quantityInput = prepareTextField("Quantity", null);
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput);
    }

    private TextField prepareTextField(String promptText, Double minWidth) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        if (minWidth != null)
            textField.setMinWidth(minWidth);
        return textField;
    }

    private void setButtons() {
        Button addBtn = new Button("Add");
        addBtn.setOnAction(e -> addBtnClicked());
        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e -> deleteBtnClicked());
        hBox.getChildren().addAll(addBtn, deleteBtn);
    }

    private void addBtnClicked() {
        try {
            Double price = Double.parseDouble(priceInput.getText());
            Integer quantity = Integer.parseInt(quantityInput.getText());
            Product p = Product.builder()
                    .name(nameInput.getText())
                    .price(price)
                    .quantity(quantity)
                    .build();
            table.getItems().add(p);
        } catch (NumberFormatException e) {
            System.out.println("You cannot add this product.");
        }
    }

    private void deleteBtnClicked() {
        ObservableList<Product> productsSelected = table.getSelectionModel().getSelectedItems();
        ObservableList<Product> allProducts = table.getItems();
        productsSelected.forEach(allProducts::remove);
    }
}
