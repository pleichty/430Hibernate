package hibernateDemo;

import javax.persistence.Entity;

@Entity
public class TeachingAssistant extends Student{
/**
 * Teaching assistants will inherit all mapping
 * information from student entity
 */
	public TeachingAssistant(){
		
	}
}
