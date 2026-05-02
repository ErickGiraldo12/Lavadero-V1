package org.example.model;

public class registroLavado {
    private int registroID;
    private int vehiculoID;
    private int servicioID;
    private String fechaLavado;
    private String horaInicio;
    private String horaFin;
    private double precioTotal;

    public registroLavado() {
    }
    public registroLavado(int vehiculoID, int servicioID, String fechaLavado, String horaInicio, String horaFin, double precioTotal) {
        this.vehiculoID = vehiculoID;
        this.servicioID = servicioID;
        this.fechaLavado = fechaLavado;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.precioTotal = precioTotal;
    }


    public registroLavado(int registroID, int vehiculoID, int servicioID, String fechaLavado, String horaInicio, String horaFin, double precioTotal) {
        this.registroID = registroID;
        this.vehiculoID = vehiculoID;
        this.servicioID = servicioID;
        this.fechaLavado = fechaLavado;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.precioTotal = precioTotal;
    }

    public int getRegistroID() {
        return registroID;
    }

    public void setRegistroID(int registroID) {
        this.registroID = registroID;
    }

    public int getVehiculoID() {
        return vehiculoID;
    }

    public void setVehiculoID(int vehiculoID) {
        this.vehiculoID = vehiculoID;
    }

    public int getServicioID() {
        return servicioID;
    }

    public void setServicioID(int servicioID) {
        this.servicioID = servicioID;
    }

    public String getFechaLavado() {
        return fechaLavado;
    }

    public void setFechaLavado(String fechaLavado) {
        this.fechaLavado = fechaLavado;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "registroLavado{" +
                "registroID=" + registroID +
                ", vehiculoID=" + vehiculoID +
                ", servicioID=" + servicioID +
                ", fechaLavado='" + fechaLavado + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", horaFin='" + horaFin + '\'' +
                ", precioTotal=" + precioTotal +
                '}';
    }
}
