import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

class RomanianNumberTest {

	@Test
	void testMain() {
		System.out.println("main");
		FileInputStream fips = null;
		BufferedReader br = null;
		try {
			fips = new FileInputStream(new File("src/TestCase.txt"));
			br = new BufferedReader(new InputStreamReader(fips));
			String strLine;
			int lineNumber = 0;
			while ((strLine = br.readLine()) != null) {
				lineNumber++;
				String[] args = new String[] { strLine };
				RomanianNumber.main(args);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fips.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
