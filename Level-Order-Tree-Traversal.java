
int heightOfTree = 100;

void doSomethingLevelOrder(TreeNode node){
    for(int i = 1; i < heightOfTree; i++){
        doSomethingGivenLevel(node, i);
    }
}
void doSomethingGivenLevel(TreeNode node, int i){
    if(node == null){
        return;
    }
    if(i == 1){
        return node.val;
    }
    else if(i > 1){
        doSomethingGivenLevel(node.left, i - 1);
        doSomethingGivenLevel(node.right, i - 1);
    }

 }