/*
 * Nama : Muhammad Fauzan Fadhlulbarr
 * Nim : 10119176
 * Kelas : IF10K
 */
package edu.muhammadfauzan.latihanmvcdjbc.main;

import edu.muhammadfauzan.latihanmvcdjbc.error.PelangganException;
import edu.muhammadfauzan.latihanmvcdjbc.view.MainViewPelanggan;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Muhammad Fauzan FB
 */
public class LatihanCRUDMVCDAO {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, PelangganException {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               try {
                    MainViewPelanggan pelanggan = new MainViewPelanggan();
                    pelanggan.loadDatabase();
                    pelanggan.setVisible(true);
                } catch (SQLException e) {
                } catch (PelangganException ex) {
                    Logger.getLogger(LatihanCRUDMVCDAO.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
      
    }
}
