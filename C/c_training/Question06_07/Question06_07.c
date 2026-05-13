#include<stdio.h>
#include <stdlib.h> 

typedef char String[1024];

int main(void) {

	String Strnum;

	typedef struct {
		int Etest;
		int Stest;
		int Rtest;
		int Ktest;
		int Ttest;

	}Score;

	Score Test = {0,0,0,0,0};

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
	Test.Ttest= atoi(Strnum);


	int iSum = Test.Etest + Test.Stest + Test.Rtest + Test.Ktest + Test.Ttest;
	double dSum = iSum;
	double iAve = dSum / 5;

	printf("5 科目の合計点 : %d 点\n", iSum);
	printf("5 科目の平均点 : %.1f 点\n", iAve);

	if (iAve >= 80) {
		printf("優秀！！");
	}else if (iAve >= 50){
		printf("平均的");
	}
	else if (iAve >= 30) {
		printf("及第");
	}
	else  {
		printf("追試が必要");
	}

}

	/*while (inum < 5) {
		printf("5 以上の数値を入力してください \n");
		scanf("%s", Strnum);
		inum = atoi(Strnum);
	}*/
	