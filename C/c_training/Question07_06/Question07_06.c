#include<stdio.h>
#include <stdlib.h> 

typedef char String[1024];

int main(void) {

	String Strnum;

	typedef struct {
		char name;
		int Etest;
		int Stest;
		int Rtest;
		int Ktest;
		int Ttest;
		int iSum;
		double dAvg;
	}Score;

	Score students[] = {}
	
	for (int i = 0; i < 3; i++) {

		Score Test = { 0,0,0,0,0,0 };
		printf("---%d人目の情報を入力してください---\n", i + 1);

		printf("苗字の頭文字をアルファベット 1 文字で入力してください: ");
		scanf("%s", Strnum);
		Test.name = Strnum[0];

		printf("英語の点数を入力してください:");
		scanf("%s", Strnum);
		Test.Etest = atoi(Strnum);

		printf("数学の点数を入力してください:");
		scanf("%s", Strnum);
		Test.Ktest = atoi(Strnum);

		printf("歴史の点数を入力してください:");
		scanf("%s", Strnum);
		Test.Rtest = atoi(Strnum);

		printf("科学の点数を入力してください:");
		scanf("%s", Strnum);
		Test.Stest = atoi(Strnum);

		printf("地理の点数を入力してください:");
		scanf("%s", Strnum);
		Test.Ttest = atoi(Strnum);

		int iSum = Test.Etest + Test.Stest + Test.Rtest + Test.Ktest + Test.Ttest;
		double dSum = iSum;
		double iAve = dSum / 5;

		//配列への格納


	}
	for (int i = 0; i < 3; i++) {
		printf("---%cさんのテスト結果---\n", students[i].名前);
		//表示処理
	}




}

	/*while (inum < 5) {
		printf("5 以上の数値を入力してください \n");
		scanf("%s", Strnum);
		inum = atoi(Strnum);
	}*/
	