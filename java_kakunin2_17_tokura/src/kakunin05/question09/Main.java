package kakunin05.question09;

/**
 * メソッド
 */
public class Main {
	public static void main(String[] args) {

		// 1
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		
		s1.setProf(10, "太郎");
		s2.setProf(11, "花子");
		s3.setProf(12, "春男");
		s4.setProf(13, "夏子");
		
		
		System.out.println(s1.num + "番、" + s1.name + "です。");
		System.out.println(s2.num + "番、" + s2.name + "です。");
		System.out.println(s3.num + "番、" + s3.name + "です。");
		System.out.println(s4.num + "番、" + s4.name + "です。");
		
		

		// 2
		School school = new School();
		school.setStudent(s1);
		school.setStudent(s2);
		school.setStudent(s3);
		school.setStudent(s4);
		

		// 3
		school.listStudents();
		

	}
}
