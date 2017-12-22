//
//  main.c
//  servo
//
//  Created by leeahdguia on 2017. 12. 22..
//  Copyright © 2017년 leeahdguia. All rights reserved.
//

#include <stdio.h>
#include <wiringPi.h>
#include <softPwm.h>

#define SERVO 1

int main()
{
    char str;
    
    if(wiringPiSetup()==-1)
        return 1;
    
    softPwmCreate(SERVO,0,200);
    
    while(1){
        fputs("select c,r,l,q:",stdout);
        scanf("%c",&str);
        getchar();
        if(str=='c')softPwmWrite(SERVO,15);
        else if(str=='r')softPwmWrite(SERVO,24);
        else if(str=='l')softPwmWrite(SERVO,5);
        else if(str=='q')return 0;
        
        
    }
}

