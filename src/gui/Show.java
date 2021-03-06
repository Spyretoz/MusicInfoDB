package gui;

import basics.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.DefaultListModel;


public class Show extends javax.swing.JFrame 
{
	DefaultListModel dlm;
	ArrayList<Person> data;
	
	public Show() 
	{
		dlm = new DefaultListModel();
		data = getPersonFromDB();
		for(Person p: data)
		{
			dlm.addElement(p);
		}
		initComponents();
	}
	
	public Show(ArrayList<Person> getData) 
	{
		data = getData;
		dlm = new DefaultListModel();
		for(Person p: data)
		{
			dlm.addElement(p);
		}
		initComponents();
	}
	
	public ArrayList<Person> getPersonFromDB()
	{
		ArrayList<Person> pp = new ArrayList<Person>();
//		pp.add(pother);
		pp.add(new Person("Tyler Robert Joseph", "Male", "USA", "Ohio", new GregorianCalendar(1988, 12, 01), null));
		return pp;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ShowArea = new javax.swing.JTextArea();
        ShowButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TheList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ShowArea.setEditable(false);
        ShowArea.setBackground(new java.awt.Color(102, 255, 204));
        ShowArea.setColumns(20);
        ShowArea.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ShowArea.setRows(5);
        jScrollPane1.setViewportView(ShowArea);

        ShowButton.setText("SHOW");
        ShowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowButtonActionPerformed(evt);
            }
        });

        TheList.setBackground(new java.awt.Color(255, 255, 155));
        TheList.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        TheList.setModel(dlm);
        jScrollPane2.setViewportView(TheList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(70, 70, 70)
                .addComponent(ShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ShowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowButtonActionPerformed
        // TODO add your handling code here:
		List<Person> select = TheList.getSelectedValuesList();
		ShowArea.setText(""); // clean the ShowArea
		
		for(Object s: select)
		{
			ShowArea.append(((Person)s).getObjecttoString() + "\n"); // show selected items
		}
    }//GEN-LAST:event_ShowButtonActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
        //</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Show().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ShowArea;
    private javax.swing.JButton ShowButton;
    private javax.swing.JList TheList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
