#include<stdio.h>

typedef char String[1024];

int main(void)
{
	String ki = "‰ñ";
	String kt = "Œ…";
	int kt_num = 10;
	double ki_num = 30.8;
	
	printf("%d",kt_num);
	printf("%s\n", kt); 
	printf("%.1f", ki_num);
	printf("%s\n",ki);
	return 0;
}