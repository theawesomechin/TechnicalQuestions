class Node {
    constructor(value){
        this.value = value;
        this.next = null;
    }
}

class Stack{
    constructor(node = null){
        this.head = node;
        this.size = 0;
        this.min = !!node ? node.value : null;
    }

    push(node){
        node.next = head;
        this.head = node;
        if(this.min > node.value){
            this.min = node.value;
        }
    }

    pop(node){
        temp = this.head;
        this.head = this.head.next;
        return temp;
    }
}

