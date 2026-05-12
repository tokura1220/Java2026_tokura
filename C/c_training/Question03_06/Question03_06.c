#include <stdio.h>

int main(void) {
	int inum1 = 15;
	int inum2 = 5;
	
	printf("1 回目 割り算の結果は、%d、",inum1 / inum2);
	printf("余りは、%d\n", inum1 % inum2);
	printf("2 回目 割り算の結果は、%d、",++inum1 / inum2);
	printf("余りは、%d\n", inum1 % inum2);
	printf("3 回目 割り算の結果は、%d、",++inum1 / inum2);
	printf("余りは、%d\n", inum1 % inum2);

	
		/*1 回目 割り算の結果は、3、余りは、0
		2回目 割り算の結果は、2、余りは、3
		3 回目 割り算の結果は、2、余りは、1*/
}