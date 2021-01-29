/*
 * Nama : Muhammad Fauzan Fadhlulbarr
 * Nim : 10119176
 * Kelas : IF10K
 */
package edu.muhammadfauzan.latihanmvcdjbc.model;

import edu.muhammadfauzan.latihanmvcdjbc.database.KedaiOzanDatabase;
import edu.muhammadfauzan.latihanmvcdjbc.entity.Pelanggan;
import edu.muhammadfauzan.latihanmvcdjbc.error.PelangganException;
import edu.muhammadfauzan.latihanmvcdjbc.event.PelangganListener;
import edu.muhammadfauzan.latihanmvcdjbc.service.PelangganDao;
import java.sql.SQLException;

/**
 *
 * @author Muhammad Fauzan FB
 */
public class PelangganModel {
    
    private int id;
    private String Nama;
    private String Alamat;
    private String Telepon;
    private String Email;

    private PelangganListener listener;

    public PelangganListener getListener() {
        return listener;
    }

    public void setListener(PelangganListener listener) {
        this.listener = listener;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
    }

    public String getNama() {
        return Nama;
        
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
        fireOnChange();
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
        fireOnChange();
    }

    public String getTelepon() {
        return Telepon;
    }

    public void setTelepon(String Telepon) {
        this.Telepon = Telepon;
        fireOnChange();
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
        fireOnChange();
    }
    
    protected void fireOnChange(){ 
        if(listener!=null){
            listener.onChange(this);
        }
    }
    protected void fireOnInsert(Pelanggan pelanggan){
        if(listener!=null){
            listener.onInsert(pelanggan);
        }
    }
    protected void fireOnUpdate(Pelanggan pelanggan){
        if(listener!=null){
        listener.onUpdate(pelanggan);
        }
    }
    protected void fireOnDelete(){ 
        if(listener!=null){
            listener.onDelete();
        }
    }
    
    public void insertPelanggan() throws SQLException, PelangganException {
       PelangganDao dao = KedaiOzanDatabase.getPelangganDao();
       Pelanggan pelanggan = new Pelanggan();
       
       pelanggan.setNama(Nama);
       pelanggan.setAlamat(Alamat);
       pelanggan.setTelepon(Telepon);
       pelanggan.setEmail(Email);
       
       dao.insertPelanggan(pelanggan);
       fireOnInsert(pelanggan);
    }
    
    public void updatePelanggan() throws SQLException, PelangganException {
       PelangganDao dao = KedaiOzanDatabase.getPelangganDao();
       Pelanggan pelanggan = new Pelanggan();
       
       pelanggan.setNama(Nama);
       pelanggan.setAlamat(Alamat);
       pelanggan.setTelepon(Telepon);
       pelanggan.setEmail(Email);
       pelanggan.setId(id);
       
       dao.updatePelanggan(pelanggan);
       fireOnUpdate(pelanggan);
    }
    
    public void deletePelanggan() throws SQLException, PelangganException {
       PelangganDao dao = KedaiOzanDatabase.getPelangganDao();
       
       dao.deletePelanggan(id);
       fireOnDelete();
    }
    
    public void resetPelanggan(){
        setId(0);
        setNama("");
        setAlamat("");
        setTelepon("");
        setEmail("");
    }
}
