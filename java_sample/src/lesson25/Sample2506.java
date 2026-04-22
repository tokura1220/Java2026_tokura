package lesson25;

public class Sample2506 {
	public static void main(String[] args) {
		try {
			//throwMyException()を実行。
			throwMyException();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("例外が発生したため終了します");
		}
	}

	public static void throwMyException() throws MyException {
		//意図的に例外を発生させる
		throw new MyException("独自に作成した例外です。");
	}
}
