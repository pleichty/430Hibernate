package hibernateDemo;

import java.util.HashSet;
import java.util.Set;
 
public class Student {
    Long id;
    String email;
    String name;
    String address;
    Classification year;
    Set<Course> courseList;
    public Student(){
    	courseList = new HashSet<Course>();
    }
    public Long getId() {
        return id;
    }
    public Set<Course> getCourseList(){
    	return courseList;
    }
    public void setCourseList(Set<Course> courseList){
    	this.courseList = courseList;
    }
    public void addCourse(Course course){
    	courseList.add(course);
    }
    public Classification getYear(){
    	return year;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail(){
    	return email;
    }
    public void setEmail(String email){
    	this.email = email;
    }
    public void setYear(Classification year){
    	this.year = year;
    }
    public void setName(String name) {
        this.name = name;
    }
    private void setId(Long id) {
        this.id = id;
    }
    public void setAddress(String address) {
        this.address = address;
    }

} 