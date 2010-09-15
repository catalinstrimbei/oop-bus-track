/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormConturi.java
 *
 * Created on Sep 15, 2010, 9:53:39 PM
 */

package app.contabilitate.ui;

import app.model.contabilitate.RegistruConturi;
import app.model.contabilitate.conturi.ClasaConturi;
import app.model.contabilitate.conturi.Cont;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author catalin.strimbei
 */
public class FormConturi extends javax.swing.JFrame {
    private RegistruConturi registruConturi;

    private app.model.contabilitate.conturi.Cont cont;

    /** Creates new form FormConturi */
    public FormConturi() {
        // creare entity manager
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("EntitatiContabilitate");
        EntityManager em = emf.createEntityManager();
        // initializare registru
        registruConturi = new RegistruConturi(em);

        initComponents();


        // initializare model
        initDataModel();

        // refresh pe formular
        //this.bindingGroup.unbind();
        //this.bindingGroup.bind();

    }

    private void initDataModel(){
        this.setConturi(new ArrayList<Cont>(registruConturi.getConturi()));
        //this.conturi = new ArrayList<Cont>(registruConturi.getConturi());

        if (this.conturi != null && !this.conturi.isEmpty()){
        	// initializare cont curent implicit
        	this.setCont(this.conturi.get(0));
                System.out.println("Conturi count " + this.conturi.size());
        }

        this.setClaseConturi(new ArrayList<ClasaConturi>(registruConturi.getClaseConturi()));
     }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        conturi = new java.util.ArrayList<app.model.contabilitate.conturi.Cont>();
        claseConturi = new java.util.ArrayList<app.model.contabilitate.conturi.ClasaConturi>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstConturi = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtCod = new javax.swing.JTextField();
        txtDenumire = new javax.swing.JTextField();
        cboSubClasaCont = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmdAdauga = new javax.swing.JButton();
        cmdSterge = new javax.swing.JButton();
        cmdAbandon = new javax.swing.JButton();
        cmdSalvare = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${conturi}");
        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, lstConturi);
        jListBinding.setDetailBinding(org.jdesktop.beansbinding.ELProperty.create("${cod}"));
        bindingGroup.addBinding(jListBinding);
        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${cont}"), lstConturi, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(lstConturi);

        jButton1.setText("Previous");

        jButton2.setText("Next");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${cont.cod}"), txtCod, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${cont.denumire}"), txtDenumire, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtDenumire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDenumireActionPerformed(evt);
            }
        });

        cboSubClasaCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${claseConturi}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, cboSubClasaCont);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${cont.subClasaCont}"), cboSubClasaCont, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jLabel1.setText("Cod");

        jLabel2.setText("Denumire");

        jLabel3.setText("Clasa cont");

        cmdAdauga.setText("Adauga");

        cmdSterge.setText("Sterge");

        cmdAbandon.setText("Abandon");

        cmdSalvare.setText("Salvare");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdAdauga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdSterge))
                    .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(cmdAbandon, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdSalvare, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(txtCod, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(txtDenumire, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(cboSubClasaCont, 0, 141, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDenumire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboSubClasaCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdAdauga)
                        .addComponent(cmdSterge)
                        .addComponent(cmdAbandon))
                    .addComponent(cmdSalvare))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDenumireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDenumireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDenumireActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormConturi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboSubClasaCont;
    private java.util.List<app.model.contabilitate.conturi.ClasaConturi> claseConturi;
    private javax.swing.JButton cmdAbandon;
    private javax.swing.JButton cmdAdauga;
    private javax.swing.JButton cmdSalvare;
    private javax.swing.JButton cmdSterge;
    private java.util.List<app.model.contabilitate.conturi.Cont> conturi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstConturi;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDenumire;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public java.util.List<app.model.contabilitate.conturi.ClasaConturi> getClaseConturi() {
        return claseConturi;
    }

    public void setClaseConturi(java.util.List<app.model.contabilitate.conturi.ClasaConturi> claseConturi) {
        java.util.List<ClasaConturi> old = this.claseConturi;
        this.claseConturi = claseConturi;
        changeSupport.firePropertyChange("claseConturi", old, this.claseConturi);
    }

    public java.util.List<app.model.contabilitate.conturi.Cont> getConturi() {
        return conturi;
    }

    public void setConturi(java.util.List<app.model.contabilitate.conturi.Cont> conturi) {
        //changeSupport.firePropertyChange("conturi", this.conturi, conturi);
        //this.conturi = conturi;
        
        java.util.List<Cont> old = this.conturi;
        this.conturi = conturi;
        changeSupport.firePropertyChange("conturi", old, this.conturi);
    }

    public app.model.contabilitate.conturi.Cont getCont() {
        
        return cont;
    }

    public void setCont(app.model.contabilitate.conturi.Cont cont) {
        Cont old = this.cont;
        this.cont = cont;
        changeSupport.firePropertyChange("cont", old, this.cont);
        if (this.cont != null)
            System.out.println("Selected cont: " + this.cont.getCod());
        else
            System.out.println("Selected cont: " + this.cont);
    }
    
}
