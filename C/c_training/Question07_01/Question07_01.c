#include <stdio.h> 

int main(void) {

	int Score [5];

	Score[0] = 88;
	Score[1] = 63;
	Score[2] = 54;
	Score[3] = 76;
	Score[4] = 45;

	int iSum = 0;

	for (int i = 0; i < 5; i++) {
		
		iSum  +=  Score[i];

	}
	
	/*int iEnglish = 88;
	int iMath = 63;
	int iHistory = 54;
	int iScience = 76;
	int iGeography = 45;

	int iSum = iEnglish + iMath + iHistory + iScience + iGeography;*/

	printf("5 科目の合計点 : %d 点\n", iSum);
	printf("5 科目の平均点 : %.1f 点\n", (double)iSum / 5);

	return 0;
}