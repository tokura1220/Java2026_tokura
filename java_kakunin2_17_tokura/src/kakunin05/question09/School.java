package kakunin05.question09;

/**
 * メソッド
 */
class School {

	Student[] students = new Student[3];
	int lastIdx = 0;
	
	// 2
	void setStudent(Student s){
		if(lastIdx < students.length) {
			students[lastIdx] = s;
			lastIdx++;
			System.out.println("席" + (lastIdx) + "に登録しました。");
			
		}else {
			System.out.println("教室が一杯です。");
		}
	}
	

	// 3
	void  listStudents(){
		System.out.println("---席順リスト---");
		for (int i = 0; i < 3 ; i++) {
			System.out.println("席" + (i+1) + " 番号:" + students[i].num +  " 名前:" + students[i].name);
		}
		
	}

}
