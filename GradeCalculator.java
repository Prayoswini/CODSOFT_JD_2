import java.util.*;
class Subject{
    String name;
    int marks;

    Subject(String name,int marks){
        this.name=name;
        this.marks=marks;
    }
     
    String TogetGrade(){
        if(marks >= 90) return "A+";
        else if(marks >=80) return "A";
        else if(marks >=70) return "B";
        else if(marks >=60) return "C";
        else if(marks >=50) return "D";
        else return "F";
    }
}
class Student{
    String name;
    ArrayList <Subject> subjects=new ArrayList<> ();
    ArrayList<Student> students = new ArrayList<>();
    

    Student(String name){
        this.name = name;
    }
    void addSubject(String subjectName, int marks){
        subjects.add(new Subject(subjectName,marks));
    }
    int TogetTotalMarks(){
        int totalSum=0;
        for(Subject s : subjects) totalSum +=s.marks;
        return totalSum;
    }
    double TogetAverage(){
        return (double) TogetTotalMarks() / subjects.size(); 
    }
    String TogetFinalGrade(){
        double avg = TogetAverage();
        if(avg >=90) return "A+";
        else if (avg >=80) return "A";
        else if (avg >=70) return "B";
        else if (avg >=60) return "C";
        else if (avg >=50) return "D";
        else return "F";
    }
    void printReport(){
        System.err.println("**************************");
        System.out.println("Grade Report for "+name);
        System.out.printf("%-15s %-10s %-10s\n", "Subject", "Marks", "Grade");
        for(Subject s: subjects){
            System.out.printf("%-15s %-10d %-10s\n", s.name, s.marks, s.TogetGrade());
        }
        System.out.println("---------------------------------");
        System.out.println("Total Marks:"+TogetTotalMarks());
        System.out.printf("Average: %.2f%%\n",TogetAverage());
        System.out.println("Final Grade:"+TogetFinalGrade());
    }

}
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students =new ArrayList<>();

       System.out.print("How many students' records do you want to enter? ");
        int studentCount= sc.nextInt();
        sc.nextLine();

        for(int i =0;i < studentCount ; i++){ 
            System.out.println("\n Enter the Name of Student " + (i + 1) + " :  ");
            String name= sc.nextLine();
            Student student = new Student(name);
 
            System.out.println("Enter number of subjects: ");
            int subjectCount=sc.nextInt();
            sc.nextLine();

            for(int j =0;j < subjectCount;j++){ 
                System.out.println("Enter Subject "+  (j + 1 )   +  " name:"    );
                String subjectName= sc.nextLine();

                int marks;
                while(true){ 
                    System.out.println("Enter Marks for "+  subjectName+ " :");
                    marks=sc.nextInt();
                    if(marks >= 0 && marks <=100) break;
                    System.err.println("Marks must be between 0 and 100.");
                }
                sc.nextLine();
                student.addSubject(subjectName, marks);
            }
            students.add(student);
            
        }
        for(Student s : students){
            s.printReport();
        }
    } 
}

