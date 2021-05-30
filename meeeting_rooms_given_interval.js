// Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

// Input: intervals = [[0,30],[5,10],[15,20]]
// Output: 2

// Input: intervals = [[7,10],[2,4]]
// Output: 1

// |----|   |----|
//    |----|
//          |----|

function minimalAmountOfRoom(input){
    let rooms = {};
    for(let i = 0; i < input.length; i++){
        let currentMeeting = input[i];
        for(let j = 0; j < rooms.length; j++){
            if(fitInRoom(input[i], room[j])){
                room[j] = input[i];
                break;
            }
        }
        room[rooms.length] = input[i];
    }

    return rooms.length;
}
function fitInRoom(interval, room){
    //code to check
}

// |---| 
//     |-----|
//   |---| 