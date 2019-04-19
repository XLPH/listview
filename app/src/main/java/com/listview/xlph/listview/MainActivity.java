package com.listview.xlph.listview;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Goods> goodsList = new ArrayList<>();
    Button totalPrice;
    Button selectAll;
    Button selectNone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        initGoods();
        ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(), R.layout.listview_item, goodsList);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

    }

    public void initGoods(){
        Goods sakura = new Goods(R.mipmap.sakuranecklace, "新一兰樱花名牌吊坠", 169);
        Goods xinyi = new Goods(R.mipmap.xinyi, "新一游乐园挂件", 90);
        Goods lan = new Goods(R.mipmap.lan, "兰游乐园挂件" , 90);
        goodsList.add(sakura);
        goodsList.add(xinyi);
        goodsList.add(lan);
    }
    public void initView(){
        totalPrice = (Button) findViewById(R.id.total_price);
        selectAll = (Button) findViewById(R.id.select_all);
        selectNone = (Button) findViewById(R.id.select_none);
    }
    public void initEvent(){
        totalPrice.setOnClickListener(this);
        selectAll.setOnClickListener(this);
        selectNone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.total_price:
                Toast.makeText(getApplicationContext(), "总价为" + ListViewAdapter.totalPrice, Toast.LENGTH_SHORT).show();
                break;
            case R.id.select_all:
                for(int i = 0; i < 3; i++){
                    ListViewAdapter.isBuy[i] = true;
                }
                break;
                default:
                    break;

        }
    }
}
