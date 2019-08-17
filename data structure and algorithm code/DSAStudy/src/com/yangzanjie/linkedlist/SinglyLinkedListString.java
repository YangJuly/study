package com.yangzanjie.linkedlist;

/**
 * @author : yangzanjie
 * create at:  2019-07-28  14:32
 * @description: 通过单链表存储的字符串，判断是否为回文
 */
public class SinglyLinkedListString<T> {

    private SNode headNode;
    /**
     * 单向链表
     * @param <T>
     */
    public class SNode<T> {
        private T element;

        private SNode<T> next;

        public SNode() {
            this.next = null;
        }

        public SNode(T element) {
            this.element = element;
            this.next = null;
        }

        public SNode(T element, SNode<T> next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode<T> getNext() {
            return next;
        }

        public void setNext(SNode<T> next) {
            this.next = next;
        }
    }

    public SinglyLinkedListString(T data) {
        this.headNode = new SNode<T>(data);
    }

    public SNode getHeadNode() {
        return headNode;
    }

    public void setHeadNode(SNode headNode) {
        this.headNode = headNode;
    }

    /**
     * 获得最后一个结点
     * @return
     */
    public SNode getNodeEnd() {
        SNode endNode = this.headNode;
        //下一个结点为空，则为尾部结点
        while(endNode.getNext() != null) {
            endNode = endNode.getNext();
        }
        return endNode;
    }

    /**
     * 加入一个结点(往后面加)
     */
    public void addNodeEnd(SNode node) {
        SNode endNode = getNodeEnd();
        endNode.setNext(node);
    }

    /**
     * 加入一个元素(加到最后面)
     * @param data
     */
    public void addElement(T data) {
        SNode node = new SNode(data);
        addNodeEnd(node);
    }

    /**
     * 将字符串转化为单链表
     * @param str
     */
    public static SinglyLinkedListString convertStringToSinglyLinkedListString(String str) {
        char[] strCharacters = str.toCharArray();
        int length = strCharacters.length;
        if (length == 0) {
            System.out.println("Illegal data, string length should longer than 0");
        }
        SinglyLinkedListString singlyLinkedListString = new SinglyLinkedListString(strCharacters[0]);
        for (int i=1; i<length;i++) {
            singlyLinkedListString.addElement(strCharacters[i]);
        }
        return singlyLinkedListString;
    }

    /**
     * 打印整个链表
     */
    public void printAll() {
        SNode node = getHeadNode();
        while(node.getNext() !=  null)  {
            System.out.println(node.getElement().toString());
            node = node.getNext();
        }
        if (node.element != null) {
            System.out.println(node.getElement().toString());
        }
        System.out.println("****************************");
    }

    /**
     * 快慢指针法，找中间结点,同时将前半段链表，反向链接
     * @param headNode
     * @return 若奇数，则返回正中结点，若偶数，则返回n/2
     */
    public SNode[] findMiddle(SNode headNode) {
        SNode fastNode = headNode;
        SNode lowNode = headNode;
        SNode lastNode = headNode;
        SNode curNode = null;
        while (fastNode.getNext() != null && fastNode.getNext().getNext() != null) {
            fastNode = fastNode.getNext().getNext();
            lowNode = lowNode.getNext();
            lastNode.setNext(curNode);
            curNode = lastNode;
            lastNode = lowNode;
        }
        SNode[] res = {curNode, lowNode};
        return res;
    }

    public boolean isPalindrome(SNode firstNode, SNode secondNode, Boolean isOdd) {
        if (!isOdd) {
            secondNode = secondNode.getNext();
        }
        while (secondNode != null) {
            if (! secondNode.getElement().equals(firstNode.getElement())) {
                return false;
            }
            secondNode = secondNode.getNext();
            firstNode = firstNode.getNext();
        }
        return true;
    }

    public static void main(String[] args) {
        //test
        String str = "121";
        boolean isOdd = (str.length() % 2) == 0;
        SinglyLinkedListString sTest = SinglyLinkedListString.convertStringToSinglyLinkedListString(str);
        sTest.printAll();
        SinglyLinkedListString.SNode[] res = sTest.findMiddle(sTest.getHeadNode());
        Boolean isPalindrome = sTest.isPalindrome(res[0], res[1], isOdd);
        System.out.println(isPalindrome);
        System.out.println("end");
    }
}
