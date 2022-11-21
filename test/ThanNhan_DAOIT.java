/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import DTO.ThanNhan_DTO;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TBL
 */
public class ThanNhan_DAOIT {
    
    public ThanNhan_DAOIT() {
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
     * Test of openConnection method, of class ThanNhan_DAO.
     */
    @Test
    public void testOpenConnection() {
        System.out.println("openConnection");
        ThanNhan_DAO instance = new ThanNhan_DAO();
        boolean expResult = false;
        boolean result = instance.openConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class ThanNhan_DAO.
     */
    @Test
    public void testCloseConnection() {
        System.out.println("closeConnection");
        ThanNhan_DAO instance = new ThanNhan_DAO();
        instance.closeConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllThanNhan method, of class ThanNhan_DAO.
     */
    @Test
    public void testGetAllThanNhan() {
        System.out.println("getAllThanNhan");
        ThanNhan_DAO instance = new ThanNhan_DAO();
        ArrayList<ThanNhan_DTO> expResult = null;
        ArrayList<ThanNhan_DTO> result = instance.getAllThanNhan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addThanNhan method, of class ThanNhan_DAO.
     */
    @Test
    public void testAddThanNhan() throws Exception {
        System.out.println("addThanNhan");
//        Test-case 2:
//        ThanNhan_DTO TN = new ThanNhan_DTO(26,"1","Nguyễn Văn An","Nguyễn Văn A","con trai","21/11/2021","0923855667",1);
//        Test-case 3:
//        ThanNhan_DTO TN = new ThanNhan_DTO(26,"0","Nguyễn Văn An","Nguyễn Văn A","con trai","2005/11/21","0923855667",1);
//      Test-case 5:
        ThanNhan_DTO TN = new ThanNhan_DTO(26,"1","Nguyễn Văn An","Nguyễn Văn A","con trai","2005/11/21","0923855667",1);
        ThanNhan_DAO instance = new ThanNhan_DAO();
        boolean expResult = true;
        boolean result = instance.addThanNhan(TN);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of delThanNhan method, of class ThanNhan_DAO.
     */
    @Test
    public void testDelThanNhan() throws Exception {
        System.out.println("delThanNhan");
        int id = 5;
        ThanNhan_DAO instance = new ThanNhan_DAO();
        boolean expResult = false;
        boolean result = instance.delThanNhan(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of suaThanNhan method, of class ThanNhan_DAO.
     */
    @Test
    public void testSuaThanNhan() throws Exception {
        System.out.println("suaThanNhan");
        ThanNhan_DTO TN = null;
        ThanNhan_DAO instance = new ThanNhan_DAO();
        boolean expResult = false;
        boolean result = instance.suaThanNhan(TN);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasThanNhanID method, of class ThanNhan_DAO.
     */
    @Test
    public void testHasThanNhanID() {
        System.out.println("hasThanNhanID");
        int id = 0;
        ThanNhan_DAO instance = new ThanNhan_DAO();
        boolean expResult = false;
        boolean result = instance.hasThanNhanID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckThanNhanID method, of class ThanNhan_DAO.
     */
    @Test
    public void testCheckThanNhanID() {
        System.out.println("CheckThanNhanID");
        String st = "";
        int i = 0;
        int stt = 0;
        ThanNhan_DAO instance = new ThanNhan_DAO();
        ArrayList<ThanNhan_DTO> expResult = null;
        ArrayList<ThanNhan_DTO> result = instance.CheckThanNhanID(st, i, stt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get1ThanNhan method, of class ThanNhan_DAO.
     */
    @Test
    public void testGet1ThanNhan() {
        System.out.println("get1ThanNhan");
        int i = 0;
        ThanNhan_DAO instance = new ThanNhan_DAO();
        ThanNhan_DTO expResult = null;
        ThanNhan_DTO result = instance.get1ThanNhan(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
