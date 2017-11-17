package com.proyectomercadolibre.prototipo1.adapter.implement;

import com.proyectomercadolibre.prototipo.commons.bean.AllConfig;
import com.proyectomercadolibre.prototipo.commons.integration.MercadoServerInterface;
import com.proyectomercadolibre.prototipo1.util.ConfigReadWrite;
import java.io.IOException;
import javax.ejb.Stateless;

/**
 *
 * @author NOCEDA
 */
@Stateless
public class RestMercadoAdapter {

    public ConfigReadWrite dbproperties = new ConfigReadWrite();
    public static String SERVER_IP;
    public static String SERVER_PORT;

    public RestMercadoAdapter() throws IOException {
        this.SERVER_IP = dbproperties.getPropValues("IP");
        this.SERVER_PORT = dbproperties.getPropValues("Port");
    }

    public void updateIp() {
        try {
            //lees archivo
            this.dbproperties = new ConfigReadWrite();
            //actualizas variable
            this.SERVER_IP = dbproperties.getPropValues("IP");
            this.SERVER_PORT = dbproperties.getPropValues("Port");
        } catch (Exception ex) {
        }
    }

    public static String getNOTIFICATION_SERVER_IP() {
        return SERVER_IP;
    }

    public static String getNOTIFICATION_SERVER_PORT() {
        return SERVER_PORT;
    }
    
    
        public AllConfig exportAllConfig() {
        try {
            return MercadoServerInterface.exportAllConfig(SERVER_IP, SERVER_PORT);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void importAllConfig(AllConfig allConfig) {
        try {
            MercadoServerInterface.importAllConfig(SERVER_IP, SERVER_PORT, allConfig);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
