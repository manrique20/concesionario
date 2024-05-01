package modelo_dto;
import java.util.Date;

public class venta {
        private int id;
        private Date fecha;
        private int vendedorId;
        private int cantidadVendida;
        private double total;
        private double impuesto;
        private double IVA;
        private double totalAPagar;
        private int formaDePagoId;
        private String detalle;
        private int clienteId;
    
        // Constructor
        public void VentaDTO(int id, Date fecha, int vendedorId, int cantidadVendida, double total,
                        double impuesto, double IVA, double totalAPagar, int formaDePagoId, String detalle, int clienteId) {
            this.id = id;
            this.fecha = fecha;
            this.vendedorId = vendedorId;
            this.cantidadVendida = cantidadVendida;
            this.total = total;
            this.impuesto = impuesto;
            this.IVA = IVA;
            this.totalAPagar = totalAPagar;
            this.formaDePagoId = formaDePagoId;
            this.detalle = detalle;
            this.clienteId = clienteId;
        }
    
        // Getters y setters
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public Date getFecha() {
            return fecha;
        }
    
        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }
    
        public int getVendedorId() {
            return vendedorId;
        }
    
        public void setVendedorId(int vendedorId) {
            this.vendedorId = vendedorId;
        }
    
        public int getCantidadVendida() {
            return cantidadVendida;
        }
    
        public void setCantidadVendida(int cantidadVendida) {
            this.cantidadVendida = cantidadVendida;
        }
    
        public double getTotal() {
            return total;
        }
    
        public void setTotal(double total) {
            this.total = total;
        }
    
        public double getImpuesto() {
            return impuesto;
        }
    
        public void setImpuesto(double impuesto) {
            this.impuesto = impuesto;
        }
    
        public double getIVA() {
            return IVA;
        }
    
        public void setIVA(double IVA) {
            this.IVA = IVA;
        }
    
        public double getTotalAPagar() {
            return totalAPagar;
        }
    
        public void setTotalAPagar(double totalAPagar) {
            this.totalAPagar = totalAPagar;
        }
    
        public int getFormaDePagoId() {
            return formaDePagoId;
        }
    
        public void setFormaDePagoId(int formaDePagoId) {
            this.formaDePagoId = formaDePagoId;
        }
    
        public String getDetalle() {
            return detalle;
        }
    
        public void setDetalle(String detalle) {
            this.detalle = detalle;
        }
    
        public int getClienteId() {
            return clienteId;
        }
    
        public void setClienteId(int clienteId) {
            this.clienteId = clienteId;
        }
    
        // Método toString para imprimir el DTO
        @Override
        public String toString() {
            return "VentaDTO{" +
                    "id=" + id +
                    ", fecha=" + fecha +
                    ", vendedorId=" + vendedorId +
                    ", cantidadVendida=" + cantidadVendida +
                    ", total=" + total +
                    ", impuesto=" + impuesto +
                    ", IVA=" + IVA +
                    ", totalAPagar=" + totalAPagar +
                    ", formaDePagoId=" + formaDePagoId +
                    ", detalle='" + detalle + '\'' +
                    ", clienteId=" + clienteId +
                    '}';
        }
    }
