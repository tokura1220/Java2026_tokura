#include <stdio.h> 
#include <stdlib.h>

typedef char String[1024];

int main(void) {
	String Strnum;

	int num[] = { 31,41,59,26,53,58,97,93,23,84 };

	printf("10～99 の 2 桁の数値を入力してください:");
	scanf("%s",Strnum);
	int innum = atoi(Strnum);

	int h = -1;


	for (int i = 0; i < 10;i++) {
		if (innum == num[i]) {
			h = i;
		}
	}

	
	if (innum == num[h]) {
		printf(" %d は、 %d の位置に見つかりました", innum, h);
	}
	else
	{
		printf("%d は、見つかりませんでした", innum);
	}
	
	return 0;
}