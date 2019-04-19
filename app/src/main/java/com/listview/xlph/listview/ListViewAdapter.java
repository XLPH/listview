package com.listview.xlph.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Goods>{
    private int resourceId;
    public static Boolean[] isBuy = new Boolean[3];
    public static int totalPrice = 0;
    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        resourceId = resource;

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final Goods goods = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        }else {
            view = convertView;
        }
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView goodsName = view.findViewById(R.id.tv_name);
        final TextView goodsPrice = view.findViewById(R.id.tv_price);
        Button goodsInfo = view.findViewById(R.id.btn_info);
        imageView.setImageResource(goods.getImageId());
        goodsName.setText(goods.getName());
        goodsPrice.setText("￥" + goods.getPrice());
        goodsInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), goods.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox checkBox = view.findViewById(R.id.check_box);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isBuy[position] = b;
                if(b) totalPrice += goods.getPrice();
            }
        });
        return view;
    }
}
