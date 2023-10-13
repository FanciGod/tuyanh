package com.controllerfx.projectv4;

import JDBCConnect.Connect.JDBCConnect;
import entity.Product;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class DashboardController implements Initializable {
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
    private TableColumn<?, ?> colAction;

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
    private AnchorPane image;

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

    public void logOut() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Log out");
        alert.setContentText("Are you sure?");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get().equals(ButtonType.OK)) {
            logOut.getScene().getWindow().hide();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
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

    public ObservableList<Product> callProductList() throws SQLException {
        ObservableList<Product> productList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM projectv4.product inner join projectv4.category on product.Category_ID = category.Category_ID inner join projectv4.supplier on product.Supplier_ID = supplier.Supplier_ID";
        Connection connect = JDBCConnect.Connect();
        PreparedStatement PS = connect.prepareStatement(sql);
        ResultSet RS = PS.executeQuery();
        while (RS.next()) {
            int productID = RS.getInt("Product_ID");
            String productName = RS.getString("product.Name");
            int quantity = RS.getInt("Quantity");
            double importPrice = RS.getDouble("Import_price");
            double sellPrice = RS.getDouble("Sell_price");
            String category = RS.getString("category.Name");
            String supplierName = RS.getString("supplier.Name");
            String image = RS.getString("Image");
            int isDeleted = RS.getInt("is_deleted");
            if (isDeleted == 0) {
                Product tempProduct = new Product(productID, productName, sellPrice, importPrice, quantity, category, image, supplierName);
                productList.add(tempProduct);
            }
        }
        return productList;
    }

    public void showProductList() throws SQLException {
        ObservableList<Product> realProductList = callProductList();
        colProductID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        colProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colSellPrice.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        colImportPrice.setCellValueFactory(new PropertyValueFactory<>("importPrice"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        productTableView.setItems(realProductList);
    }

    public void selectProductID() {
        Product productSelected = productTableView.getSelectionModel().getSelectedItem();
        int selectedProductID = productSelected.getProductID();
        GetData.getProductID = selectedProductID;
        System.out.println(GetData.getProductID);
    }

//    public void updateProduct() throws SQLException {
//        selectProductID();
//        Connection con = JDBCConnect.Connect();
//        String sql = "SELECT * FROM projectv4.product inner join projectv4.category on product.Category_ID = category.Category_ID inner join projectv4.supplier on product.Supplier_ID = supplier.Supplier_ID where product.Product_ID = ?";
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setInt(1, GetData.getProductID);
//        ResultSet rs =ps.executeQuery();
//        while (rs.next()){
//           String productName = rs.getString("product.Name");
//           String category = rs.getString("category.Name");
//           double sellPrice = rs.getDouble("Sell_price");
//           double importPrice = rs.getDouble("Import_price");
//            productNameView.setText(productName);
//            categoryView.setText(category);
//            sellPriceView.setText(String.valueOf(sellPrice));
//            importPriceView.setText(String.valueOf(importPrice));
//        }

//    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            showProductList();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
