#include <stdio.h> 
#include <stdlib.h> 

typedef char String[1024];

int main(void) {

	String strInput = "";
	int inum = 0;

	printf("入力された月の日数を表示します。\n");
	printf("1～12 の数値を入力してください。\n");
	scanf("%s", strInput);
	inum = atoi(strInput);

	// ----修正対象ここから---- 

	switch (inum) {
	case 2:
		printf("2 月は 28 日もしくは 29 日です。");
		break;

	case 4:
	case 6:
	case 9:
	case 11:
		printf("%d 月は 30 日です。", inum);
		break;

	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:
		printf("%d 月は 31 日です。", inum);
		break;

	default:
		printf("%d 月はありません。", inum);


	}
	/*if (inum == 2) {
		printf("2 月は 28 日もしくは 29 日です。");
	}
	else if (inum == 4 || inum == 6 || inum == 9 || inum == 11) {
		printf("%d 月は 30 日です。", inum);
	}
	else if (inum == 1 || inum == 3 || inum == 5 || inum == 7
		|| inum == 8 || inum == 10 || inum == 12) {
		printf("%d 月は 31 日です。", inum);
	}
	else {
		printf("%d 月はありません。", inum);
	}*/
	// ----修正対象ここまで---- 
	return 0;
}