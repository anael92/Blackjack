
package Forms;

import Resources.GameUtil;
import javax.swing.ImageIcon;

/**
 *
 * @author ANI
 */
public class WiningPopup extends javax.swing.JFrame {
    /**
     * Creates new form WinPopup
     */
    public WiningPopup() {
        GameUtil.WinPot();
        initComponents();
        this.setResizable(false);
        String file = "./src/img/card-symbols_bsmall.png";
                ImageIcon img = new ImageIcon(file);
                 this.setIconImage(img.getImage());
    }
    
    public void showWin()
    {
        WiningPopup winPopup = new WiningPopup();
        winPopup.setVisible(true);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
            @Override
            public void run() {
                winPopup.dispose();
               
            }
        },
                7000
        ); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ezgif.com-gif-maker.gif"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 490, 301);

        setSize(new java.awt.Dimension(496, 328));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     this.dispose();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
