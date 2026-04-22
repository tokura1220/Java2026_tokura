package lib;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;

public class TestUtil extends PrintStream {

	private StringBuilder sb;

	public TestUtil() {
        super(new ByteArrayOutputStream());
        System.setOut(new PrintStream(this));
    }

    public void append(String str){
    	if (sb == null) sb = new StringBuilder();
        sb.append(str).append(System.lineSeparator());
    }
    
    public void setIn(){
    	System.setIn(new ByteArrayInputStream(sb.toString().getBytes()));
    	sb = null;
    }

    public void setErr(){
        System.setErr(new PrintStream(this));
    }

    public void setDefault(){
        System.setIn(System.in);
        System.setOut(System.out);
        System.setErr(System.err);
    }
    
    public String printAll() {
//    	System.err.println(((ByteArrayOutputStream) out).toString());
    	var o = ((ByteArrayOutputStream) out).toString();
    	out = null;
    	return o;
    }

    public String[] printByArray() {
    	return printAll().split(System.lineSeparator());
    }

    
    public String printErr(String o) {
    	return "あなたの出力 ==> " + o + System.lineSeparator();
    }
    
    public void assertEquals(String expected, String actual) {
    	Assertions.assertEquals(expected, actual, printErr(actual));
    }
    
    public void assertContains(String expected, String actual) {
    	Assertions.assertTrue(actual.contains(expected), printErr(actual));
    }
    
    public void assertTrue(Boolean expected, String actual) {
    	Assertions.assertTrue(expected, printErr(actual));
    }

}