#include <stdio.h>
#include <stdlib.h>
#include<time.h>

int main(void) {
	srand((unsigned)time(NULL));
	int r = 1 +  rand() % 5;
	printf("サイコロを振ります 。 \nサイコロの目は %d でした。   ", r);
	return 0;

}
