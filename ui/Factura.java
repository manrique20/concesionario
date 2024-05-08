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

private javax.swing.JButton btnImprimir;
private javax.swing.JButton btnAtras;

// Dentro del método initComponents()
btnImprimir = new javax.swing.JButton();
btnAtras = new javax.swing.JButton();

// Configuración del botón de imprimir
btnImprimir.setText("Imprimir");
btnImprimir.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnImprimirActionPerformed(evt);
    }
});

// Configuración del botón de atrás
btnAtras.setText("Atrás");
btnAtras.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAtrasActionPerformed(evt);
    }
});

// Agregar los botones al layout
layout.setHorizontalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
        .addGap(112, 112, 112)
        .addComponent(Marcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    .addGroup(layout.createSequentialGroup()
        .addGap(86, 86, 86)
        .addComponent(marcaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
    .addGroup(layout.createSequentialGroup()
        .addGap(86, 86, 86)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnImprimir)
            .addComponent(btnAtras)))
);

layout.setVerticalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
        .addGap(116, 116, 116)
        .addComponent(Marcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(39, 39, 39)
        .addComponent(marcaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(btnImprimir)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnAtras)
        .addContainerGap(48, Short.MAX_VALUE))
);
private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {
    // Se dirige a la impresora disponible para imprimir en físico
}

private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {
    // se dirige al menú anteror consulta de venta
}
