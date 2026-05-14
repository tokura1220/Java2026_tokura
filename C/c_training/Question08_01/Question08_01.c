#include <stdio.h>
#include <stdlib.h> 

typedef char String[1024];

int mathMax(int a ,int b)
{

	
	int Mnum;
	if (a < b) {
		Mnum = b;
	}
	else {
		Mnum = a;
	}

	return Mnum;
	
}

int main(void)
{
	int ia = 0;
	int ib = 0;
	String Strnum;

	printf("2 Œ…‚Ì”’l‚ð 2 ‰ñ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢ \n1‰ñ–Ú:");
	scanf("%s", Strnum);
	ia = atoi(Strnum);

	printf("2‰ñ–Ú:");
	scanf("%s", Strnum);
	ia = atoi(Strnum);

	printf("”’l‚Ì”äŠr‚ð‚µ‚Ü‚·\n");

	mathMax(ia,ib);

	int num = mathMax(ia, ib);

	printf("1 ‰ñ–Ú‚Æ 2 ‰ñ–Ú‚Å‘å‚«‚¢’l‚Í %d ‚Å‚· ", num);

	return 0;

}