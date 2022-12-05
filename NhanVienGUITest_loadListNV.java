/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package GUI;

import BUS.BangCapBUS;
import BUS.ChucVu_BUS;
import BUS.NhanVienBUS;
import BUS.PhongBanBUS;
import DAO.BangCapDAO;
import DAO.ChucVu_DAO;
import DAO.NhanVienDAO;
import DAO.PhongBanDAO;
import DTO.BangCapDTO;
import DTO.ChucVu_DTO;
import DTO.NhanVienDTO;
import JDBC.connectSQL;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
    //test getConnect_connectSQL
    @Test (expected = SQLServerException.class)
    public void testGetConnectWrongInput() throws Exception{
        connectSQL con = new connectSQL("localhost","sa","1411","QLnhansu");
        con.getConnect();
    }
    @Test
    public void testGetConnect() throws Exception{
        connectSQL con = new connectSQL("localhost","sa","14112002","QLnhansu");
        con.getConnect();
    }
    //test docDSNV_NhanVienDAO
    @Test (expected = Exception.class)
    public void testDocDSNVwithWrongNumber_NVDAO() throws Exception {
        NhanVienDAO instance = new NhanVienDAO();
        ArrayList<NhanVienDTO> ds = new ArrayList<NhanVienDTO>();
        ds = instance.docDSNV();
        int expResult = 3;
        int Result = ds.size();
        assertEquals(expResult, Result);
    }
    @Test 
    public void testDocDSNV_NVDAO() throws Exception {
        NhanVienDAO instance = new NhanVienDAO();
        ArrayList<NhanVienDTO> ds = new ArrayList<NhanVienDTO>();
        ds = instance.docDSNV();
        int expResult = 12;
        int Result = ds.size();
        assertEquals(expResult, Result);
    }
    //test docDSBC_BangCapDAO
    @Test (expected = Exception.class)
    public void testdocDSBCwithWrongNumber_BCDAO() throws Exception {
        BangCapDAO instance = new BangCapDAO();
        ArrayList<BangCapDTO> ds = new ArrayList<BangCapDTO>();
        ds = instance.docDSBC();
        int expResult = 8;
        int Result = ds.size();
        assertEquals(expResult, Result);
    }
    @Test 
    public void testdocDSBC_BCDAO() throws Exception {
        BangCapDAO instance = new BangCapDAO();
        ArrayList<BangCapDTO> ds = new ArrayList<BangCapDTO>();
        ds = instance.docDSBC();
        int expResult = 5;
        int Result = ds.size();
        assertEquals(expResult, Result);
    }
    //test docDSCV_ChucVu_DAO
    @Test (expected = Exception.class)
    public void testdocDSCVwithWrongNumber_CVDAO() throws Exception {
        ChucVu_DAO instance = new ChucVu_DAO();
        ArrayList<ChucVu_DTO> ds = new ArrayList<ChucVu_DTO>();
        ds = instance.docDSCV();
        int expResult = 15;
        int Result = ds.size();
        assertEquals(expResult, Result);
    }
    @Test 
    public void testdocDSCV_CVDAO() throws Exception {
        ChucVu_DAO instance = new ChucVu_DAO();
        ArrayList<ChucVu_DTO> ds = new ArrayList<ChucVu_DTO>();
        ds = instance.docDSCV();
        int expResult = 11;
        int Result = ds.size();
        assertEquals(expResult, Result);
    }
    // test docDSPB_PhongBanDAO
    @Test (expected = Exception.class)
    public void testdocDSPBwithWrongNumber_PBDAO() throws Exception {
        PhongBanDAO instance = new PhongBanDAO();
        ArrayList<ChucVu_DTO> ds = new ArrayList<ChucVu_DTO>();
        ds = instance.docDSPB();
        int expResult = 19;
        int Result = ds.size();
        assertEquals(expResult, Result);
    }
    @Test 
    public void testdocDSPB_PBDAO() throws Exception {
        PhongBanDAO instance = new PhongBanDAO();
        ArrayList<ChucVu_DTO> ds = new ArrayList<ChucVu_DTO>();
        ds = instance.docDSPB();
        int expResult = 10;
        int Result = ds.size();
        assertEquals(expResult, Result);
    }
    //test docDSNV_NhanVienBUS
    @Test (expected = Exception.class)
    public void testDocDSNVwithNULL_NVBUS() throws Exception {
        NhanVienBUS instance = null;
        instance.docDSNV();
    }
    @Test (expected = Exception.class)
    public void testDocDSNVwithWrongNumber_NVBUS() throws Exception {
        NhanVienBUS instance = new NhanVienBUS();
        instance.docDSNV();
        int expResult = 11;
        int Result = instance.dsnv.size();
        assertEquals(expResult, Result);
    }
    @Test
    public void testDocDSNV_NVBUS() throws Exception {
        NhanVienBUS instance = new NhanVienBUS();
        instance.docDSNV();
        int expResult = 12;
        int Result = instance.dsnv.size();
        assertEquals(expResult, Result);
    }
    //test DocDSCV_ChucVu_BUS
    @Test (expected = Exception.class)
    public void testDocDSCVwithNULL_CVBUS() throws Exception {
        ChucVu_BUS instance = null;
        instance.docDSCV();
    }
    @Test (expected = Exception.class)
    public void testDocDSCVwithWrongNumber_CVBUS() throws Exception {
        ChucVu_BUS instance = new ChucVu_BUS();
        instance.docDSCV();
        int expResult = 10;
        int Result = instance.dscv.size();
        assertEquals(expResult, Result);
    }
    @Test
    public void testDocDSCV_CVBUS() throws Exception {
        ChucVu_BUS instance = new ChucVu_BUS();
        instance.docDSCV();
        int expResult = 11;
        int Result = instance.dscv.size();
        assertEquals(expResult, Result);
    }
    //test DocDSBC_BangCapBUS
    @Test (expected = Exception.class)
    public void testDocDSBCwithNULL_BCBUS() throws Exception {
        BangCapBUS instance = null;
        instance.docDSBC();
    }
    @Test(expected = Exception.class)
    public void testDocDSBCwithWrongNumber_BCBUS() throws Exception {
        BangCapBUS instance = new BangCapBUS();
        instance.docDSBC();
        int expResult = 4;
        int Result = instance.dsbc.size();
        assertEquals(expResult, Result);
    }
    @Test
    public void testDocDSBC_BCBUS() throws Exception {
        BangCapBUS instance = new BangCapBUS();
        instance.docDSBC();
        int expResult = 5;
        int Result = instance.dsbc.size();
        assertEquals(expResult, Result);
    }
    //test DocDSPB_PhongBanBUS
    @Test (expected = Exception.class)
    public void testDocDSPBwithNULL_PBBUS() throws Exception {
        PhongBanBUS instance = null;
        instance.docDSPB();
    }
    @Test (expected = Exception.class)
    public void testDocDSPBwithWrongNumber_PBBUS() throws Exception {
        PhongBanBUS instance = new PhongBanBUS();
        instance.docDSPB();
        int expResult = 9;
        int Result = instance.dspb.size();
        assertEquals(expResult, Result);
    }
    @Test
    public void testDocDSPB_PBBUS() throws Exception {
        PhongBanBUS instance = new PhongBanBUS();
        instance.docDSPB();
        int expResult = 10;
        int Result = instance.dspb.size();
        assertEquals(expResult, Result);
    }
    //test loadlist
    @Test
    public void testloadListNV() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = NhanVienGUI.class.getDeclaredMethod("loadListNV");
        method.setAccessible(true);
        NhanVienGUI nvGUI = new NhanVienGUI();
        method.invoke(nvGUI);
    }
    
}
