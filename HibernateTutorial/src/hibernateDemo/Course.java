package hibernateDemo;

public class Course {

	Long id;
	String name;
	String courseID;
	Student student;
	public Course(){
		
	}
	public Long getId(){
		return id;
	}
    private void setId(Long id) {
        this.id = id;
    }
    public Student getStudent(){
    	return student;
    }
    public void setStudent(Student student){
    	this.student = student;
    }
	public String getCourseID(){
		return courseID;
	}
	public void setCourseID(String id){
		this.courseID = id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
}
