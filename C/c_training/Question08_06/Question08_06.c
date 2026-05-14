#include <stdio.h>
#include <stdlib.h> 

typedef char String[1024];
const double Tax10 = 0.1;
const double Tax8 = 0.08;



int tax8Calc(int lunch)
{
	int vTax8;
	vTax8 = lunch * Tax8;

	return vTax8;
}

int  tax10Calc(int lunch)
{
	int vTax10;
	vTax10 = lunch * Tax10;

	return vTax10;

}

int main(void)
{
	String Strlun;
	int iLunch;
	int vLunch8;
	int vLunch10;

	printf("‚¨•Ù“–‚Ì–{‘Ì‰¿Ši‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B \n");
	scanf("%s", Strlun);
	iLunch = atoi(Strlun);


	int tax8 = tax8Calc(iLunch);
	int tax10 = tax10Calc(iLunch);

	vLunch8 = tax8 + iLunch;
	vLunch10 = tax10 + iLunch;

	printf("Å‚İ(8%%)‰¿Ši  :%10d‰~\n", vLunch8);
	printf("Á”ïÅŠz(8%%)    :%10d‰~\n", tax8);

	printf("Å‚İ(10%%)‰¿Ši  :%10d‰~\n", vLunch10);
	printf("Á”ïÅŠz(10%%)    :%10d‰~\n", tax10);


	return 0;

}

