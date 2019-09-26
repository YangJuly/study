package com.yangzanjie.graph;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author : yangzanjie
 * create at:  2019-09-25  19:51
 * @description: A*算法实现
 */
public class AStart {

    private int maxXsize;

    private int maxYsize;

    //待遍历的点
    private ArrayList<Point> openSet;
    //已遍历的点
    private ArrayList<Point> closeSet;

    private RandomMap map;

    //起点
    private Point start;

    //终点
    private Point end;

    //两个相邻节点的移动代价
    private final int moveCost = 1;

    private DrawSee drawSee;

    public AStart(int maxSize, DrawSee drawSee) {
        this.maxXsize = maxSize;
        this.maxYsize = maxSize;
        this.openSet = new ArrayList<>();
        this.closeSet = new ArrayList<>();
        this.map = new RandomMap(maxSize, 49 * 2, drawSee);
        this.drawSee = drawSee;
    }

    public void run(Point start, Point end){
        //init 设定起始点、终点
        this.start = start;
        this.end = end;
        openSet = new ArrayList<>();
        closeSet = new ArrayList<>();

        openSet.add(start);

//        ArrayList<Point> path =  new ArrayList<>();

        while (true) {
            //从open中取出优先级最高的节点 n
            int pointIndex = selectPointInOpenList();
            Point curPoint = openSet.get(pointIndex);
            System.out.println("当前访问结点： " + "x=" + curPoint.x + ", " + "y=" + curPoint.y + ". ");
            //调用画图
            drawSee.paintPoint(curPoint, Color.RED);
            drawSee.paintPoint(curPoint, Color.BLUE);
//            path.add(curPoint);

            if (isEndPoint(curPoint)) {
                //从终点开始逐步追踪parent节点，一直到达起点，构建path，并返回，算法结束
                bulidPath(curPoint);
                return;
            } else {
                //节点n不是终点
                //将节点从open中删除，并加入到close中
                closeSet.add(curPoint);
                openSet.remove(pointIndex);
                //遍历节点n所有的邻近节点

                //处理邻近节点 (邻近节点的不同需要使用不同的距离度量)
                processoint(new Point(curPoint.x + 1, curPoint.y), curPoint);
                processoint(new Point(curPoint.x, curPoint.y + 1), curPoint);
                processoint(new Point(curPoint.x - 1, curPoint.y), curPoint);
                processoint(new Point(curPoint.x, curPoint.y - 1), curPoint);
                processoint(new Point(curPoint.x + 1, curPoint.y + 1), curPoint);
                processoint(new Point(curPoint.x - 1, curPoint.y + 1), curPoint);
                processoint(new Point(curPoint.x + 1, curPoint.y - 1), curPoint);
                processoint(new Point(curPoint.x - 1, curPoint.y - 1), curPoint);
            }
        }
    }


    /**
     * 处理节点n的邻近节点m
     * @param m
     * @param n
     */
    private void processoint(Point m, Point n) {
        //针对无效点，什么都不做
        if (!isValidPoint(m)) return;

        //如果邻近节点m在close中，则跳过，选取下一个邻近节点
        if (isInCloseList(m)) return;

        //如果邻近节点m也不在open中，则
        // *设置m的parent节点为n
        // *计算m的优先级
        // *将节点加入open中
        if (!isInOpenList(m)) {
            //设置m的parent节点为n
            m.parent = n;
            //计算m的优先级
            m.cost = totalCost(m);
            // *将节点加入open中
            openSet.add(m);
        } else {
            //如果邻近节点m在close中
            //之前访问过一次，说明至少有两种方式到了这个节点
            //比较当前结点的g值，和邻近节点的parent节点的g值
            //更低的g值，意味更好的路径
            //更新最短路径
            Point point = getPointFromOpen(m);
            if (baseCost(point.parent) > baseCost(n)) {
                point.parent = n;
                point.cost = totalCost(m);
            }
        }
    }

    private Point getPointFromOpen(Point point) {
        for (Point p : openSet) {
            if (p.equals(point)) return p;
        }
        return null;
    }

    /**
     * 从终点往回沿着parent构造结果
     */
    private void bulidPath(Point point) {
        ArrayList<Point> path =  new ArrayList<>();
        while(true) {
            path.add(point);
            if (isStartPoint(point))  break;
            point =  point.parent;
        }
        //根据path绘图
        for (Point p : path) {
            drawSee.paintPoint(p, Color.GREEN);
        }
    }


    /**
     * 从open中找到优先级最高的点,并返回索引
     * @return
     */
    private int selectPointInOpenList() {
        int minIndex = 0;
        double minCost = Integer.MAX_VALUE;
        for (int i = 0; i < openSet.size(); i++) {
            double curCost = totalCost(openSet.get(i));
            if (curCost < minCost)  {
                minCost = curCost;
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * 基础代价，对应起点到终点的距离，g(n)
     * 注：
     *   图形朝四个方向（上下左右）移动，使用曼哈顿距离
     *   图形朝八个方向移动，对角距离
     *   朝任何方向移动，欧几里得距离
     * @param n
     * @return
     */
    private double baseCost(Point n) {
        //使用了曼哈顿距离
        /*
        int dX = Math.abs(n.x - start.x);
        int dY = Math.abs(n.y - start.y);
        int cost = moveCost * (dX + dY);
        return  cost;
        */
        //对角距离
        /*
        int dX = Math.abs(n.x - start.x);
        int dY = Math.abs(n.y - start.y);
        double cost = dX + dY + (Math.sqrt(2) - 2) * Math.min(n.x, n.y);
        return cost;
        */
        //欧氏距离
        int dX = Math.abs(n.x - start.x);
        int dY = Math.abs(n.y - start.y);
        double cost = Math.sqrt(dX * dX + dY * dY);
        return cost;
    }

    /**
     * 节点到终点的启发函数，对应h(n)
     * @param n
     * @return
     */
    private double heuristicCost(Point n) {
        //曼哈顿距离
        /*
        int dX = Math.abs(n.x - end.x);
        int dY = Math.abs(n.y - end.y);
        int cost = moveCost * (dX + dY);
        return  cost;
        */

        //对角距离
        /*
        int dX = Math.abs(n.x - end.x);
        int dY = Math.abs(n.y - end.y);
        double cost = dX + dY + (Math.sqrt(2) - 2) * Math.min(n.x, n.y);
        return cost;
        */
        //欧氏距离
        int dX = Math.abs(n.x - end.x);
        int dY = Math.abs(n.y - end.y);
        double cost = Math.sqrt(dX * dX + dY * dY);
        return cost;
    }

    /**
     * 代价总和，对应f(n) = h(n) + g(n)
     * @param n
     * @return
     */
    private double totalCost(Point n) {
        return baseCost(n) + heuristicCost(n);
    }

    /**
     * 判断点是否有效，不在地图内部或者障碍物所在点都是无效的
     * @param n
     * @return
     */
    private boolean isValidPoint(Point n) {
        if (n.x < 0 || n.y < 0) return false;
        if (n.x > maxXsize || n.y > maxYsize) return false;
        if (map.isObstacle(n)) return false;
        return true;
    }

    /**
     * 判断点是否在openList中，
     * open 指待访问点的集合
     * @param n
     * @return
     */
    private boolean isInOpenList(Point n) {
        return isInPointList(n, openSet);
    }

    /**
     * 判断点是否在closeList中
     * close 指已访问点的集合
     * @param n
     * @return
     */
    private boolean isInCloseList(Point n) {
        return isInPointList(n, closeSet);
    }

    /**
     * 判断点是否在某个集合中
     * @param n
     * @param list
     * @return
     */
    private boolean isInPointList(Point n, ArrayList<Point> list) {
        for (Point point : list) {
            if (point.equals(n)) return true;
        }
        return false;
    }

    /**
     * 判断点是否为起点
     * @param n
     * @return
     */
    private boolean isStartPoint(Point n) {
        return start.equals(n);
    }

    /**
     * 判断点是否为终点
     * @param n
     * @return
     */
    private boolean isEndPoint(Point n) {
        return end.equals(n);
    }
}

class Point {
    public int x;
    public int y;
    public double cost;
    public Point parent;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.cost = Integer.MAX_VALUE;
        this.parent = null;
    }

    public boolean equals(Point n) {
        if (n.x == x && n.y == y) {
            return true;
        }
        return false;
    }
}

class RandomMap {
    //地图点的个数
    private int size = 50;
    //地图障碍数量
    private int obstacle;

    private Point[] obstacleLocation;

    private DrawSee drawSee;

    public RandomMap(int size, int obstacle, DrawSee drawSee) {
        this.size = size;
        this.obstacle = obstacle;
        this.drawSee = drawSee;
        obstacleLocation = new Point[obstacle];
        generateMap();
    }

    //生成地图
    private void generateMap() {
        //todo
        for (int i = 0; i < 49; i++) {
            obstacleLocation[i] =  new Point(24, i);
            drawSee.paintPoint(obstacleLocation[i], Color.RED);
        }

        for (int i = 0; i < 49; i++) {
            obstacleLocation[i+49] =  new Point(30, i+1);
            drawSee.paintPoint(obstacleLocation[i+49], Color.RED);
        }
        return;
    }

    //是否是障碍物
    public boolean isObstacle(Point n) {
        for (Point point : obstacleLocation) {
            if (point.equals(n))
                return true;
        }
        return false;
    }
}