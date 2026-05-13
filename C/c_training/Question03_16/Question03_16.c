#include <stdio.h>
#include <stdlib.h>

typedef char String[1024];

int main(void)
{
	String kgStr;
	String cmStr;

	printf("身長(cm)を整数値で入力してください。:\n");
	scanf("%s",cmStr);

	printf("体重(kg)を整数値で入力してください。:\n");
	scanf("%s",kgStr);

	double cm = atof(cmStr);
	double kg = atof(kgStr);

	printf("身長: %.1fcm ", cm);
	printf(" 体重: %.1fkg \n", kg);


	
	double m = cm / 100.0;
	
	double bmi = kg / (m*m);

	double tkg = (m * m) * 22;
	
	printf("BMI :%.1f\n",bmi);
	printf("適正体重 :%.1f\n", tkg);

	return 0;


}

