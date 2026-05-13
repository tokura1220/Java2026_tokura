#include<stdio.h>

typedef char String[1024];

int main(void) {
	typedef struct {
		String name;
		String SSkil;
		int attack;
	}Pmember;
	Pmember c1 = { "勇者","スマッシュソード",450 };
	Pmember c2 = { "魔女","聖なる祈り", 380};
	Pmember c3 = { "スライム","溶ける",10 };

	printf("キャラクター紹介\n");
	
	const String TEMPLATE ="キャラ%d: %s / 得意技 : % s / 攻撃力 : % d\n";

	printf(TEMPLATE,1, c1.name, c1.SSkil, c1.attack);
	printf(TEMPLATE,2, c2.name, c2.SSkil, c2.attack);
	printf(TEMPLATE,3, c3.name, c3.SSkil, c3.attack);
		
}