#include <stdio.h>
#include <wiringPi.h>
#include<softPwm.h>

#define White 27
#define Blue 28
#define Gray 29
int main(int argc,char* argv[]){

	
	if(wiringPiSetup()==-1)
		return 1;

	softPwmCreate(White,0,200);
	softPwmCreate(Blue,0,200);
	softPwmCreate(Gray,0,200);
		
	softPwmWrite(Gray,5);
	 softPwmWrite(White,5);
	softPwmWrite(Blue,5);
	delay(1200);

	
	int pos;
	sscanf(argv[1],"%d",&pos);
	printf("value = %d\n",pos);
	
	
	
	if(pos==1){
	 printf("working");
	 softPwmWrite(White,0);
	softPwmWrite(Blue,24);
	}
	else if(pos==2){
	 softPwmWrite(White,24);
	 softPwmWrite(Blue,0);
	 softPwmWrite(Gray,24);
	}
	else  if(pos==3){
	 softPwmWrite(White,24);
	 softPwmWrite(Blue,24);
	 softPwmWrite(Gray,0);

	}
	else  if(pos==4){
	 softPwmWrite(White,24);
	 softPwmWrite(Blue,0);
	 softPwmWrite(Gray,0);

	}
	else  if(pos==5){
	 softPwmWrite(White,0);
	 softPwmWrite(Blue,0);
	 softPwmWrite(Gray,24);

	}
	else  if(pos==6){
	 softPwmWrite(White,0);
	 softPwmWrite(Blue,24);
	 softPwmWrite(Gray,0);

	}
	delay(300);
	return 0;
}
