package com.robert.objectboxdemo.bean;

import com.robert.objectboxdemo.converter.LotteryBallItemListConverter;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * @author: robert
 * @date: 2017-11-22
 * @time: 16:28
 * @说明:
 */
@Entity
public class LotteryBall {
    @Id
    public long id;
    public String name;
    public int max;
    public boolean reject;
    public int colNum;
    public String colStyle;
    public String colSplit;
    @Convert(converter = LotteryBallItemListConverter.class, dbType = String.class)
    public List<LotteryBallItem> ballList;

    //必须添加默认构造函数
    public LotteryBall() {
    }

    public LotteryBall(String name, int max, boolean reject, int colNum, String colStyle, String colSplit, List<LotteryBallItem> ballList) {
        this.name = name;
        this.max = max;
        this.reject = reject;
        this.colNum = colNum;
        this.colStyle = colStyle;
        this.colSplit = colSplit;
        this.ballList = ballList;
    }

    public static LotteryBall createLotteryBall(LocalLotteryData.ListBean.TypeBean.BallInfo ballInfo) {
        List<LocalLotteryData.ListBean.TypeBean.BallInfo.BallBean> balllist = ballInfo.getBalllist();
        List<LotteryBallItem> lotteryBallItems = new ArrayList<>();
        for (LocalLotteryData.ListBean.TypeBean.BallInfo.BallBean ballBean : balllist) {
            lotteryBallItems.add(new LotteryBallItem(ballBean.getNum(), ballBean.getColor()));
        }
        return new LotteryBall(ballInfo.getName(), ballInfo.getMax(), ballInfo.isReject(), ballInfo.getColNum(),
                ballInfo.getColStyle(), ballInfo.getColSplit(), lotteryBallItems);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public boolean isReject() {
        return reject;
    }

    public void setReject(boolean reject) {
        this.reject = reject;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    public String getColStyle() {
        return colStyle;
    }

    public void setColStyle(String colStyle) {
        this.colStyle = colStyle;
    }

    public String getColSplit() {
        return colSplit;
    }

    public void setColSplit(String colSplit) {
        this.colSplit = colSplit;
    }

    public List<LotteryBallItem> getBallList() {
        return ballList;
    }

    public void setBallList(List<LotteryBallItem> ballList) {
        this.ballList = ballList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LotteryBallItem lotteryBallItem : ballList) {
            sb.append(lotteryBallItem.toString());
            sb.append("\n");
        }
        return "LotteryBall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", max=" + max +
                ", reject=" + reject +
                ", colNum=" + colNum +
                ", colStyle='" + colStyle + '\'' +
                ", colSplit='" + colSplit + '\'' +
                ", ballList=" + ballList +
                '}' + sb.toString();
    }
}
