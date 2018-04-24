package com.aestheticintegration.realjava;

import com.aestheticintegration.realjava.dataobject.Animal;
import com.aestheticintegration.realjava.dataobject.Pet;

public class SimpleProg {
	private Animal animal1 = new Animal("My Dog", 10.0f, 3.0f);
	private Animal animal2 = new Animal("My Cat", 1.22f, 9.9f);
	
	// Boolean
	public Boolean myFunc2(boolean param1, boolean param2) {
		return (param1 == param2);
	}
	public Boolean myFunc2a(int param1, String  param2, Boolean param3) {
		return (param1 == 123 ? true :
				param2.equals("abc") ? true :
				param3 ? true : false);
	}

	// Datatype
	public Animal myTest5(Animal animal) {
		return (animal.getAge() >= 2.0 ? this.animal1 : new Animal("Your Cat", 1.0f, 88.0f));
	}
	public String myTest5a(Pet pet) {
		return (pet.getOwner().equals("Uncle Sam") ? "USA" : "UK");
	}
	public Animal myTest5b(int param) throws Exception {
		if (param == 0) {
			throw new Exception("Wrong_param");
		} else if (param == 1) {
			return new Animal("Your Cat", 1.0f, 8.0f);
		}
		return this.animal2;
	}
	
	// Float
	public float myFunc3(int value) {
		if (value==123) {
			return 4.44f;
		} else if (value==321) {
			return 88.f;
		}
		return 3.22f;
	}
	public float myFunc3a(Boolean value) {
		if (value) {
			if (33 == 321) return 88.f;
			return 3.22f;
		}
		return 0f;
	}
	// Integer
	public Long myTest1(Integer param1, Boolean param2) {
		return (param1 == 0 ? 8811L : (param2 ? 44L : 33L));
	}
	public long myTest1a(Integer cityTemp)  {
		if (cityTemp == 0) {
			return 8;
		}
		return 33;
	}
	public long myTest1b(Float param1) throws Exception {
		if (param1 == 0) {
			throw new Exception("Wrong input for this function");
		} else if (param1 == 1) {
			throw new Exception("Do not use this input");
		}
		return 33;
	}
	public long myTest1c(float param1) throws Exception {
		if (param1 == 0) {
			throw new Exception("Wrong input for this function");
		} else if (param1 == 1) {
			throw new Exception("Do not use this input");
		}
		return 33;
	}
	public long myTest1c(Integer cityTemp)  {
		if (cityTemp == 0) {
			return 8;
		}
		return 33;
	}
	
	// String
	public String myFunc4(String value) {
		return (value.equals("ABC") ? "AAA" : "BBBBB");
	}
	public String myFunc4a(int value) {
		return (value == 123 ? "QWE111" : "QWE222");
	}
	public String myFunc4b(Boolean value1, Integer value2, Float value3) {
		return (value1 == true ? (value2 == 1 ? "QWE111" : (value3 <= 0.0 ? "KU" : "AGU")) : "QWE222");
	}
	
	// testOutput
	public Animal myTest6c() {
		return animal1;
	}
	public int myTest6c2() {
		return 2;
	}
	public Animal myTest6c3() {
		return this.myTest6c();
	}
}
