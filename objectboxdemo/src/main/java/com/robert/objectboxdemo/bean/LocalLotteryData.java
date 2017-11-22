package com.robert.objectboxdemo.bean;

import java.util.List;

/**
 * 本地存储的彩票信息
 */
public class LocalLotteryData {

    /**
     * lottery : ssc
     * list :
     */

    private String lottery;
    private List<ListBean> list;

    public LocalLotteryData(String lottery, List<ListBean> list) {
        this.lottery = lottery;
        this.list = list;
    }

    public String getLottery() {
        return lottery;
    }

    public void setLottery(String lottery) {
        this.lottery = lottery;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * name : 五星
         * type :
         */

        private String name;
        private List<TypeBean> type;

        public ListBean(String name, List<TypeBean> type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<TypeBean> getType() {
            return type;
        }

        public void setType(List<TypeBean> type) {
            this.type = type;
        }

        public static class TypeBean {
            /**
             * name :  通选
             * algorithm : 排列组合
             * fastCheck : 是否快捷选号
             * netid : 后台的ID   玩法(play_type) - 玩法细则(play_type)
             * desc : 彩票的奖金描述
             * ballInfo :[] 彩票详情列表
             */

            private String name;
            private String algorithm;
            private boolean fastCheck;
            private String netid;
            private String cover;
            private String rowSplit;
            private String desc;
            private List<BallInfo> ballInfo;
            /**
             * 以下全部都是  服务端 用这种方式 目的就是为了暂时存储
             * 不设计本地结构逻辑
             */
            // 玩法ID
            private transient String net_play_type;
            // 赔率ID    这样命名是因为要 跟服务器一样      ps id == 0  说明他是一级列表*/
            private transient String net_oddsId;
            // 玩法名称
            private transient String net_odds_type;

            //《快捷使用》
            public TypeBean(String name, String netid, String net_play_type, List<BallInfo> ballInfo) {
                this.algorithm = "fast" + netid;
                this.name = name;
                this.netid = netid;
                this.net_play_type = net_play_type;
                this.ballInfo = ballInfo;
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

            public boolean isFastCheck() {
                return fastCheck;
            }

            public void setFastCheck(boolean fastCheck) {
                this.fastCheck = fastCheck;
            }

            public String getNetid() {
                return netid;
            }

            public void setNetid(String netid) {
                this.netid = netid;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getRowSplit() {
                return rowSplit;
            }

            public void setRowSplit(String rowSplit) {
                this.rowSplit = rowSplit;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public List<BallInfo> getBallInfo() {
                return ballInfo;
            }

            public void setBallInfo(List<BallInfo> ballInfo) {
                this.ballInfo = ballInfo;
            }

            public String getNet_play_type() {
                return net_play_type;
            }

            public void setNet_play_type(String net_play_type) {
                this.net_play_type = net_play_type;
            }

            public String getNet_oddsId() {
                return net_oddsId;
            }

            public void setNet_oddsId(String net_oddsId) {
                this.net_oddsId = net_oddsId;
            }

            public String getNet_odds_type() {
                return net_odds_type;
            }

            public void setNet_odds_type(String net_odds_type) {
                this.net_odds_type = net_odds_type;
            }

            public static class BallInfo {
                /**
                 * name : 万位
                 * balllist : [{"num":"0","color":"red"},{"num":"1","color":"red"},{"num":"2","color":"red"},{"num":"3","color":"red"},{"num":"4","color":"red"},{"num":"5","color":"red"},{"num":"6","color":"red"},{"num":"7","color":"red"},{"num":"8","color":"red"},{"num":"9","color":"red"}]
                 */

                private String name;                    //子标题名  如 不同号 同好  （注：分算法细则名）
                private int colNum;                     //显示风格，显示列数
                private int max;                        //最多选择几个号 （默认0  也就是无限）
                private int min;                        //最小选择几个号 （默认0  也就是无限）
                private boolean reject;                 //是否互相排斥，也就是 列表一 选中1   另外一个列表 不允许勾选 相同的字符/存在的字符
                private String colStyle = "rect";     //显示风格  circle(圆),rect(方块) 《默认》
                private String colSplit = ",";
                private String desc;
                private List<BallBean> balllist;        //球号列表

                //快捷选号使用
                public BallInfo(String name, List<BallBean> balllist) {
                    this.name = name;
                    this.balllist = balllist;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getColNum() {
                    return colNum;
                }

                public void setColNum(int colNum) {
                    this.colNum = colNum;
                }

                public int getMax() {
                    return max;
                }

                public void setMax(int max) {
                    this.max = max;
                }

                public int getMin() {
                    return min;
                }

                public void setMin(int min) {
                    this.min = min;
                }

                public boolean isReject() {
                    return reject;
                }

                public void setReject(boolean reject) {
                    this.reject = reject;
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

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public List<BallBean> getBalllist() {
                    return balllist;
                }

                public void setBalllist(List<BallBean> balllist) {
                    this.balllist = balllist;
                }

                public static class BallBean {
                    /**
                     * num : 0
                     * color : red
                     */

                    private String num;
                    private String color;
                    private transient String rowSplit = "";           //分割符,跟上面一样,这里主要是为了加入购物车
                    private transient String colSplit;
                    private transient boolean isMulOid;    //是否多赔率ID ,生成订单号格式不同
                    public transient String oid;           //赔率ID,因为快三可能每个号的赔率ID都不一样
                    public transient String odds;          //赔率
                    public transient boolean check;       //是否选中

                    public BallBean(String num) {
                        this.num = num;
                    }


                    public String getNum() {
                        return num;
                    }

                    public void setNum(String num) {
                        this.num = num;
                    }

                    public String getColor() {
                        return color;
                    }

                    public void setColor(String color) {
                        this.color = color;
                    }

                    public String getRowSplit() {
                        return rowSplit;
                    }

                    public void setRowSplit(String rowSplit) {
                        this.rowSplit = rowSplit;
                    }

                    public String getColSplit() {
                        return colSplit;
                    }

                    public void setColSplit(String colSplit) {
                        this.colSplit = colSplit;
                    }

                    public boolean isMulOid() {
                        return isMulOid;
                    }

                    public void setMulOid(boolean mulOid) {
                        isMulOid = mulOid;
                    }

                    public String getOid() {
                        return oid;
                    }

                    public void setOid(String oid) {
                        this.oid = oid;
                    }

                    public String getOdds() {
                        return odds;
                    }

                    public void setOdds(String odds) {
                        this.odds = odds;
                    }

                    public boolean isCheck() {
                        return check;
                    }

                    public void setCheck(boolean check) {
                        this.check = check;
                    }
                }
            }
        }
    }
}
