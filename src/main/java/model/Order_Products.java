package model;

public class Order_Products {


   private int id;
   private int productoID;
   private int	ordenID;
   private int cantidad_Producto;
   private int	precio_total;

    public Order_Products() {
    }

    public Order_Products(int id, int productoID, int ordenID, int cantidad_Producto, int precio_total) {
        this.id = id;
        this.productoID = productoID;
        this.ordenID = ordenID;
        this.cantidad_Producto = cantidad_Producto;
        this.precio_total = precio_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public int getOrdenID() {
        return ordenID;
    }

    public void setOrdenID(int ordenID) {
        this.ordenID = ordenID;
    }

    public int getCantidad_Producto() {
        return cantidad_Producto;
    }

    public void setCantidad_Producto(int cantidad_Producto) {
        this.cantidad_Producto = cantidad_Producto;
    }

    public int getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(int precio_total) {
        this.precio_total = precio_total;
    }
}
