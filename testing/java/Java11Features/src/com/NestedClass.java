package com;

public class NestedClass {
	
	private void display() {
		System.out.println("Hello from Nested Class!");
	}
	
	class NestedIn{
		void msg() {
			display();
		}
	}

	public static void main(String[] args) {

		NestedClass nest = new NestedClass();
		NestedClass.NestedIn in = nest.new NestedIn();
		in.msg();
	}

}
