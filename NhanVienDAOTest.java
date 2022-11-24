/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import JDBC.connectSQL;

import java.util.ArrayList;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import org.junit.runner.RunWith;
import static org.junit.Assert.*;
//import org.mockito.ArgumentMatchers;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;

import BUS.NhanVienBUS;

/**
 *
 * @author asus
 */
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({connectSQL.class, NhanVienDAO.class})
public class NhanVienDAOTest {
    NhanVienDAO nhanVienDAO;
    NhanVienDAO nhanVienDAOSpy;
    public NhanVienDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
       nhanVienDAO = new NhanVienDAO();
//       PowerMockito.mockStatic(connectSQL.class);
//       nhanVienDAOSpy = PowerMockito.spy(new NhanVienDAO());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of docDSNV method, of class NhanVienDAO.
     */
    @Test
    public void testDocDSNV() throws Exception {
//       NhanVienDTO nhanVienDTO = new NhanVienDTO();
//       List<NhanVienDTO> expResult = new ArrayList<>();
//       expResult.add(nhanVienDTO);
//       PowerMockito.doReturn(expResult)
//               .when(nhanVienDAOSpy,"select",ArgumentMatchers.anyString());
//       List<NhanVienDTO> result = nhanVienDAOSpy.docDSNV();
//       assertThat(result, CoreMatchers.is(expResult));
    }

    /**
     * Test of themNV method, of class NhanVienDAO.
     * @throws java.lang.Exception
     */
    @Test (expected = java.sql.SQLException.class)
    public void testThemNV() throws Exception {
        nhanVienDAO.themNV();
    }
    @Test (expected = Exception.class)
    public void testThemNVwithNull() throws Exception {
        nhanVienDAO = null;
        nhanVienDAO.themNV();
    }

    /**
     * Test of suaNV method, of class NhanVienDAO.
     */
    @Test
    public void testSuaNV() throws Exception {

        int index = 1;
        nhanVienDAO.suaNV(index);

    }

    /**
     * Test of xoaNV method, of class NhanVienDAO.
     */
    @Test
    public void testXoaNV() throws Exception {
        String idnv = "";
        nhanVienDAO.xoaNV(idnv);
    }

    /**
     * Test of openConnection method, of class NhanVienDAO.
     */
    @Test
    public void testOpenConnection() {
        boolean expResult = true;
        boolean result = nhanVienDAO.openConnection();
        assertEquals(expResult, result);
    }

    /**
     * Test of closeConnection method, of class NhanVienDAO.
     */
    @Test
    public void testCloseConnection() {
        nhanVienDAO.closeConnection();
    }

    /**
     * Test of getAllNV method, of class NhanVienDAO.
     */
    @Test(expected = Exception.class)
    public void testGetAllNVwithNull() {
        NhanVienDAO nv = null;
        ArrayList<NhanVienDTO> expResult = null;
        ArrayList<NhanVienDTO> result = nv.getAllNV();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetAllNV() {
        ArrayList<NhanVienDTO> expResult = null;
        ArrayList<NhanVienDTO> result = nhanVienDAO.getAllNV();
        assertNotEquals(expResult, result);
    }
    

    /**
     * Test of CheckNhanVienByID method, of class NhanVienDAO.
     */
    @Test
    public void testCheckNhanVienByID() throws Exception {
        String st = "";
        int i = 0;
        int stt = 0;
        ArrayList<NhanVienDTO> expResult = new ArrayList<NhanVienDTO>();
        ArrayList<NhanVienDTO> result = nhanVienDAO.CheckNhanVienByID(st, i, stt);
        assertEquals(expResult, result);
    }
    
}
