/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DTO;

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
public class NhanVienDTOTest {
    
    static NhanVienDTO instance = new NhanVienDTO();
    
    public NhanVienDTOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance.id = "A10";
        instance.name = "nam";
        instance.id_chucvu = 5;
        instance.id_phongban = "P30";
        instance.id_bangcap = 2;
        instance.ngaysinh = "20/10/2002";
        instance.sdt = "0956325895";
        instance.email = "n@gmail.com";
        instance.cmnd = "318351454154";
        instance.luong = 200000;
        instance.phucap = 100000;
        instance.songaynghi = 3;
        instance.diachi = "15 duong 3/2";
        instance.gioitinh = 0;
        instance.tinhtrang = 1;
        instance.hinhanh = "gia vo day la hinh anh";
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
     * Test of getId method, of class NhanVienDTO.
     */
    @Test
    public void testGetId() {
        String expResult = "A10";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class NhanVienDTO.
     */
    @Test
    public void testSetId() {
        String test_id = "A20";
        NhanVienDTO instance = new NhanVienDTO();
        instance.setId(test_id);
        assertEquals(test_id, instance.id);
    }

    /**
     * Test of getName method, of class NhanVienDTO.
     */
    @Test
    public void testGetName() {
        String expResult = "nam";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class NhanVienDTO.
     */
    @Test
    public void testSetName() {
        String test_name = "giang";
        NhanVienDTO instance = new NhanVienDTO();
        instance.setName(test_name);
        assertEquals(test_name, instance.name);
    }

    /**
     * Test of getId_chucvu method, of class NhanVienDTO.
     */
    @Test
    public void testGetId_chucvu() {
        int expResult = 5;
        int result = instance.getId_chucvu();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId_chucvu method, of class NhanVienDTO.
     */
    @Test
    public void testSetId_chucvu() {
        int test_Id_chucvu = 6;
        NhanVienDTO instance = new NhanVienDTO();
        instance.setId_chucvu(test_Id_chucvu);
        assertEquals(test_Id_chucvu, instance.id_chucvu);
    }

    /**
     * Test of getId_phongban method, of class NhanVienDTO.
     */
    @Test
    public void testGetId_phongban() {
        String expResult = "P30";
        String result = instance.getId_phongban();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId_phongban method, of class NhanVienDTO.
     */
    @Test
    public void testSetId_phongban() {
        String test_Id_phongban = "P15";
        NhanVienDTO instance = new NhanVienDTO();
        instance.setId_phongban(test_Id_phongban);
        assertEquals(test_Id_phongban, instance.id_phongban);
    }

    /**
     * Test of getId_bangcap method, of class NhanVienDTO.
     */
    @Test
    public void testGetId_bangcap() {
        int expResult = 2;
        int result = instance.getId_bangcap();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId_bangcap method, of class NhanVienDTO.
     */
    @Test
    public void testSetId_bangcap() {
        int test_Id_bangcap = 6;
        NhanVienDTO instance = new NhanVienDTO();
        instance.setId_bangcap(test_Id_bangcap);
        assertEquals(test_Id_bangcap, instance.id_bangcap);
    }

    /**
     * Test of getNgaysinh method, of class NhanVienDTO.
     */
    @Test
    public void testGetNgaysinh() {
        String expResult = "20/10/2002";
        String result = instance.getNgaysinh();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNgaysinh method, of class NhanVienDTO.
     */
    @Test
    public void testSetNgaysinh() {
        String test_Ngaysinh = "20/11/2002";
        NhanVienDTO instance = new NhanVienDTO();
        instance.setNgaysinh(test_Ngaysinh);
        assertEquals(test_Ngaysinh, instance.ngaysinh);
    }

    /**
     * Test of getSdt method, of class NhanVienDTO.
     */
    @Test
    public void testGetSdt() {
        String expResult = "0956325895";
        String result = instance.getSdt();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSdt method, of class NhanVienDTO.
     */
    @Test
    public void testSetSdt() {
        String test_Sdt = "0656615456";
        NhanVienDTO instance = new NhanVienDTO();
        instance.setSdt(test_Sdt);
        assertEquals(test_Sdt, instance.sdt);
    }

    /**
     * Test of getEmail method, of class NhanVienDTO.
     */
    @Test
    public void testGetEmail() {
        String expResult = "n@gmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class NhanVienDTO.
     */
    @Test
    public void testSetEmail() {
        String test_Email = "m@gmail.com";
        NhanVienDTO instance = new NhanVienDTO();
        instance.setEmail(test_Email);
        assertEquals(test_Email, instance.email);
    }

    /**
     * Test of getCmnd method, of class NhanVienDTO.
     */
    @Test
    public void testGetCmnd() {
        String expResult = "318351454154";
        String result = instance.getCmnd();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCmnd method, of class NhanVienDTO.
     */
    @Test
    public void testSetCmnd() {
        String test_Email = "16541545154515";
        NhanVienDTO instance = new NhanVienDTO();
        instance.setEmail(test_Email);
        assertEquals(test_Email, instance.email);
    }

    /**
     * Test of getLuong method, of class NhanVienDTO.
     */
    @Test
    public void testGetLuong() {
        int expResult = 200000;
        int result = instance.getLuong();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLuong method, of class NhanVienDTO.
     */
    @Test
    public void testSetLuong() {
        int test_Luong = 200000;
        NhanVienDTO instance = new NhanVienDTO();
        instance.setLuong(test_Luong);
        assertEquals(test_Luong, instance.luong);
    }

    /**
     * Test of getPhucap method, of class NhanVienDTO.
     */
    @Test
    public void testGetPhucap() {
        int expResult = 100000;
        int result = instance.getPhucap();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhucap method, of class NhanVienDTO.
     */
    @Test
    public void testSetPhucap() {
        int test_Phucap = 100000;
        NhanVienDTO instance = new NhanVienDTO();
        instance.setPhucap(test_Phucap);
        assertEquals(test_Phucap, instance.phucap);
    }

    /**
     * Test of getSongaynghi method, of class NhanVienDTO.
     */
    @Test
    public void testGetSongaynghi() {
        int expResult = 3;
        int result = instance.getSongaynghi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSongaynghi method, of class NhanVienDTO.
     */
    @Test
    public void testSetSongaynghi() {
        int test_Songaynghi = 5;
        NhanVienDTO instance = new NhanVienDTO();
        instance.setSongaynghi(test_Songaynghi);
        assertEquals(test_Songaynghi, instance.songaynghi);
    }

    /**
     * Test of getDiachi method, of class NhanVienDTO.
     */
    @Test
    public void testGetDiachi() {
        String expResult = "15 duong 3/2";
        String result = instance.getDiachi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDiachi method, of class NhanVienDTO.
     */
    @Test
    public void testSetDiachi() {
        String test_Diachi = "15 duong 3/2";
        NhanVienDTO instance = new NhanVienDTO();
        instance.setDiachi(test_Diachi);
        assertEquals(test_Diachi, instance.diachi);
    }

    /**
     * Test of getGioitinh method, of class NhanVienDTO.
     */
    @Test
    public void testGetGioitinh() {
        int expResult = 0;
        int result = instance.getGioitinh();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGioitinh method, of class NhanVienDTO.
     */
    @Test
    public void testSetGioitinh() {
        int test_Gioitinh = 0;
        NhanVienDTO instance = new NhanVienDTO();
        instance.setGioitinh(test_Gioitinh);
        assertEquals(test_Gioitinh, instance.gioitinh);
    }

    /**
     * Test of getTinhtrang method, of class NhanVienDTO.
     */
    @Test
    public void testGetTinhtrang() {
        int expResult = 1;
        int result = instance.getTinhtrang();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTinhtrang method, of class NhanVienDTO.
     */
    @Test
    public void testSetTinhtrang() {
        int test_Tinhtrang = 1;
        NhanVienDTO instance = new NhanVienDTO();
        instance.setTinhtrang(test_Tinhtrang);
        assertEquals(test_Tinhtrang, instance.tinhtrang);
    }

    /**
     * Test of getHinhanh method, of class NhanVienDTO.
     */
    @Test
    public void testGetHinhanh() {
        String expResult = "gia vo day la hinh anh";
        String result = instance.getHinhanh();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHinhanh method, of class NhanVienDTO.
     */
    @Test
    public void testSetHinhanh() {
        String test_Hinhanh = "gia vo day la hinh anh";
        NhanVienDTO instance = new NhanVienDTO();
        instance.setHinhanh(test_Hinhanh);
        assertEquals(test_Hinhanh, instance.hinhanh);
    }

    /**
     * Test of getVisible method, of class NhanVienDTO.
     */
    @Test
    public void testGetVisible() {
        int expResult = 0;
        int result = instance.getVisible();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVisible method, of class NhanVienDTO.
     */
    @Test
    public void testSetVisible() {
        int test_Visible = 0;
        NhanVienDTO instance = new NhanVienDTO();
        instance.setVisible(test_Visible);
        assertEquals(test_Visible, instance.visible);
    }
    
}
