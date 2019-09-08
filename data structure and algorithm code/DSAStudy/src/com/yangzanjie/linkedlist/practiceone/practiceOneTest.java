package com.yangzanjie.linkedlist.practiceone;

/**
 * @author : yangzanjie
 * create at:  2019-09-07  16:33
 * @description: 练习1的测试类
 */
public class practiceOneTest {
    public static void main(String[] args){
        /************************************Test SingleLinkedList**********************************************/
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHead(1+"");
        singleLinkedList.addTail(2+"");
        singleLinkedList.addTail(3+"");
        singleLinkedList.addHead(4+"");

        singleLinkedList.printAll(); // 4-1-2-3

        singleLinkedList.deleteHead();
        singleLinkedList.deleteTail();

        singleLinkedList.printAll(); //1-2

        System.out.println("\n\n****************************************************\n\n");

        /************************************Test CircleLinkedList**********************************************/
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.addHead(5+"");
        circleLinkedList.addTail(2+"");
        circleLinkedList.addTail(3+"");
        circleLinkedList.addHead(4+"");

        circleLinkedList.printAll();  // 4-5-2-3

        circleLinkedList.deleteTail();
        circleLinkedList.deleteHead();

        circleLinkedList.printAll(); // 5-2


        /************************************Test MergeTwoOrderedLinkedList**********************************************/
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.addTail(1+"");
        singleLinkedList1.addTail(3+"");
        singleLinkedList1.addTail(5+"");
        singleLinkedList1.addTail(7+"");

        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.addTail(2+"");
        singleLinkedList2.addTail(4+"");
        singleLinkedList2.addTail(8+"");
        singleLinkedList2.addTail(9+"");
        singleLinkedList2.addTail(10+"");

        singleLinkedList1.printAll(); //1-3-5-7

        singleLinkedList2.printAll(); //2-4-8-9-10

        //1-2-3-4-5-7-8-9-10
        MergeTwoOrderedLinkedList.mergeBasedOnSL(singleLinkedList1, singleLinkedList2).printAll();

        /************************************Test GetMiddleNode**********************************************/
        SingleLinkedList singleLinkedList3 = new SingleLinkedList();
        singleLinkedList3.addTail(1+"");
        System.out.println(singleLinkedList3.getMiddle()); //1
        singleLinkedList3.addTail(2+"");
        System.out.println(singleLinkedList3.getMiddle()); //1
        singleLinkedList3.addTail(3+"");
        System.out.println(singleLinkedList3.getMiddle()); //2
        singleLinkedList3.addTail(4+"");
        System.out.println(singleLinkedList3.getMiddle()); //2
        singleLinkedList3.addTail(5+"");
        System.out.println(singleLinkedList3.getMiddle()); //3

    }
}
