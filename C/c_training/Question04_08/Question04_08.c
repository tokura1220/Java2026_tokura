#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<stdbool.h>

int main(void)
{
	srand((unsigned)time(NULL));
	int num = rand() % 100;
	bool r = (50 >= num);
	
	if(r != true){
		printf("値は %d 判断結果は、50 以上でした ",num);
	}
	else {
		printf("値は %d 判断結果は、50 未満でした", num);
	}

	//bool age = true


}