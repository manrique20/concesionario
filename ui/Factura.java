package ui;
// objeto de tipo Factura con datos de ejemplo
Factura facturaEjemplo = new Factura(123456, "2024-05-08", "Juan Manrique", "Cliente Ejemplo",
                                     "Toyota Corolla", "Gasolina", 1, 20000.0, 2000.0,
                                     "Tarjeta de crédito", 18000.0, 2000.0, 20000.0);

// Mostrar la información por consola
System.out.println("Información de la factura:");
System.out.println("Id (número de factura): " + facturaEjemplo.getId());
System.out.println("Fecha: " + facturaEjemplo.getFecha());
System.out.println("Vendedor: " + facturaEjemplo.getVendedor());
System.out.println("Cliente: " + facturaEjemplo.getCliente());
System.out.println("Automóvil: " + facturaEjemplo.getAutomovil());
System.out.println("Tipo de combustible: " + facturaEjemplo.getTipoCombustible());
System.out.println("Cantidad vendida: " + facturaEjemplo.getCantidadVendida());
System.out.println("Total: " + facturaEjemplo.getTotal());
System.out.println("Impuesto: " + facturaEjemplo.getImpuesto());
System.out.println("Forma de pago: " + facturaEjemplo.getFormaPago());
System.out.println("Sub Total: " + facturaEjemplo.getSubTotal());
System.out.println("Impuesto: " + facturaEjemplo.getImpuesto());
System.out.println("Total a pagar: " + facturaEjemplo.getTotalPagar());
