package model.loan.secure;


import enums.CourseType;
import enums.DegreeType;
import enums.EducationStream;
import model.assets.LoanProduct;

public class EducationLoan extends LoanProduct {

    private String courseName= null;
    private String collegeName = null;
    private CourseType courseType;
   private DegreeType degreeType;
   private EducationStream educationStream ;
   private  double totalFees;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public DegreeType getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(DegreeType degreeType) {
        this.degreeType = degreeType;
    }

    public EducationStream getEducationStream() {
        return educationStream;
    }

    public void setEducationStream(EducationStream educationStream) {
        this.educationStream = educationStream;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }
}
