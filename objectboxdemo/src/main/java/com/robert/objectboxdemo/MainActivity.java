package com.robert.objectboxdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.robert.objectboxdemo.bean.LocalLotteryData;
import com.robert.objectboxdemo.bean.LotteryBall;
import com.robert.objectboxdemo.bean.LotteryPlayType;
import com.robert.objectboxdemo.bean.LotteryPlayType_;
import com.robert.objectboxdemo.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class MainActivity extends AppCompatActivity {
    private BoxStore store;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                mTvResult.setText("查询结果");
            }
        }
    };
    private TextView mTvResult;
    private EditText mEtNetId;
    private Box<LotteryPlayType> mLotteryPlayTypeBox;
    private Box<LotteryBall> mLotteryBallBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        store = ((App) getApplication()).getBoxStore();
        mLotteryPlayTypeBox = store.boxFor(LotteryPlayType.class);
        mLotteryBallBox = store.boxFor(LotteryBall.class);
        mTvResult = findViewById(R.id.tv_result);
        mEtNetId = findViewById(R.id.et_netid);
        findViewById(R.id.query).setOnClickListener(v -> {
            String netId = mEtNetId.getText().toString().trim();
            if (!TextUtils.isEmpty(netId)) {
                LotteryPlayType lotteryPlayType = mLotteryPlayTypeBox.query()
                        .equal(LotteryPlayType_.netid, netId)
                        .build()
                        .findUnique();
                mTvResult.setText(lotteryPlayType != null ? lotteryPlayType.toString() : "");
            }
        });
        initData();
    }

    private void initData() {
        new Thread() {
            @Override
            public void run() {
                String sscData = JsonUtil.readAssetJson(MainActivity.this, "ssc.json");
                TypeToken type = new TypeToken<List<LocalLotteryData>>() {
                };
                List<LocalLotteryData> list = new Gson().fromJson(sscData, type.getType());
                mLotteryPlayTypeBox.removeAll();
                mLotteryBallBox.removeAll();
                LocalLotteryData localLotteryData = list.get(0);
                List<LocalLotteryData.ListBean> bigPlayType = localLotteryData.getList();
                List<LotteryPlayType> lotteryPlayTypes = new ArrayList<>();
                for (LocalLotteryData.ListBean listBean : bigPlayType) {
                    for (LocalLotteryData.ListBean.TypeBean littlePlayType : listBean.getType()) {
                        LotteryPlayType lotteryPlayType = LotteryPlayType.createLotteryPlayType(littlePlayType);
                        List<LotteryBall> lotteryBalls = new ArrayList<>();
                        List<LocalLotteryData.ListBean.TypeBean.BallInfo> ballInfo = littlePlayType.getBallInfo();
                        for (LocalLotteryData.ListBean.TypeBean.BallInfo info : ballInfo) {
                            LotteryBall lotteryBall = LotteryBall.createLotteryBall(info);
                            lotteryBalls.add(lotteryBall);
                        }
                        lotteryPlayType.getLotteryBalls().addAll(lotteryBalls);
                        lotteryPlayTypes.add(lotteryPlayType);
                    }
                }
                mLotteryPlayTypeBox.put(lotteryPlayTypes);
                mHandler.sendEmptyMessage(1);
            }
        }.start();

    }
}
