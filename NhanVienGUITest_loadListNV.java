/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package GUI;

import BUS.BangCapBUS;
import BUS.ChucVu_BUS;
import BUS.NhanVienBUS;
import BUS.PhongBanBUS;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asus
 */
public class NhanVienGUITest_loadListNV {
    public NhanVienGUITest_loadListNV() {
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
    @Test (expected = Exception.class)
    public void testDocDSNVwithNULL() throws Exception {
        NhanVienBUS instance = null;
        instance.docDSNV();
    }
    @Test
    public void testDocDSNV() throws Exception {
        NhanVienBUS instance = new NhanVienBUS();
        instance.docDSNV();
        int expResult = 12;
        int Result = instance.dsnv.size();
        assertEquals(expResult, Result);
    }
    @Test (expected = Exception.class)
    public void testDocDSCVwithNULL() throws Exception {
        ChucVu_BUS instance = null;
        instance.docDSCV();
    }
    @Test
    public void testDocDSCV() throws Exception {
        ChucVu_BUS instance = new ChucVu_BUS();
        instance.docDSCV();
        int expResult = 11;
        int Result = instance.dscv.size();
        assertEquals(expResult, Result);
    }
    @Test (expected = Exception.class)
    public void testDocDSBCwithNULL() throws Exception {
        BangCapBUS instance = null;
        instance.docDSBC();
    }
    @Test
    public void testDocDSBC() throws Exception {
        BangCapBUS instance = new BangCapBUS();
        instance.docDSBC();
        int expResult = 5;
        int Result = instance.dsbc.size();
        assertEquals(expResult, Result);
    }
    @Test (expected = Exception.class)
    public void testDocDSPBwithNULL() throws Exception {
        PhongBanBUS instance = null;
        instance.docDSPB();
    }
    @Test
    public void testDocDSPB() throws Exception {
        PhongBanBUS instance = new PhongBanBUS();
        instance.docDSPB();
        int expResult = 10;
        int Result = instance.dspb.size();
        assertEquals(expResult, Result);
    }
    @Test
    public void testloadListNV() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = NhanVienGUI.class.getDeclaredMethod("loadListNV");
        method.setAccessible(true);
        NhanVienGUI nvGUI = new NhanVienGUI();
        method.invoke(nvGUI);
    }
    
}
