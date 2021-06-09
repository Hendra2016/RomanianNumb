public class RomanianNumber {

	public static void main(String[] ar) throws Exception {
		if (ar.length < 1) {
			throw new Exception("argument must fill ");
		}
		new RomanianNumber(ar[0]);
	}

	private int searchMap(String word) {
		if (Romanian.I.data.equals(word)) {
			return Romanian.I.label;
		} else if (Romanian.V.data.equals(word)) {
			return Romanian.V.label;
		} else if (Romanian.X.data.equals(word)) {
			return Romanian.X.label;
		} else if (Romanian.L.data.equals(word)) {
			return Romanian.L.label;
		} else if (Romanian.C.data.equals(word)) {
			return Romanian.C.label;
		} else if (Romanian.D.data.equals(word)) {
			return Romanian.D.label;
		} else if (Romanian.M.data.equals(word)) {
			return Romanian.M.label;
		} else
			return 0;
	}

	public RomanianNumber(String data) {
		char[] b = data.toCharArray();
		int result = 0;
		for (int i = 0; i < b.length; i++) {
			int first = searchMap(String.valueOf(b[i]));
			int second = 0;
			//see other value for compare the value every 2 char
			if (i + 1 < b.length) {
				second = searchMap(String.valueOf(b[i + 1]));
				if (first > second) {
					result = result + first;
				} else {
					// if the second value is bigger than the first data
					// like IV = I= 1 then V = 5 then V bigger than I so 5-1
					result = result + (second - first);
					i = i + 1;
				}
			} else {
				result = result + first;
			}
		}
		System.out.println(result);
	}

}

enum Romanian {
	I("I", 1), V("V", 5), X("X", 10), L("L", 50), C("C", 100), D("D", 500), M("M", 1000);

	public final int label;
	public final String data;

	private Romanian(String data, int label) {
		this.data = data;
		this.label = label;
	}

}