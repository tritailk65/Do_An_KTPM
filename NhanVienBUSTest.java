/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BUS;

import DTO.NhanVienDTO;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class NhanVienBUSTest {
    
    public NhanVienBUSTest() {
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

    /**
     * Test of docDSNV method, of class NhanVienBUS.
     */
    @Test
    public void testDocDSNVwithNULL() throws Exception {
        NhanVienBUS instance = null;
        instance.docDSNV();
    }
    @Test
    public void testDocDSNV() throws Exception {
        NhanVienBUS instance = new NhanVienBUS();
        instance.docDSNV();
    }

    /**
     * Test of themNV method, of class NhanVienBUS.
     */
    @Test(expected = java.sql.SQLException.class)
    public void testThemNVwithSDTempty() throws Exception {
        String id = "";
        String name = "";
        int idcv = 0;
        String idpb = "";
        int idbc = 0;
        int gioitinh = 0;
        String ngaysinh = "";
        String sdt = "";
        String email = "";
        String cmnd = "";
        int luong = 0;
        int phucap = 0;
        int songaynghi = 0;
        String diachi = "adafea";
        String hinhanh = "";
        NhanVienBUS instance = new NhanVienBUS();
        instance.docDSNV();
        instance.themNV(id, name, idcv, idpb, idbc, gioitinh, ngaysinh, sdt, email, cmnd, luong, phucap, songaynghi, diachi, hinhanh);
    }
    
    @Test(expected = java.sql.SQLException.class)
    public void testThemNVwithDIACHIempty() throws Exception {
        String id = "";
        String name = "";
        int idcv = 0;
        String idpb = "";
        int idbc = 0;
        int gioitinh = 0;
        String ngaysinh = "";
        String sdt = "2021515626";
        String email = "";
        String cmnd = "";
        int luong = 0;
        int phucap = 0;
        int songaynghi = 0;
        String diachi = "";
        String hinhanh = "";
        NhanVienBUS instance = new NhanVienBUS();
        instance.docDSNV();
        instance.themNV(id, name, idcv, idpb, idbc, gioitinh, ngaysinh, sdt, email, cmnd, luong, phucap, songaynghi, diachi, hinhanh);
    }
    
    @Test(expected = java.sql.SQLException.class)
    public void testThemNV() throws Exception {
        String id = "";
        String name = "";
        int idcv = 0;
        String idpb = "";
        int idbc = 0;
        int gioitinh = 0;
        String ngaysinh = "";
        String sdt = "2021515626";
        String email = "";
        String cmnd = "";
        int luong = 0;
        int phucap = 0;
        int songaynghi = 0;
        String diachi = "adafea";
        String hinhanh = "";
        NhanVienBUS instance = new NhanVienBUS();
        instance.docDSNV();
        instance.themNV(id, name, idcv, idpb, idbc, gioitinh, ngaysinh, sdt, email, cmnd, luong, phucap, songaynghi, diachi, hinhanh);
    }

    /**
     * Test of suaNV method, of class NhanVienBUS.
     */
    @Test (expected = java.sql.SQLException.class)
    public void testSuaNV() throws Exception {
        System.out.println("suaNV");
        int index = 0;
        String name = "";
        int idcv = 0;
        String idpb = "";
        int idbc = 0;
        int gioitinh = 0;
        String ngaysinh = "";
        String sdt = "2021515626";
        String email = "";
        String cmnd = "";
        int luong = 0;
        int phucap = 0;
        int songaynghi = 0;
        String diachi = "adafea";
        int tinhtrang = 0;
        String hinhanh = "";
        NhanVienBUS instance = new NhanVienBUS();
        instance.docDSNV();
        instance.suaNV(index, name, idcv, idpb, idbc, gioitinh, ngaysinh, sdt, email, cmnd, luong, phucap, songaynghi, diachi, tinhtrang, hinhanh);
    }
    @Test (expected = java.sql.SQLException.class)
    public void testSuaNVwithDIACHIempty() throws Exception {
        System.out.println("suaNV");
        int index = 0;
        String name = "";
        int idcv = 0;
        String idpb = "";
        int idbc = 0;
        int gioitinh = 0;
        String ngaysinh = "";
        String sdt = "2021515626";
        String email = "";
        String cmnd = "";
        int luong = 0;
        int phucap = 0;
        int songaynghi = 0;
        String diachi = "";
        int tinhtrang = 0;
        String hinhanh = "";
        NhanVienBUS instance = new NhanVienBUS();
        instance.docDSNV();
        instance.suaNV(index, name, idcv, idpb, idbc, gioitinh, ngaysinh, sdt, email, cmnd, luong, phucap, songaynghi, diachi, tinhtrang, hinhanh);
    }
    public void testSuaNVwithSDTempty() throws Exception {
        System.out.println("suaNV");
        int index = 0;
        String name = "";
        int idcv = 0;
        String idpb = "";
        int idbc = 0;
        int gioitinh = 0;
        String ngaysinh = "";
        String sdt = "";
        String email = "";
        String cmnd = "";
        int luong = 0;
        int phucap = 0;
        int songaynghi = 0;
        String diachi = "adafea";
        int tinhtrang = 0;
        String hinhanh = "";
        NhanVienBUS instance = new NhanVienBUS();
        instance.docDSNV();
        instance.suaNV(index, name, idcv, idpb, idbc, gioitinh, ngaysinh, sdt, email, cmnd, luong, phucap, songaynghi, diachi, tinhtrang, hinhanh);
    }

    /**
     * Test of xoaNV method, of class NhanVienBUS.
     */
    @Test
    public void testXoaNV() throws Exception {
        System.out.println("xoaNV");
        String idnv = "";
        int index = 0;
        NhanVienBUS instance = new NhanVienBUS();
        instance.docDSNV();
        instance.xoaNV(idnv, index);
    }

    /**
     * Test of getAllNV method, of class NhanVienBUS.
     */
    @Test
    public void testGetAllNV() throws Exception {
        System.out.println("getAllNV");
        NhanVienBUS instance = new NhanVienBUS();
        NhanVienDTO nv = new NhanVienDTO();
        ArrayList<NhanVienDTO> expResult = new ArrayList<NhanVienDTO>();
        ArrayList<NhanVienDTO> result = instance.getAllNV();
        assertEquals(expResult, result);
    }

    /**
     * Test of CheckNhanVienByID method, of class NhanVienBUS.
     */
    @Test
    public void testCheckNhanVienByID() {
        System.out.println("CheckNhanVienByID");
        String st = "";
        int i = 0;
        int stt = 0;
        NhanVienBUS instance = new NhanVienBUS();
        ArrayList<NhanVienDTO> expResult = new ArrayList<NhanVienDTO>();
        ArrayList<NhanVienDTO> result = instance.CheckNhanVienByID(st, i, stt);
        assertEquals(expResult, result);
    }
    
}
