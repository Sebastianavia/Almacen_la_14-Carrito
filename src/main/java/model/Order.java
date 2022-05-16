package model;

import java.util.Date;

public class Order {

    private  int id;
    private String pago_no_si;
    private long fecha_creacion = 0;
    private long fecha_pago=0;
    private int userId;




    public Order() {

    }

    public Order(int id, String pago_no_si, long fecha_creacion, long fecha_pago, int userId) {
        this.id = id;
        this.pago_no_si = pago_no_si;
        this.fecha_creacion = fecha_creacion;
        this.fecha_pago = fecha_pago;
        this.userId = userId;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPago_no_si() {
        return pago_no_si;
    }

    public void setPago_no_si(String pago_no_si) {

        if(pago_no_si.startsWith("S")){
            fecha_pago = new Date().getTime();
        }else if(pago_no_si.startsWith("N")){
            fecha_pago = 0;
        }
        this.pago_no_si = pago_no_si;
    }

    public long getFecha_creacion() {

        return fecha_creacion;
    }

    public void setFecha_creacion(long fecha_creacion) {

        this.fecha_creacion = fecha_creacion;
    }

    public long getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(long fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }



}
