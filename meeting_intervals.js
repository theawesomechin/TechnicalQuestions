
// Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

// Input: intervals = [[0,30],[5,10],[15,20]];
// Output: false

// Input: intervals = [[2,4], [7,10], [11,13]]
// Output: true

//set to make sure while you iterate that the time start and end do not fall between the first set.

(starti && endi > 5) && (starti && endi < 10)


function canAttendAll(input){
    for(let i = 0; i< input.lenght; i++){
        for(let j = i+1; j < input.length; j++){
            firstIntervalStart=input[i][0]
            firstIntervalEnd=input[i][1]
            secondIntervalStart=input[j][0]
            secondIntervalEnd=input[j][1]
            //case 1
            //first interval is less than the second interval
            // |---|
            //      |---|
            if((firstIntervalStart < secondIntervalStart && firstIntervalStart < secondIntervalEnd) && (firstIntervalEnd < secondIntervalStart && firstIntervalEnd < secondIntervalEnd)){
                continue;
            }
            //case 2
            //first interval is greater than the second interval
            //      |---|
            // |---|     
            if((firstIntervalStart > secondIntervalStart && firstIntervalStart > secondIntervalEnd) && (firstIntervalEnd > secondIntervalStart && firstIntervalEnd > secondIntervalEnd)){
                continue
            }
            return false;
        }
    }
    return true;
}

