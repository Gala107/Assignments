
// Callback example using Lambda Expression
class MyObject {
	public void myMethod(Callback callback) {
		// Do some work here
		callback.call();
	}
}

interface Callback {
	void call();
}

public class CallbackWithLambda {

	public static void main(String... args) {
		MyObject myObject = new MyObject();
		myObject.myMethod(() -> System.out.println("Callback called"));
	}
}
