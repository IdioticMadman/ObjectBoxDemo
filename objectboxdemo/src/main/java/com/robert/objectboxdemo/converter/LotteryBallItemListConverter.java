package com.robert.objectboxdemo.converter;

import com.google.gson.reflect.TypeToken;
import com.robert.objectboxdemo.bean.LotteryBallItem;
import com.robert.objectboxdemo.util.GsonUtil;

import java.util.List;

import io.objectbox.converter.PropertyConverter;

/**
 * @author: robert
 * @date: 2017-11-22
 * @time: 16:33
 * @说明: 转换器 把List<LotteryBallItem> 转成String存在db里面
 */
public class LotteryBallItemListConverter implements PropertyConverter<List<LotteryBallItem>, String> {

    private final TypeToken<List<LotteryBallItem>> typeToken;

    public LotteryBallItemListConverter() {
        this.typeToken = new TypeToken<List<LotteryBallItem>>() {};
    }

    public List<LotteryBallItem> convertToEntityProperty(String databaseValue) {
        return GsonUtil.getInstance().json2List(databaseValue, typeToken.getType());
    }

    @Override
    public String convertToDatabaseValue(List<LotteryBallItem> entityProperty) {
        return GsonUtil.getInstance().toJson(entityProperty);
    }
}
