#include <stdio.h>

int main (void)
{
	printf("処理を開始します。\n");
	int iNumber = 9;
	if(iNumber >= 10){
		printf("iNumber の値は %d 以上です。 \n",10);
	}
	else {
		printf("iNumber の値は %d 未満です。 \n",10);
	}
	printf("\n処理を終了します。 ");
	return 0;

}