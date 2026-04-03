import PageObject.programmtest;

public class DevoneCode {

	public void leanthofstring() {
		String name = "Kirtesh";
		int leanth;
		leanth = name.length();
		System.out.println(leanth);
	}

	public void ReverseString() {

		String name = "Kirtesh";
		String revese = "";

		for (int i = name.length() - 1; i >= 0; i--) {
			revese = revese + name.charAt(i);

		}
		System.out.println(revese);

	}

	public void BiggestNumber() {

		int a = 10;
		int b = 11;
		int c = 9;

		if (a > b && a > c) {
			System.out.println("a is biggest");
		}
		if (b > a && b > c) {
			System.out.println("b is biggest");
		} else {
			System.out.println("c is biggest");
		}

	}

	public void aastring() {

		String a = "$ 45.99";
		String b = "$ 101";

		String replacea = a.replace("$ ", "");
		String replaceb = b.replace("$ ", "");
		double valuea = Double.parseDouble(replacea);
		double valueb = Double.parseDouble(replaceb);
		System.out.println(valuea + valueb);
	}

	public static void main(String[] args) {

		programmtest pt = new programmtest();
		pt.leanthofstring();
		pt.ReverseString();
		pt.BiggestNumber();
		pt.aastring();

	}

}
