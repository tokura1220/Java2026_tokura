package kakunin06.question12;

/**
 * コンストラクタ
 */
public class School {

	private Student[] students;
	private int lastIdx;

	// 1
	public School() {
		this.students =  new Student[3];
	}
	
	public School (int capacity) {
		this();
		this.students = new Student[capacity]; 
		lastIdx = 0;
		System.out.println("【スクール開講】座席数:" + capacity);
		
	}
	
	
	// 3
	
	public void attendStudent(Student s) {
		if( s.getNum() >= 1 && lastIdx < students.length) {
			students[lastIdx]=s;
			lastIdx++;
			System.out.println("【座席案内】席" + lastIdx + " 名前:" + s.getName());
		}
	}

}
