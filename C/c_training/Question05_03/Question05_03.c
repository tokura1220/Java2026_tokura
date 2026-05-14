#include<stdio.h>
#include <stdlib.h> 

typedef char String[1024];

int main(void) {
	int inum = 0;
	String Strnum;

	while (inum<5) {
		printf("5 ˆÈã‚Ì”’l‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢ \n");
		scanf("%s", Strnum);
		inum = atoi(Strnum);
	}
	printf("5 ˆÈã‚Ì”’l‚ª“ü—Í‚³‚ê‚Ü‚µ‚½ \nˆ—‚ðI—¹‚µ‚Ü‚·");
	return 0;
}