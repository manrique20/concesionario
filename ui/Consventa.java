package ui;
private javax.swing.JButton btnConsultar;
private javax.swing.JTextField txtNumeroFactura;

// Dentro del método initComponents()
btnConsultar = new javax.swing.JButton();
txtNumeroFactura = new javax.swing.JTextField();

// Configuración del JTextField
txtNumeroFactura.setText("Ingrese número de factura");

// Configuración del JButton
btnConsultar.setText("Consultar");
btnConsultar.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnConsultarActionPerformed(evt);
    }
});

// Dentro del método initComponents(), donde se configuran los elementos en el formulario
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
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
            .addComponent(btnConsultar)))
)
private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {
    String numeroFactura = txtNumeroFactura.getText();
    System.out.println("Consulta de venta para factura número: " + numeroFactura);
    // Aquí puedes agregar la lógica para buscar la venta con el número de factura ingresado
}
