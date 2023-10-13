package entity;

public class Product {
    private int productID;
    private String productName;
    private double sellPrice;
    private double importPrice;
    private int quantity;
    private String category;
    private String image;
    private String supplierName;

    public Product(int productID, String productName, double sellPrice, double importPrice, int quantity, String category, String image, String supplierName) {
        this.productID = productID;
        this.productName = productName;
        this.sellPrice = sellPrice;
        this.importPrice = importPrice;
        this.quantity = quantity;
        this.category = category;
        this.image = image;
        this.supplierName = supplierName;
    }


    public Product() {

    }

    public Product(int productID, String productName, double sellPrice, double importPrice, int quantity, String category, String supplierName) {
        this.productID = productID;
        this.productName = productName;
        this.sellPrice = sellPrice;
        this.importPrice = importPrice;
        this.quantity = quantity;
        this.category = category;
        this.supplierName = supplierName;
    }

    public Product(int productID, String productName, double sellPrice, double importPrice, int quantity, String category) {
        this.productID = productID;
        this.productName = productName;
        this.sellPrice = sellPrice;
        this.importPrice = importPrice;
        this.quantity = quantity;
        this.category = category;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", sellPrice=" + sellPrice +
                ", importPrice=" + importPrice +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", supplierName='" + supplierName + '\'' +
                '}';
    }
}
