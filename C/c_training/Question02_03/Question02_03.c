#include <stdio.h>
typedef char String[1024];
int main(void) {
	String s = "‚±‚ñ‚É‚¿‚Í";
	int n1 = 12;
	double n2 = 20.58;


	printf("%d\n", n1);
	printf("%.2f\n", n2);
	printf("%s\n", s);
}