/*
 * Nama : Muhammad Fauzan Fadhlulbarr
 * Nim : 10119176
 * Kelas : IF10K
 */
package edu.muhammadfauzan.latihanmvcdjbc.controller;

import edu.muhammadfauzan.latihanmvcdjbc.model.PelangganModel;
import edu.muhammadfauzan.latihanmvcdjbc.view.PelangganView;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhammad Fauzan FB
 */
public class PelangganController {
    
    private PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }
    
    public void resetPelanggan(PelangganView view){
        model.resetPelanggan();
    }
    
    public void insertPelanggan(PelangganView view){
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if(nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Nama tidak boleh Kosong");
        } else if (nama.length()>255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh Lebih dari 255 karakter");
        } else if (telepon.length()>12) {
            JOptionPane.showMessageDialog(view, "Nomor Telepon tidak boleh Lebih dari 12 karakter");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak Valid"); 
        } else {
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Ditambahkan");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan", throwable.getMessage()});
            }
            }
        }
    
    public void updatePelanggan(PelangganView view){
        if (view.getTablePelanggan().getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(view, "Silahkan selesaikan baris data yang akan diubah");
            return;
        }
        
        
        Integer id = Integer.parseInt(view.getTxtId().getText());
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if(nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Nama tidak boleh Kosong");
        } else if (nama.length()>255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh Lebih dari 255 karakter");
        } else if (telepon.length()>12) {
            JOptionPane.showMessageDialog(view, "Nomor Telepon tidak boleh Lebih dari 12 karakter");
        } else if (email.contains("@")||!email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak Valid"); 
        } else {
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try {
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Diubah");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan", throwable.getMessage()});
            }
            }
    }
        
        
    public void deletePelanggan(PelangganView view){
      if (view.getTablePelanggan().getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(view, "Silahkan selesaikan baris data yang akan dihapus");
            return;
        }
      
      if(JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus")==JOptionPane.OK_OPTION){
            Integer id = Integer.parseInt(view.getTxtId().getText());
            model.setId(id);
            
            try {
                model.deletePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Di Hapus");
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan", throwable.getMessage()});
            }
            }
      }
      
      
}
    
    
    
    

