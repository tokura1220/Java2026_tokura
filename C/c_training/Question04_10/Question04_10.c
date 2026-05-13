#include <stdio.h> 
#include <stdlib.h> 

typedef char String[1024];
int main(void)
{
	String strInput = "";
	int inum1 = 0;
	int inum2 = 0;

	printf("1 ‚© 2 ‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢\n");
	scanf("%s", strInput);
	inum1 = atoi(strInput);

	printf("‚à‚¤ˆê“x 1 ‚© 2 ‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢\n");
	scanf("%s", strInput);
	inum2 = atoi(strInput);

	// ----C³‘ÎÛ‚±‚±‚©‚ç---- 
	if (inum1 == 1 && inum2 == 1) {
		printf("1 ‚ª 2 ‰ñ“ü—Í‚³‚ê‚Ü‚µ‚½\n");
	}
	// ----C³‘ÎÛ‚±‚±‚Ü‚Å---- 
	return 0;
}