package kakunin06.question11;

/**
 * オーバーロード
 */
public class Main {
	public static void main(String[] args) {
		
		

		// 1
		School school = new School();
		school.setStudent(10,"太郎");
		school.setStudent(11,"花子");
		school.setStudent(12,"春男");
		

		// 2
		System.out.println("---席2の学生---");
		Student s = school.getStudentBySeat(2);
		school.showStudent(s);

		// 3
		school.showStudent();

	}
}
