/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NOCEDA
 */
public class TestDemo {
    
    public TestDemo() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @Test
    public void test1() {
        try {
//            RestSepConcreteAdapter adapter = new RestSepConcreteAdapter();
//            RestSepConcreteAdapter.SEP_SERVER_IP = "10.0.0.212";
//            RestSepConcreteAdapter.SEP_SERVER_PORT = "5000";
//            AllConfig config = adapter.exportAllConfig();
//            System.out.println(config);
            assertTrue(true);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }
}
