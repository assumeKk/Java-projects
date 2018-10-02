/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planner;

import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Baokang
 */
public class SemesterTest {
    
    public SemesterTest() {
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
     * Test of getSemester method, of class Semester.
     */
    @Test
    public void testGetSemester() {
        System.out.println("getSemester");
        Semester instance = new Semester();
        String expResult = "";
        String result = instance.getSemester();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSemester method, of class Semester.
     */
    @Test
    public void testSetSemester() {
        System.out.println("setSemester");
        String semester = "";
        Semester instance = new Semester();
        instance.setSemester(semester);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addModule method, of class Semester.
     */
    @Test
    public void testAddModule() throws Exception {
        System.out.println("addModule");
        Module temp = null;
        Semester instance = new Semester();
        instance.addModule(temp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aRow method, of class Semester.
     */
    @Test
    public void testARow() {
        System.out.println("aRow");
        String[] temp = null;
        Semester instance = new Semester();
        String expResult = "";
        String result = instance.aRow(temp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModuleID method, of class Semester.
     */
    @Test
    public void testGetModuleID() {
        System.out.println("getModuleID");
        Semester instance = new Semester();
        String expResult = "";
        String result = instance.getModuleID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModuleID method, of class Semester.
     */
    @Test
    public void testSetModuleID() {
        System.out.println("setModuleID");
        String moduleID = "";
        Semester instance = new Semester();
        instance.setModuleID(moduleID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModuleName method, of class Semester.
     */
    @Test
    public void testGetModuleName() {
        System.out.println("getModuleName");
        Semester instance = new Semester();
        String expResult = "";
        String result = instance.getModuleName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModuleName method, of class Semester.
     */
    @Test
    public void testSetModuleName() {
        System.out.println("setModuleName");
        String moduleName = "";
        Semester instance = new Semester();
        instance.setModuleName(moduleName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourseworkName method, of class Semester.
     */
    @Test
    public void testGetCourseworkName() {
        System.out.println("getCourseworkName");
        Semester instance = new Semester();
        String expResult = "";
        String result = instance.getCourseworkName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCourseworkName method, of class Semester.
     */
    @Test
    public void testSetCourseworkName() {
        System.out.println("setCourseworkName");
        String courseworkName = "";
        Semester instance = new Semester();
        instance.setCourseworkName(courseworkName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourseworkDeadline method, of class Semester.
     */
    @Test
    public void testGetCourseworkDeadline() {
        System.out.println("getCourseworkDeadline");
        Semester instance = new Semester();
        Date expResult = null;
        Date result = instance.getCourseworkDeadline();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCourseworkDeadline method, of class Semester.
     */
    @Test
    public void testSetCourseworkDeadline() {
        System.out.println("setCourseworkDeadline");
        Date courseworkDeadline = null;
        Semester instance = new Semester();
        instance.setCourseworkDeadline(courseworkDeadline);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExamDate method, of class Semester.
     */
    @Test
    public void testGetExamDate() {
        System.out.println("getExamDate");
        Semester instance = new Semester();
        Date expResult = null;
        Date result = instance.getExamDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExamDate method, of class Semester.
     */
    @Test
    public void testSetExamDate() {
        System.out.println("setExamDate");
        Date examDate = null;
        Semester instance = new Semester();
        instance.setExamDate(examDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExamTime method, of class Semester.
     */
    @Test
    public void testGetExamTime() {
        System.out.println("getExamTime");
        Semester instance = new Semester();
        String expResult = "";
        String result = instance.getExamTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExamTime method, of class Semester.
     */
    @Test
    public void testSetExamTime() {
        System.out.println("setExamTime");
        String examTime = "";
        Semester instance = new Semester();
        instance.setExamTime(examTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExamLength method, of class Semester.
     */
    @Test
    public void testGetExamLength() {
        System.out.println("getExamLength");
        Semester instance = new Semester();
        int expResult = 0;
        int result = instance.getExamLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExamLength method, of class Semester.
     */
    @Test
    public void testSetExamLength() {
        System.out.println("setExamLength");
        int examLength = 0;
        Semester instance = new Semester();
        instance.setExamLength(examLength);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModule method, of class Semester.
     */
    @Test
    public void testGetModule() {
        System.out.println("getModule");
        Semester instance = new Semester();
        ArrayList<Module> expResult = null;
        ArrayList<Module> result = instance.getModule();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModule method, of class Semester.
     */
    @Test
    public void testSetModule() {
        System.out.println("setModule");
        ArrayList<Module> module = null;
        Semester instance = new Semester();
        instance.setModule(module);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertSemesterData method, of class Semester.
     */
    @Test
    public void testInsertSemesterData() throws Exception {
        System.out.println("insertSemesterData");
        int semesterID = 0;
        String semesterName = "";
        Semester.insertSemesterData(semesterID, semesterName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectSemesterTable method, of class Semester.
     */
    @Test
    public void testSelectSemesterTable() throws Exception {
        System.out.println("selectSemesterTable");
        Semester.selectSemesterTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
