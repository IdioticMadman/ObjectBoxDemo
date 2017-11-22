package com.robert.objectboxdemo.bean;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
import io.objectbox.relation.ToMany;

/**
 * @author: robert
 * @date: 2017-11-22
 * @time: 16:02
 * @说明:
 */
@Entity
public class LotteryPlayType {
    @Id
    public long id;
    public String name;
    public String algorithm;
    @Index
    public String netid;
    public String rowSpilt;
    public String desc;
    //一对多，对应的子玩法下面的类型
    public ToMany<LotteryBall> lotteryBalls;
    //必须添加默认构造函数
    public LotteryPlayType() {
    }

    public LotteryPlayType(String name, String algorithm, String netid, String rowSpilt, String desc) {
        this.name = name;
        this.algorithm = algorithm;
        this.netid = netid;
        this.rowSpilt = rowSpilt;
        this.desc = desc;
    }

    public static LotteryPlayType createLotteryPlayType(LocalLotteryData.ListBean.TypeBean data) {
        return new LotteryPlayType(data.getName(), data.getAlgorithm(),
                data.getNetid(), data.getRowSplit(), data.getDesc());
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

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getNetid() {
        return netid;
    }

    public void setNetid(String netid) {
        this.netid = netid;
    }

    public String getRowSpilt() {
        return rowSpilt;
    }

    public void setRowSpilt(String rowSpilt) {
        this.rowSpilt = rowSpilt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ToMany<LotteryBall> getLotteryBalls() {
        return lotteryBalls;
    }

    public void setLotteryBalls(ToMany<LotteryBall> lotteryBalls) {
        this.lotteryBalls = lotteryBalls;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LotteryBall lotteryBall : lotteryBalls) {
            sb.append(lotteryBall.toString());
            sb.append("\n");
        }
        return "LotteryPlayType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", algorithm='" + algorithm + '\'' +
                ", netid='" + netid + '\'' +
                ", rowSpilt='" + rowSpilt + '\'' +
                ", desc='" + desc + '\'' +
                '}'
                + sb.toString();
    }
}
