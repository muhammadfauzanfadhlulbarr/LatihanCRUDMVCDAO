/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
