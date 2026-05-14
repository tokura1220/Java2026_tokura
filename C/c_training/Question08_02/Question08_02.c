#include <stdio.h>
#include <stdlib.h> 

typedef char String[1024];

int mathMax(int a, int b)
{
	int Mnum;
	if (a > b) 
	{
		Mnum = 1;
	}else if(a == b) 
	{
		Mnum = 2;
	}
	else {
		Mnum = 3;
	}

	return Mnum;

}

int main(void)
{
	int ia;
	int ib;
	String Strnum;

	printf("2 桁の数値を 2 回入力してください \n1回目:");
	scanf("%s", Strnum);
	ia = atoi(Strnum);

	printf("2回目:");
	scanf("%s", Strnum);
	ib = atoi(Strnum);

	printf("数値の比較をします\n");

	int num = mathMax(ia, ib);

	switch (num) {
	case 1:
		printf("1 回目と 2 回目で大きい値は %d です ", ia);
		break;

	case 2:
		printf("1 回目と 2 回目の値は、%d で同じ値です", ia);
		break;

	case 3:
		printf("1 回目と 2 回目で大きい値は %d です ", ib);
		break;
	}

	return 0;

}