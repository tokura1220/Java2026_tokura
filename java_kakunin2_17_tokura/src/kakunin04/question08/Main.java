package kakunin04.question08;

/**
 * クラス
 */
public class Main {
	public static void main(String[] args) {

		// 1
		Student s1 = new Student();
		Student s2 = new Student();
		
		System.out.println(s1);
		System.out.println(s2);

		// 2
		s1.name = "太郎";
		s2.name = "花子";
		
		System.out.println("名前:" + s1.name);
		System.out.println("名前:" + s2.name);

		// 3
		School school1 = new School();
		school1.Students = new String[3];
		
		
		school1.Students[0] = s1.name;
		school1.Students[1] = s2.name;
		
		//System.out.println(school1.Students[0]);
		
		
		
		for (int i = 0; i < school1.Students.length;i++) {
			
			if (school1.Students[i] != null) {
				System.out.println((i + 1) + "人目は" + school1.Students[i]);
			}else {
				System.out.println((i + 1 )+ "人目はまだいません");
				
			}
			
			
		}
		
		
		

	}
}
