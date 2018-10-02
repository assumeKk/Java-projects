/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Baokang
 */
public class StudyMilestone {

    private String milestoneName;
    private String target;
    private int progress;

    public StudyMilestone() {

    }
    //selects name and progress
        public DefaultListModel selectMilestoneTable1() throws SQLException, ClassNotFoundException {

        Connection c = null;
        Statement stmt = null;
        DefaultListModel DLM = new DefaultListModel();
//        JTextArea tArea = new JTextArea();
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:planner.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM MILESTONE");

        while (rs.next()) {
            int milestone_ID = rs.getInt("MILESTONE_ID");
            String milestone_Name = rs.getString("MILESTONE_NAME");
            String milestone_Target = rs.getString("TARGET");
            int milestone_Progress = rs.getInt("PROGRESS");

            System.out.println("Milestone ID = " + milestone_ID);
            System.out.println("MileStone Name = " + milestone_Name);
            System.out.println("Target = " + milestone_Target);
            System.out.println("Progress = " + milestone_Progress);
            System.out.println();
            DLM.addElement(milestone_Progress + "% Done");
            DLM.addElement(milestone_Name);

             DLM.addElement("------------------------------------------------");
            
        }
        rs.close();
        stmt.close();
        c.commit();
        c.close();
        return DLM;
    }
    
    
    public DefaultListModel selectMilestoneTable() throws SQLException, ClassNotFoundException {

        Connection c = null;
        Statement stmt = null;
        DefaultListModel DLM = new DefaultListModel();
//        JTextArea tArea = new JTextArea();
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:planner.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM MILESTONE");

        while (rs.next()) {
            int milestone_ID = rs.getInt("MILESTONE_ID");
            String milestone_Name = rs.getString("MILESTONE_NAME");
            String milestone_Target = rs.getString("TARGET");
            int milestone_Progress = rs.getInt("PROGRESS");

            System.out.println("Milestone ID = " + milestone_ID);
            System.out.println("MileStone Name = " + milestone_Name);
            System.out.println("Target = " + milestone_Target);
            System.out.println("Progress = " + milestone_Progress);
            System.out.println();

            DLM.addElement(milestone_ID);
        }
        rs.close();
        stmt.close();
        c.commit();
        c.close();
        return DLM;
    }

    public DefaultListModel selectStudyMilestoneData(JList list) throws SQLException, ClassNotFoundException {
        int temp = (int) list.getSelectedValue();
        Connection c = null;
        Statement stmt = null;
        DefaultListModel DLM = new DefaultListModel();
//        JTextArea tArea = new JTextArea();
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:planner.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");
        System.out.println("temp=" + temp);
        stmt = c.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM MILESTONE WHERE MILESTONE_ID = " + temp + ";");

        while (rs.next()) {
            int milestone_ID = rs.getInt("MILESTONE_ID");
            String milestone_Name = rs.getString("MILESTONE_NAME");
            String milestone_Target = rs.getString("TARGET");
            int milestone_Progress = rs.getInt("PROGRESS");

            System.out.println("MileStone Name = " + milestone_Name);
            System.out.println("Milestone ID = " + milestone_ID);
            System.out.println("Target = " + milestone_Target);
            System.out.println("Progress = " + milestone_Progress);
            System.out.println();

            DLM.addElement("MileStone Name: " + milestone_Name);
            DLM.addElement("Milestone ID: " + milestone_ID);
            DLM.addElement("Target: " + milestone_Target);
            DLM.addElement("Progress: " + milestone_Progress);
            DLM.addElement("------------------------------------------------");
        }
        rs.close();
        stmt.close();
        c.commit();
        c.close();
        return DLM;
    }

    public void insertMilestoneData(int milestoneID, String milestoneName, String target, int progress) throws SQLException, ClassNotFoundException {
        Connection c = null;
        Statement stmt = null;

        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:planner.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");
        stmt = c.createStatement();
        String sql = "";
        sql = "INSERT INTO MILESTONE(MILESTONE_ID, MILESTONE_NAME, TARGET, PROGRESS)"
                + "VALUES(" + milestoneID + ",'" + milestoneName + "','" + target + "'," + progress + ");";
//        System.out.println(sql);
        stmt.executeUpdate(sql);
        stmt.close();
        c.commit();
        c.close();
    }

    public void updateMilestoneData(int milestoneID,int progress ) throws ClassNotFoundException, SQLException {
        Connection c = null;
        Statement stmt = null;

        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:planner.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");
        stmt = c.createStatement();
        String sql = "";
        sql = "UPDATE MILESTONE "
                + "SET PROGRESS = " + progress 
                + " WHERE MILESTONE_ID = " + milestoneID + ";";
        stmt.executeUpdate(sql);
        stmt.close();
        c.commit();
        c.close();
    }

}
