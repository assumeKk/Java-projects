package planner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ronan
 */
public class CaptureStudyProgress {
    private enum Activity{programming , writing};
    private int TimeContribution;
    //needs to be able to be linked to a task not sure how to link it
    private StudyTask TaskName; // i think this would work
    private int TimeSpent;
    private String Notes;

    public void setTimeContribution(int TimeContribution) {
        this.TimeContribution = TimeContribution;
    }

    public void setTaskName(StudyTask TaskName) {
        this.TaskName = TaskName;
    }

    public void setTimeSpent(int TimeSpent) {
        this.TimeSpent = TimeSpent;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public int getTimeContribution() {
        return TimeContribution;
    }

    public StudyTask getTaskName() {
        return TaskName;
    }

    public int getTimeSpent() {
        return TimeSpent;
    }

    public String getNotes() {
        return Notes;
    }
    
    // needs to return the time left 
    public int getTimeLeft(){
        return (this.TimeContribution - this.TimeSpent);
    }

    public CaptureStudyProgress(int TimeContribution, StudyTask TaskName, int TimeSpent, String Notes) {
        this.TimeContribution = TimeContribution;
        this.TaskName = TaskName;
        this.TimeSpent = TimeSpent;
        this.Notes = Notes;
    }

}