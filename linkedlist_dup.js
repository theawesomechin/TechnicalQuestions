// 03/13/21
function removeNode(linkedList, nodeToDelete){
    let temp = linkedList.head;
    if(temp.value = nodeToDelete.value){
        temp.next = null;
        return true;
    }
    //iterate through the linked list until right before null
    while(temp.next != null){
        if(temp.next.value == nodeToDelete.value){
            temp.next = temp.next.next;
            return true;
        } 
        return temp = temp.next;
    }
    return false;

}

class Node {
    constructor(value){
        this.value = value;
        this.next = null;
    }
}

class LinkedList{
    constructor(node = null){
        this.head = node;
        this.size = 0;
    }
}

// how would remove duplicates in an unsorted linked list?
//BruteForce: keep another linked list of seen values
//            add new node's value that have not been seen to the buffer list
//            for each iteration of the input list check to see if buffer has the value
//            if yes -> remove with removeNode() else iterate to the next node;

//How to do it with no buffer
//          current pointer to the current value
//          and runner pointer to remove all other values