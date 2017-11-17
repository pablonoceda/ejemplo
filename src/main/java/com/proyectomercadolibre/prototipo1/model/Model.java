/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectomercadolibre.prototipo1.model;

import com.proyectomercadolibre.prototipo.commons.bean.AllConfig;
import com.proyectomercadolibre.prototipo1.adapter.implement.RestMercadoAdapter;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author NOCEDA
 */
@Stateless
public class Model {
    
      @EJB
    private RestMercadoAdapter mercadoAdapter;
      
      
      public Model() throws IOException {
        mercadoAdapter = new RestMercadoAdapter();
    }

    public AllConfig exportAllConfig() {
        return mercadoAdapter.exportAllConfig();
    }

    public void importAllConfig(AllConfig allConfig) {
        mercadoAdapter.importAllConfig(allConfig);
    }
    
}
