/*
 * Nama : Muhammad Fauzan Fadhlulbarr
 * Nim : 10119176
 * Kelas : IF10K
 */
package edu.muhammadfauzan.latihanmvcdjbc.event;

import edu.muhammadfauzan.latihanmvcdjbc.entity.Pelanggan;
import edu.muhammadfauzan.latihanmvcdjbc.model.PelangganModel;

/**
 *
 * @author Muhammad Fauzan FB
 */
public interface PelangganListener {
    public void onChange(PelangganModel model);
    public void onInsert(Pelanggan pelanggan);
    public void onDelete();
    public void onUpdate(Pelanggan pelanggan);

    
}
