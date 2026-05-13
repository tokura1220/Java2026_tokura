#include<stdio.h>

typedef char String[1024];

int main(void) {
	typedef struct {
		String name;
		int age;
	}cat;

	cat kotarou = { "コタロウ",7 };
	
	const String TEMPLATE = "名前は%sです\n年齢は%d歳です";
	printf(TEMPLATE, kotarou.name, kotarou.age);
}