package pkgException;

import java.util.Date;
import com.cisc181.core.Person;

public class PersonException extends Exception{
	private Person person;
	
	public PersonException(Person person){
		super();
		this.person = person;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}


	
	
	
}
