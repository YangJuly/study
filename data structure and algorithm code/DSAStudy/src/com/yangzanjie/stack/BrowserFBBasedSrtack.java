package com.yangzanjie.stack;

/**
 * @author : yangzanjie
 * create at:  2019-09-11  20:14
 * @description: 基于栈，模拟实现浏览器的前进后退能力
 */
public class BrowserFBBasedSrtack {
    /**
     * 记录当前访问页面，
     */
    private ArrayStack curStack;

    /**
     * 记录后退过的页面
     */
    private ArrayStack backStack;

    public BrowserFBBasedSrtack() {
        this.curStack = new ArrayStack(3);
        this.backStack = new ArrayStack(3);
    }

    /**
     * 访问新网页，将网页压入当前访问页面栈中，此处用了pollPush，同时清空回退的网页栈。
     * @param webPage
     */
    public void access(String webPage) {
        curStack.pushForce(webPage);
        backStack.clean();
    }

    /**
     * 前进，从回退栈中取出页面，并压入当前栈中。
     * @return
     */
    public String forward() {
        String webPage = backStack.poll();
        if (webPage != null) {
            curStack.push(webPage);
        }
        return webPage;
    }

    /**
     * 回退，从当前栈中取出当前页面，并压入回退栈中，然后从当前栈中取出上一个页面。
     * @return
     */
    public String back() {
        String webPage = curStack.poll();
        if (webPage != null) {
            backStack.push(webPage);
            String res = curStack.poll();
            if (res == null) return null;
            curStack.push(res);
            return res;
        }
        return null;
    }
}

