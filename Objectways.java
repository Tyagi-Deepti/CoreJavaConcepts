package JavaBasicConcept;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Objectways implements Cloneable,Serializable {
	
	public Objectways() {
		System.out.println("Contructor called");
	}
	public void display(String type) {
		
		// TODO Auto-generated method stub
		System.out.println("In display method" + " " + type);
	}
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, CloneNotSupportedException, IOException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException   {
		
		//using new keyword
		Objectways obj = new Objectways();
		obj.display("using new");
		
		//Using New Instance (when we know the name of public class)
		Class cls = Class.forName("JavaBasicConcept.Objectways"); // Loads class here
		Objectways obj1 = (Objectways) cls.newInstance(); //Create instance here.
		obj1.display("Using New Instance");
			
		// using clone method
		// always implement class to clonable interface 
		//clone() is use for copy the object.
		Objectways obj2 = new Objectways();
		Objectways obj3 = (Objectways) obj2.clone();
		obj3.display("using clone");
			
		//Serialization
		
		FileOutputStream fsFileOutputStream = new FileOutputStream("file.txt");
		ObjectOutputStream osOutputStream = new ObjectOutputStream(fsFileOutputStream);
		Objectways obj4 = new Objectways();
		osOutputStream.writeObject(obj4);

		
		//DeSerialization
		FileInputStream fileInputStream = new FileInputStream("file.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Objectways obj5 =  (Objectways) objectInputStream.readObject();
		obj5.display("using deserialization");
		
		//Using constructor 
		Constructor<Objectways> cons = Objectways.class.getDeclaredConstructor();
		Objectways obj6 = cons.newInstance();
		obj6.display("using constructor");;

	}

}
