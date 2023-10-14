package com.controllerfx.projectv4;

import JDBCConnect.model.DashboardModel;
import entity.Customer;
import entity.GetData;
import entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Predicate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.AnchorPane;

public class DashboardController implements Initializable {
    @FXML
    public Button imageBut;
    @FXML
    private AnchorPane InventoryPanel;

    @FXML
    private Label SupplierTotalPrice;

    @FXML
    private AnchorPane addOrderPanel;

    @FXML
    private AnchorPane addPurchasePanel;

    @FXML
    private TableView<?> addPurchaseTable;

    @FXML
    private AnchorPane billHistoryPanel;

    @FXML
    private Button btSaveChangeToOrderTable;

    @FXML
    private Button btnAddCustomer;

    @FXML
    private Button btnAddOrder;

    @FXML
    private Button btnAddOrderLeft;

    @FXML
    private Button btnAddProduct;

    @FXML
    private Button btnAddPurchase;

    @FXML
    private Button btnAddPurchaseLeft;

    @FXML
    private Button btnAddSupplier;

    @FXML
    private Button btnAddToOrderTable;

    @FXML
    private Button btnAddToPurchase;

    @FXML
    private Button btnBillHistoryLeft;

    @FXML
    private Button btnCustomerLeft;

    @FXML
    private Button btnHomeLeft;

    @FXML
    private Button btnInventoryLeft;

    @FXML
    private Button btnNewAccountLeft;

    @FXML
    private Button btnPurchaseHistoryLeft;

    @FXML
    private Button btnRemovePurchase;

    @FXML
    private Button btnRemoveToOrderTable;

    @FXML
    private Button btnSaveChangeToPurchase;

    @FXML
    private Button btnStatisticsLeft;

    @FXML
    private Button btnSupplierLeft;

    @FXML
    private Button btnUpdateCustomer;

    @FXML
    private Button btnUpdateProduct;

    @FXML
    private Button btnUpdateSupplier;

    @FXML
    private TextField categoryView;

    @FXML
    private TableColumn<Product, Void> colAction;

    @FXML
    private TableColumn<?, ?> colBillAction;

    @FXML
    private TableColumn<?, ?> colBillCreateTime;

    @FXML
    private TableColumn<?, ?> colBillCreatedBy;

    @FXML
    private TableColumn<?, ?> colBillCustomer;

    @FXML
    private TableColumn<?, ?> colBillID;

    @FXML
    private TableColumn<Product, String> colCategory;

    @FXML
    private TableColumn<?, ?> colCustomerAction;

    @FXML
    private TableColumn<?, ?> colCustomerAddress;

    @FXML
    private TableColumn<?, ?> colCustomerEmail;

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colCustomerPhoneNumber;

    @FXML
    private TableColumn<Product, Double> colImportPrice;

    @FXML
    private TableColumn<?, ?> colOrderCategory;

    @FXML
    private TableColumn<?, ?> colOrderCategoryView;

    @FXML
    private TableColumn<?, ?> colOrderCreateTime;

    @FXML
    private TableColumn<?, ?> colOrderCreatedBy;

    @FXML
    private TableColumn<?, ?> colOrderFinalPrice;

    @FXML
    private TableColumn<?, ?> colOrderImportPrice;

    @FXML
    private TableColumn<?, ?> colOrderImportView;

    @FXML
    private TableColumn<?, ?> colOrderProductIDView;

    @FXML
    private TableColumn<?, ?> colOrderProductName;

    @FXML
    private TableColumn<?, ?> colOrderProductNameView1;

    @FXML
    private TableColumn<?, ?> colOrderPurchaseID;

    @FXML
    private TableColumn<?, ?> colOrderQuantity;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableColumn<Product, String> colProductID;

    @FXML
    private TableColumn<Product, String> colProductName;

    @FXML
    private TableColumn<?, ?> colPurchaseAction;

    @FXML
    private TableColumn<?, ?> colPurchaseCategory;

    @FXML
    private TableColumn<?, ?> colPurchaseCategoryView;

    @FXML
    private TableColumn<?, ?> colPurchaseFinalPrice;

    @FXML
    private TableColumn<?, ?> colPurchaseID;

    @FXML
    private TableColumn<?, ?> colPurchaseImportPrice;

    @FXML
    private TableColumn<?, ?> colPurchaseImportView;

    @FXML
    private TableColumn<?, ?> colPurchaseProductIDView;

    @FXML
    private TableColumn<?, ?> colPurchaseProductName;

    @FXML
    private TableColumn<?, ?> colPurchaseProductNameView;

    @FXML
    private TableColumn<?, ?> colPurchaseQuantity;

    @FXML
    private TableColumn<?, ?> colPurchaseSupplier;

    @FXML
    private TableColumn<Product, Integer> colQuantity;

    @FXML
    private TableColumn<Product, Double> colSellPrice;

    @FXML
    private TableColumn<?, ?> colSupplierAction;

    @FXML
    private TableColumn<?, ?> colSupplierAddress;

    @FXML
    private TableColumn<?, ?> colSupplierEmail;

    @FXML
    private TableColumn<?, ?> colSupplierID;

    @FXML
    private TableColumn<?, ?> colSupplierName;

    @FXML
    private TextField customerCustomerAddress;

    @FXML
    private TextField customerCustomerEmail;

    @FXML
    private TextField customerCustomerName;

    @FXML
    private AnchorPane customerPanel;

    @FXML
    private TextField customerPhoneNumber;

    @FXML
    private TextField customerSearch;

    @FXML
    private Label dashboardUsername;

    @FXML
    private BarChart<?, ?> homeChart;

    @FXML
    private AnchorPane homepagePanel;

    @FXML
    private ImageView image;

    @FXML
    private TextField importPriceView;

    @FXML
    private Button logOut;

    @FXML
    private AnchorPane newAccountPanel;

    @FXML
    private TextField newFullName;

    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField newRePassword;

    @FXML
    private TextField newUsername;

    @FXML
    private TextField orderAddress;

    @FXML
    private TextField orderCustomerName;

    @FXML
    private TextField orderEmail;

    @FXML
    private TableView<?> orderHistoryView;

    @FXML
    private TextField orderPhoneNumber;

    @FXML
    private TableView<?> orderTableView;

    @FXML
    private Label orderTotalPrice;

    @FXML
    private TextField productNameView;

    @FXML
    private TableView<?> productOrderTableView;

    @FXML
    private TextField productSearch;

    @FXML
    private TextField productSearch1;

    @FXML
    private TextField productSearch11;

    @FXML
    private Label productSoldToday;

    @FXML
    private TableView<Product> productTableView;

    @FXML
    private AnchorPane purchaseHistoryPanel;

    @FXML
    private TableView<?> purchaseHistoryView;

    @FXML
    private TableView<?> purchaseTableView;

    @FXML
    private Label revenueToday;

    @FXML
    private Label revenueToday1;

    @FXML
    private TextField searchOrderHistory;

    @FXML
    private TextField searchPurchaseHistory;

    @FXML
    private ComboBox<?> selectSupplierPurchase;

    @FXML
    private TextField sellPriceView;

    @FXML
    private AnchorPane statisticsPanel;

    @FXML
    private Label supplierAddressPurchase;

    @FXML
    private Label supplierEmailPurchase;

    @FXML
    private AnchorPane supplierPanel;

    @FXML
    private Label supplierPhonePurchase;

    @FXML
    private TextField supplierSearch;

    @FXML
    private TextField supplierSupplierAddress;

    @FXML
    private TextField supplierSupplierEmail;

    @FXML
    private TextField supplierSupplierName;

    @FXML
    private TextField supplierSupplierPhoneNumber;

    DashboardModel dashboardModel;

    ObservableList<Product> productObservableList = FXCollections.observableArrayList();

    private FileInputStream fileInputStream;

    private File selectedFile;

    @FXML
    private TableView<Customer> customerTable;

    public void logOut() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Log out");
        alert.setContentText("Are you sure?");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get().equals(ButtonType.OK)) {
            logOut.getScene().getWindow().hide();
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void switchForm(ActionEvent e) {
        if (e.getSource() == btnHomeLeft) {
            homepagePanel.setVisible(true);
            InventoryPanel.setVisible(false);
            addPurchasePanel.setVisible(false);
            purchaseHistoryPanel.setVisible(false);
            addOrderPanel.setVisible(false);
            billHistoryPanel.setVisible(false);
            customerPanel.setVisible(false);
            supplierPanel.setVisible(false);
            statisticsPanel.setVisible(false);
            newAccountPanel.setVisible(false);

            btnHomeLeft.setStyle("-fx-background-color: #e7525e");
            btnInventoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddPurchaseLeft.setStyle("-fx-background-color: #fbeaeb");
            btnPurchaseHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddOrderLeft.setStyle("-fx-background-color: #fbeaeb");
            btnBillHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnCustomerLeft.setStyle("-fx-background-color: #fbeaeb");
            btnSupplierLeft.setStyle("-fx-background-color: #fbeaeb");
            btnStatisticsLeft.setStyle("-fx-background-color: #fbeaeb");
            btnNewAccountLeft.setStyle("-fx-background-color: #fbeaeb");
        } else if (e.getSource() == btnInventoryLeft) {
            homepagePanel.setVisible(false);
            InventoryPanel.setVisible(true);
            addPurchasePanel.setVisible(false);
            purchaseHistoryPanel.setVisible(false);
            addOrderPanel.setVisible(false);
            billHistoryPanel.setVisible(false);
            customerPanel.setVisible(false);
            supplierPanel.setVisible(false);
            statisticsPanel.setVisible(false);
            newAccountPanel.setVisible(false);

            btnHomeLeft.setStyle("-fx-background-color: #fbeaeb");
            btnInventoryLeft.setStyle("-fx-background-color: #e7525e");
            btnAddPurchaseLeft.setStyle("-fx-background-color: #fbeaeb");
            btnPurchaseHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddOrderLeft.setStyle("-fx-background-color: #fbeaeb");
            btnBillHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnCustomerLeft.setStyle("-fx-background-color: #fbeaeb");
            btnSupplierLeft.setStyle("-fx-background-color: #fbeaeb");
            btnStatisticsLeft.setStyle("-fx-background-color: #fbeaeb");
            btnNewAccountLeft.setStyle("-fx-background-color: #fbeaeb");

            setTextViewEmpty();
            imageBut.setVisible(true);
            image.setImage(null);
        } else if (e.getSource() == btnAddPurchaseLeft) {
            homepagePanel.setVisible(false);
            InventoryPanel.setVisible(false);
            addPurchasePanel.setVisible(true);
            purchaseHistoryPanel.setVisible(false);
            addOrderPanel.setVisible(false);
            billHistoryPanel.setVisible(false);
            customerPanel.setVisible(false);
            supplierPanel.setVisible(false);
            statisticsPanel.setVisible(false);
            newAccountPanel.setVisible(false);

            btnHomeLeft.setStyle("-fx-background-color: #fbeaeb");
            btnInventoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddPurchaseLeft.setStyle("-fx-background-color: #e7525e");
            btnPurchaseHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddOrderLeft.setStyle("-fx-background-color: #fbeaeb");
            btnBillHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnCustomerLeft.setStyle("-fx-background-color: #fbeaeb");
            btnSupplierLeft.setStyle("-fx-background-color: #fbeaeb");
            btnStatisticsLeft.setStyle("-fx-background-color: #fbeaeb");
            btnNewAccountLeft.setStyle("-fx-background-color: #fbeaeb");
        } else if (e.getSource() == btnPurchaseHistoryLeft) {
            homepagePanel.setVisible(false);
            InventoryPanel.setVisible(false);
            addPurchasePanel.setVisible(false);
            purchaseHistoryPanel.setVisible(true);
            addOrderPanel.setVisible(false);
            billHistoryPanel.setVisible(false);
            customerPanel.setVisible(false);
            supplierPanel.setVisible(false);
            statisticsPanel.setVisible(false);
            newAccountPanel.setVisible(false);

            btnHomeLeft.setStyle("-fx-background-color: #fbeaeb");
            btnInventoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddPurchaseLeft.setStyle("-fx-background-color: #fbeaeb");
            btnPurchaseHistoryLeft.setStyle("-fx-background-color: #e7525e");
            btnAddOrderLeft.setStyle("-fx-background-color: #fbeaeb");
            btnBillHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnCustomerLeft.setStyle("-fx-background-color: #fbeaeb");
            btnSupplierLeft.setStyle("-fx-background-color: #fbeaeb");
            btnStatisticsLeft.setStyle("-fx-background-color: #fbeaeb");
            btnNewAccountLeft.setStyle("-fx-background-color: #fbeaeb");
        } else if (e.getSource() == btnAddOrderLeft) {
            homepagePanel.setVisible(false);
            InventoryPanel.setVisible(false);
            addPurchasePanel.setVisible(false);
            purchaseHistoryPanel.setVisible(false);
            addOrderPanel.setVisible(true);
            billHistoryPanel.setVisible(false);
            customerPanel.setVisible(false);
            supplierPanel.setVisible(false);
            statisticsPanel.setVisible(false);
            newAccountPanel.setVisible(false);

            btnHomeLeft.setStyle("-fx-background-color: #fbeaeb");
            btnInventoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddPurchaseLeft.setStyle("-fx-background-color: #fbeaeb");
            btnPurchaseHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddOrderLeft.setStyle("-fx-background-color: #e7525e");
            btnBillHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnCustomerLeft.setStyle("-fx-background-color: #fbeaeb");
            btnSupplierLeft.setStyle("-fx-background-color: #fbeaeb");
            btnStatisticsLeft.setStyle("-fx-background-color: #fbeaeb");
            btnNewAccountLeft.setStyle("-fx-background-color: #fbeaeb");
        } else if (e.getSource() == btnBillHistoryLeft) {
            homepagePanel.setVisible(false);
            InventoryPanel.setVisible(false);
            addPurchasePanel.setVisible(false);
            purchaseHistoryPanel.setVisible(false);
            addOrderPanel.setVisible(false);
            billHistoryPanel.setVisible(true);
            customerPanel.setVisible(false);
            supplierPanel.setVisible(false);
            statisticsPanel.setVisible(false);
            newAccountPanel.setVisible(false);

            btnHomeLeft.setStyle("-fx-background-color: #fbeaeb");
            btnInventoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddPurchaseLeft.setStyle("-fx-background-color: #fbeaeb");
            btnPurchaseHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddOrderLeft.setStyle("-fx-background-color: #fbeaeb");
            btnBillHistoryLeft.setStyle("-fx-background-color: #e7525e");
            btnCustomerLeft.setStyle("-fx-background-color: #fbeaeb");
            btnSupplierLeft.setStyle("-fx-background-color: #fbeaeb");
            btnStatisticsLeft.setStyle("-fx-background-color: #fbeaeb");
            btnNewAccountLeft.setStyle("-fx-background-color: #fbeaeb");
        } else if (e.getSource() == btnCustomerLeft) {
            homepagePanel.setVisible(false);
            InventoryPanel.setVisible(false);
            addPurchasePanel.setVisible(false);
            purchaseHistoryPanel.setVisible(false);
            addOrderPanel.setVisible(false);
            billHistoryPanel.setVisible(false);
            customerPanel.setVisible(true);
            supplierPanel.setVisible(false);
            statisticsPanel.setVisible(false);
            newAccountPanel.setVisible(false);

            btnHomeLeft.setStyle("-fx-background-color: #fbeaeb");
            btnInventoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddPurchaseLeft.setStyle("-fx-background-color: #fbeaeb");
            btnPurchaseHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddOrderLeft.setStyle("-fx-background-color: #fbeaeb");
            btnBillHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnCustomerLeft.setStyle("-fx-background-color: #e7525e");
            btnSupplierLeft.setStyle("-fx-background-color: #fbeaeb");
            btnStatisticsLeft.setStyle("-fx-background-color: #fbeaeb");
            btnNewAccountLeft.setStyle("-fx-background-color: #fbeaeb");
        } else if (e.getSource() == btnSupplierLeft) {
            homepagePanel.setVisible(false);
            InventoryPanel.setVisible(false);
            addPurchasePanel.setVisible(false);
            purchaseHistoryPanel.setVisible(false);
            addOrderPanel.setVisible(false);
            billHistoryPanel.setVisible(false);
            customerPanel.setVisible(false);
            supplierPanel.setVisible(true);
            statisticsPanel.setVisible(false);
            newAccountPanel.setVisible(false);

            btnHomeLeft.setStyle("-fx-background-color: #fbeaeb");
            btnInventoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddPurchaseLeft.setStyle("-fx-background-color: #fbeaeb");
            btnPurchaseHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddOrderLeft.setStyle("-fx-background-color: #fbeaeb");
            btnBillHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnCustomerLeft.setStyle("-fx-background-color: #fbeaeb");
            btnSupplierLeft.setStyle("-fx-background-color: #e7525e");
            btnStatisticsLeft.setStyle("-fx-background-color: #fbeaeb");
            btnNewAccountLeft.setStyle("-fx-background-color: #fbeaeb");
        } else if (e.getSource() == btnStatisticsLeft) {
            homepagePanel.setVisible(false);
            InventoryPanel.setVisible(false);
            addPurchasePanel.setVisible(false);
            purchaseHistoryPanel.setVisible(false);
            addOrderPanel.setVisible(false);
            billHistoryPanel.setVisible(false);
            customerPanel.setVisible(false);
            supplierPanel.setVisible(false);
            statisticsPanel.setVisible(true);
            newAccountPanel.setVisible(false);

            btnHomeLeft.setStyle("-fx-background-color: #fbeaeb");
            btnInventoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddPurchaseLeft.setStyle("-fx-background-color: #fbeaeb");
            btnPurchaseHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddOrderLeft.setStyle("-fx-background-color: #fbeaeb");
            btnBillHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnCustomerLeft.setStyle("-fx-background-color: #fbeaeb");
            btnSupplierLeft.setStyle("-fx-background-color: #fbeaeb");
            btnStatisticsLeft.setStyle("-fx-background-color: #e7525e");
            btnNewAccountLeft.setStyle("-fx-background-color: #fbeaeb");
        } else if (e.getSource() == btnNewAccountLeft) {
            homepagePanel.setVisible(false);
            InventoryPanel.setVisible(false);
            addPurchasePanel.setVisible(false);
            purchaseHistoryPanel.setVisible(false);
            addOrderPanel.setVisible(false);
            billHistoryPanel.setVisible(false);
            customerPanel.setVisible(false);
            supplierPanel.setVisible(false);
            statisticsPanel.setVisible(false);
            newAccountPanel.setVisible(true);

            btnHomeLeft.setStyle("-fx-background-color: #fbeaeb");
            btnInventoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddPurchaseLeft.setStyle("-fx-background-color: #fbeaeb");
            btnPurchaseHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnAddOrderLeft.setStyle("-fx-background-color: #fbeaeb");
            btnBillHistoryLeft.setStyle("-fx-background-color: #fbeaeb");
            btnCustomerLeft.setStyle("-fx-background-color: #fbeaeb");
            btnSupplierLeft.setStyle("-fx-background-color: #fbeaeb");
            btnStatisticsLeft.setStyle("-fx-background-color: #fbeaeb");
            btnNewAccountLeft.setStyle("-fx-background-color: #e7525e");
        }
    }

//    private void getDataForTbProduct() {
//        dashboardModel = new DashboardModel();
//        List<Product> ProductList = new ArrayList<>();
//        Product Product;
//        for (Product x : dashboardModel.getDataProduct()) {
//            Product = new Product();
//            Product.setProductID(x.getProductID());
//            Product.setProductName(x.getProductName());
//            Product.setCategory(x.getCategory());
//            Product.setSellPrice(x.getSellPrice());
//            Product.setImage(x.getImage());
//            Product.setImportPrice(x.getImportPrice());
//            Product.setQuantity(x.getQuantity());
//            ProductList.add(Product);
//        }
//        productObservableList.addAll(ProductList);
//    }


//    public void showProductList() {
//        getDataForTbProduct();
//        if (productObservableList.isEmpty()) {
//            productTableView.setItems(null);
//        } else {
//            colProductID.setCellValueFactory(new PropertyValueFactory<>("productID"));
//            colProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
//            colSellPrice.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
//            colImportPrice.setCellValueFactory(new PropertyValueFactory<>("importPrice"));
//            colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//            colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
//            colAction.setCellFactory(param -> new TableCell<Product, Void>() {
//                private final Button editButton = new Button("update");
//                private final Button deleteButton = new Button("delete");
//                private final HBox pane = new HBox(deleteButton, editButton);
//
//                {
//                    dashboardModel = new DashboardModel();
//                    deleteButton.setOnAction(event -> {
//                        Product getProduct = getTableView().getItems().get(getIndex());
//                        System.out.println(getProduct.getProductID() + "   " + getProduct.getProductName());
//                        dashboardModel.deleteProduct(getProduct.getProductID());
//                        productTableView.getItems().remove(getProduct);
//                        productTableView.refresh();
//                        imageBut.setVisible(true);
//                        setTextViewEmpty();
//                        image.setImage(null);
//                    });
//
//                    editButton.setOnAction(event -> {
//                        Product getProduct = getTableView().getItems().get(getIndex());
//                        System.out.println(getProduct.getProductID() + "   " + getProduct.getProductName());
//                        setTextView(getProduct);
//                        imageBut.setVisible(true);
//                    });
//                }
//
//                @Override
//                protected void updateItem(Void item, boolean empty) {
//                    super.updateItem(item, empty);
//                    deleteButton.setStyle(
//                            "-fx-background-color: #f19c9d;" +
//                                    "-fx-cursor: hand;"
//                    );
//                    editButton.setStyle(
//                            "-fx-background-color: #f19c9d;" +
//                                    "-fx-cursor: hand;"
//
//                    );
//                    HBox.setMargin(deleteButton, new Insets(2, 20, 0, 30));
//                    HBox.setMargin(editButton, new Insets(2, 20, 0, 2));
//                    pane.setStyle(
//                            ".button {" +
//                                    "-fx-background-color: black;" +
//                                    "-fx-alignment: center;" +
//                                    "}"
//                    );
//                    setGraphic(empty ? null : pane);
//                }
//            });
//
//            productTableView.setItems(productObservableList);
//        }
//    }


    private void searchFilter() {
        FilteredList<Product> filterSearch = new FilteredList<>(productObservableList, e -> true);
        productSearch.setOnKeyReleased(e -> {


            productSearch.textProperty().addListener((observable, oldValue, newValue) -> {
                filterSearch.setPredicate((Predicate<? super Product>) cust -> {
                    if (newValue == null) {
                        return true;
                    }
                    String toLowerCaseFilter = newValue.toLowerCase();
                    if (cust.getProductName().toLowerCase().contains(toLowerCaseFilter)) {
                        return true;
                    } else if (cust.getCategory().toLowerCase().contains(toLowerCaseFilter)) {
                        return true;
                    } else if (newValue.matches("-?\\d+(\\.\\d+)?")) {
                        if (cust.getSellPrice() == Double.parseDouble(newValue)) {
                            return true;
                        } else if (cust.getImportPrice() == Double.parseDouble(newValue)) {
                            return true;
                        }
                    }
                    return false;
                });
            });

            SortedList<Product> products = new SortedList<>(filterSearch);
            products.comparatorProperty().bind(productTableView.comparatorProperty());
            productTableView.setItems(products);
        });
    }

    private void setTextView(Product productSelected) {
        productNameView.setText(productSelected.getProductName());
        sellPriceView.setText(String.valueOf(productSelected.getSellPrice()));
        categoryView.setText(productSelected.getCategory());
        importPriceView.setText(String.valueOf(productSelected.getImportPrice()));
    }

    private void setTextViewEmpty() {
        productNameView.setText(null);
        sellPriceView.setText(null);
        categoryView.setText(null);
        importPriceView.setText(null);
    }

    public void selectProductID() {
        Product productSelected = productTableView.getSelectionModel().getSelectedItem();
        GetData.getProductID = productSelected.getProductID();
        setTextView(productSelected);
        imageBut.setVisible(false);
    }

//    public void updateProduct() throws SQLException {

//    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        showProductList();
        searchFilter();
        try {
            showCustomerList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void chooseImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.jpeg", "*.tiff")
        );
        selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            Image tempImage = new Image(selectedFile.toURI().toString());
            image.setImage(tempImage);
        } else {
            System.out.println("a");
        }
    }

    public void addProduct(ActionEvent event) {

    }

    public void showCustomerList() throws SQLException {
        DashboardModel dm = new DashboardModel();
        ObservableList<Customer> CustomerList = dm.getDataCustomerList();
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colCustomerAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        colCustomerPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("customerPhoneNum"));
        colCustomerEmail.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));
//        colCustomerAction.setCellFactory(param -> new TableCell<Customer, Void>() {
//            private final Button deleteCustomerButton = new Button("delete");
//            {
//                dashboardModel = new DashboardModel();
//                deleteCustomerButton.setOnAction(event -> {
//                    Customer getCustomer = getTableView().getItems().get(getIndex());
//                    System.out.println(getCustomer.getCustomerID() + "   " + getCustomer.getCustomerName();
//                    try {
//                        dashboardModel.deleteCustomer(getCustomer.getCustomerID());
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    customerTable.getItems().remove(getCustomer);
//                    customerTable.refresh();
//                });
//            }
//        };
        customerTable.setItems(CustomerList);
    }

    public void selectCustomerID() throws SQLException {
        Customer selectCustomer = customerTable.getSelectionModel().getSelectedItem();
        GetData.getCustomerID = selectCustomer.getCustomerID();
        DashboardModel dm = new DashboardModel();
        Customer customer = dm.getDataCustomer(GetData.getCustomerID);
        customerCustomerName.setText(customer.getCustomerName());
        customerCustomerAddress.setText(customer.getCustomerAddress());
        customerPhoneNumber.setText(customer.getCustomerPhoneNum());
        customerCustomerEmail.setText(customer.getCustomerEmail());

    }

    public void updateCustomerID() throws SQLException {
       DashboardModel dm = new DashboardModel();
       String regexPattern = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

       if(customerCustomerName.getText().isEmpty() || customerCustomerAddress.getText().isEmpty() ||customerPhoneNumber.getText().isEmpty() || customerCustomerEmail.getText().isEmpty()){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("ERROR!!!!");
           alert.setContentText("fill the blank....");
           alert.setHeaderText(null);
           alert.show();
       }else{
           if(customerCustomerEmail.getText().matches(regexPattern)){
               dm.updateCustomer(customerCustomerName.getText(),customerCustomerAddress.getText(),customerPhoneNumber.getText(),customerCustomerEmail.getText(), GetData.getCustomerID );
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setHeaderText(null);
               alert.setTitle("Update customer");
               alert.setContentText("Updated successfully");
               alert.showAndWait();
           }else{
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("ERROR!!!!");
               alert.setContentText("Check email again");
               alert.setHeaderText(null);
               alert.show();
           }
       }


    }
}