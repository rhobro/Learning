/*

Problem Set - https://s3.amazonaws.com/video.udacity-data.com/topher/2018/May/5afb348b_problem-set-2/problem-set-2.pdf (23/02/2019)

Q1 - C: We broke even. (0 + 20 - 25 + 30 - 25 = 0, 0 !> 0 & 0 !< 0. 0 = 0)

Q2 - I guess you like cats more (dogs = 1, cats = 2. dogs > 0 but cats != 0 so skip to next if. cats > 0 but dogs != 0 so skip to next if. cats > 0 and dogs > 0 so enter if. dogs !> cats, dogs != cats so cats > dogs)

Q3 - 1 = canSeePlayer, 2 = !playerPoweredUp

Q4 - 
boolean isSnowing = false;
boolean isRaining = true;
double temperature = 60.0;
if(isRaining || is Snowing || temperature < 50){
	System.out.println("Let's stay home.");
} else {
	System.out.println("Let's go out!");
}

Q5 - 
int time = 18;
String timeOfDay;
if(time >= 5 && time < 12){
	timeOfDay = "morning";
} else if(time >= 12 && time < 20){
	timeOfDay = "daytime";
} else {
	timeOfDay = "night";
}

Q6 - 
int daysOfTheWeek = 5;
boolean holiday = false;
if(daysOfTheWeek >= 1 && daysOfTheWeek <=5 && !holiday){
	System.out.println("Wake up at 7:00");
} else {
	System.out.println("Sleep in!");
}

Q7 - rewindAmount is out of the scope of the statement playbackPosition = playbackPosition - rewindAmount since it is inside the if block. The subtractive statement has to be placed inside the if block.

Q8 - 
int dayOfWeek = 1;
switch(dayOfWeek){
	case 1:
		schedule = "Gym in the morning.";
		break;
	case 2:
		schedule = "Class after work.";
		break;
	case 3:
		schedule = "Meetings all day.";
		break;
	case 4:
		schedule = "Work from home.";
		break;
	case 5:
		schedule = "Game night after work.";
		break;
	case 6: case 7: default:
		schedule = "Free!";
		break;
}

*/