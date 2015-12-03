package seating;

import java.util.ArrayList;
import java.util.List;

public class Seating {

    public static void main(String[] args) {
        List<Student> roster = new ArrayList<Student>();
        roster.add(new Student("Karen", 3));
        roster.add(new Student("Liz", 1));
        roster.add(new Student("Paul", 4));
        roster.add(new Student("Lester", 1));
        roster.add(new Student("Henry", 5));
        roster.add(new Student("Renee", 9));
        roster.add(new Student("Glen", 2));
        roster.add(new Student("David", 6));
        roster.add(new Student("Fran", 1));
        roster.add(new Student("Danny", 3));
        
        SeatingChart chart = new SeatingChart(roster, 3, 4);
        chart.print();
        System.out.println("num removed = " + chart.removeAbsentStudents(4));
        chart.print();
    }
}

class SeatingChart {
    
    private List<Student> roster;
    private Student[][] seats;
    
    SeatingChart(List<Student> studentList, int rows, int cols) {
        seats = new Student[rows][cols];
        roster = studentList;
        
        int studentIndex = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (studentIndex < roster.size() && roster.get(studentIndex) != null)
                    seats[r][c] = roster.get(studentIndex);
                studentIndex++;
            }
        }
    }
    
    public int removeAbsentStudents(int numAbsences) {
        
        int numStudentsRemoved = 0;
        
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 4; c++) {
                if (seats[r][c] != null && seats[r][c].getAbsenceCount() >= numAbsences) {
                    seats[r][c] = null;
                    numStudentsRemoved++;
                }
            }
        }
        
        return numStudentsRemoved;
    }
    
    public void print() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 4; c++) {
                if (seats[r][c] != null)
                    System.out.print(seats[r][c].getName());
                else
                    System.out.print("EMPTY");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

class Student {
    
    private String name;
    private int absenceCount;
    
    Student(String _name, int _absenceCount) {
        name = _name;
        absenceCount = _absenceCount;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAbsenceCount() {
        return absenceCount;
    }
    
}
