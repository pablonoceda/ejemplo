package com.proyectomercadolibre.prototipo1.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author NOCEDA
 */
public class ConfigReadWrite {

    private static final Logger LOG = Logger.getLogger(ConfigReadWrite.class.getName());
    private static String propFileName = "config.properties";
    private Properties prop;

    public ConfigReadWrite() throws IOException {
        checkSetting();
    }

    private void checkSetting() throws IOException {

        File f = new File("prototipo/" + propFileName);
        if (f.exists() && !f.isDirectory()) {
            load();
        } else {

            File dir = new File("prototipo");
            dir.mkdirs();
            File configCreate = new File(dir, "config.properties");
            configCreate.createNewFile();
            prop = new Properties();
            OutputStream out = new FileOutputStream("prototipo/" + propFileName);
            prop.setProperty("IP", "127.0.0.1");
            prop.setProperty("Port", "3000");
            prop.setProperty("accessControl", "enabled");
            prop.setProperty("modifySettings", "enabled");
            prop.store(out, "Prototipo Config File");

        }

    }

    private void load() throws IOException {
        prop = new Properties();
        InputStream inputStream = new FileInputStream(new File("prototipo/" + propFileName));
        prop.load(inputStream);
    }

    public void save(String reqProperty, String reqValue) throws FileNotFoundException, IOException {
        OutputStream out = new FileOutputStream("prototipo/" + propFileName);
        prop.setProperty(reqProperty, reqValue);
        prop.store(out, null);
    }

    public String getPropValues(String reqProperty) throws IOException {
        return prop.getProperty(reqProperty);
    }

    public void setPropValues(String reqProperty, String reqValue) throws IOException {
        save(reqProperty, reqValue);
    }
}
