import java.util.ArrayList;
import java.util.List;

 abstract class School {
     private String name;
     private int id;

     public School(String name, int id) {
         this.name = name;
         this.id = id;
     }

     public String getName() {
         return name;

     }

     public int getId() {
         return id;

     }

     public abstract void displayInfo();
 }


    class Students extends School{
        private List<Course> enrolledCourses;

      public Students(String name,int id){

          super(name,id);
          this.enrolledCourses=new ArrayList<>();
  }
  public void enrollCourse(Course course){
          enrolledCourses.add(course);
  }
  public void printEnrolledCourses(){
      System.out.println("Courses enrolled by : "+getName());
      if(enrolledCourses.isEmpty()){
          System.out.println("No courses enrolled");
      }else {
          for(Course course:enrolledCourses){
              System.out.println(course.getCourseName());
          }
      }

  }
  public void displayInfo(){
      System.out.println("Student Name : "+getName());
      System.out.println("Student ID : "+getId());

  }
     }

     class Faculty extends School{
        public Faculty(String name , int id){
            super(name, id);

        }
        @Override
        public void displayInfo(){
            System.out.println("Faculty Name : "+getName());
            System.out.println("Faculty ID : "+getId());
        }
     }

     class Staff extends School{
        public Staff(String name,int id){
            super(name, id);

        }
        @Override
        public void displayInfo(){
            System.out.println("Staff Name : "+getName());
            System.out.println("Staff ID : "+getId());
        }
     }

     class Course{
         private String courseName;
         private Faculty instructor;

         public Course(String courseName,Faculty instructor){
             this.courseName=courseName;
             this.instructor=instructor;

         }
         public String getCourseName(){
             return courseName;
         }
         public  Faculty getInstructor(){
             return instructor;
         }
         public void displayInfo(){
             System.out.println("Course Name : "+courseName);
             System.out.println("Instructor : "+instructor.getName());
         }

     }

    class Department{
        private String departmentName;
        private List<Course> courses;
        private List<Faculty> facultyMembers;

        public Department(String departmentName){
            this.departmentName=departmentName;
            this.courses=new ArrayList<>();
            this.facultyMembers=new ArrayList<>();

        }
        public void addCourse(Course course){
            courses.add(course);

        }
        public void addFaculty(Faculty faculty){
            facultyMembers.add(faculty);
        }
        public void displayInfo(){
            System.out.println("Department Name : "+departmentName);
            System.out.println("Course : ");
            if (courses.isEmpty()){
                System.out.println("No courses available");
            }else{
                for(Course course:courses){
                    course.displayInfo();
                }
            }
            System.out.println("Faculty Member : ");
            if (facultyMembers.isEmpty()){
                System.out.println("no faculty members available");
            }else {
                for (Faculty faculty:facultyMembers){
                    faculty.displayInfo();
                }
            }
        }
    }

public class Main {
    public static void main(String[] args) {

        Faculty drSmith = new Faculty("Dr. Smith",150);
        Faculty drJohn = new Faculty("Dr. John",340);

        Course math = new Course("Math",drJohn);
        Course english = new Course("English",drJohn);

        Department mathDepartment = new Department("Math");
        mathDepartment.addCourse(english);

        mathDepartment.addFaculty(drSmith);

        Students maryJane = new Students("Mary Jane",12);
        maryJane.enrollCourse(english);

        maryJane.printEnrolledCourses();
        maryJane.displayInfo();

        mathDepartment.displayInfo();

}
    }