package kakunin06.question12;

/**
 * コンストラクタ
 */
public class Main {
	public static void main(String[] args) {

		// 1
		School school = new School(4);
		

		// 2
		Student s1 = new Student(10,"太郎");
		Student s2 = new Student(11,"花子");
		Student s3 = new Student(12,"春男");
		Student s4 = new Student();
		
		
		

		// 3
		school.attendStudent(s1);
		school.attendStudent(s2);
		school.attendStudent(s3);
		school.attendStudent(s4);
		

	}
}
