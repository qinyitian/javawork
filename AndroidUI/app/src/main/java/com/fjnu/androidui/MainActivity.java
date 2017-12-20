package com.fjnu.androidui;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private SimpleAdapter sim_aAdapter; // 1. 新建一个数据适配器

    private List<Map<String, Object>> dataList; // 数据源

    /** SimpleAdapter(context, data, resource, from, to)
     *  context: 上下文
     *  data: 数据源(List<? extends Map<String, ?>> data),一个Map所组成的List集合
     *        每个Map都会对应ListView列表中的一行，Map是由键【必须包含所有在from中所指定的键】值对组成
     *  resource:列表中的布局文件的ID，此处的布局是自定义的
     *  from:Map中的键名
     *  to:绑定数据视图中的ID,与from成对应关系
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //showlistview();
        showdialog();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //四个参数的含义。1，group的id,2,item的id,3,是否排序，4，将要显示的内容

        SubMenu sub=menu.addSubMenu("字体大小");
        sub.add(0,1,0,"小");
        sub.add(0,2,0,"中");
        sub.add(0,3,0,"大");
        SubMenu sub1=menu.addSubMenu("颜色");
        sub1.add(0,4,0,"红色");
        sub1.add(0,5,0,"黑色");

        menu.add(0,6,0,"toast提示");

        return true;
    }

    public void UpdateTextviewFont(float x){
        TextView tv =(TextView)findViewById(R.id.maintextview);
        tv.setTextSize(x);
    }
    public void UpdateTextviewFont(int x){
        TextView tv =(TextView)findViewById(R.id.maintextview);
        if(x == 1) {
            tv.setTextColor(Color.RED);
        }
        else
            tv.setTextColor(Color.BLACK);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                UpdateTextviewFont(10);
                Toast.makeText(MainActivity.this,"字体小",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                UpdateTextviewFont(16);
                Toast.makeText(MainActivity.this,"字体中",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                UpdateTextviewFont(20);
                Toast.makeText(MainActivity.this,"字体大",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                UpdateTextviewFont(1);
                Toast.makeText(MainActivity.this,"红色",Toast.LENGTH_SHORT).show();
                break;
            case 5:
                UpdateTextviewFont(2);
                Toast.makeText(MainActivity.this,"黑色",Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(MainActivity.this,"toast提示",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private void showlistview(){
        listView = (ListView)findViewById(R.id.list_view1);


        // 2. 适配器加载数据源
        dataList = new ArrayList<Map<String, Object>>();
        dataList = getData();
        sim_aAdapter = new SimpleAdapter(this, dataList, R.layout.item, new String[]{"text0", "pic0"}, new int[]{R.id.text, R.id.pic});
        // 3. 视图(ListView)加载适配器
        listView.setAdapter(sim_aAdapter);

    }

    private void showdialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setTitle("这是一个弹出对话框");
        LinearLayout loginDiablog = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_dialog,null);
        builder.setView(loginDiablog);

        builder.setCancelable(true);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();//将dialog显示出来

    }
    private List<Map<String, Object>> getData(){


        Map<String, Object>map = new HashMap<String, Object>();
        map.put("text0", "cat");
        map.put("pic0", R.drawable.cat);
        dataList.add(map);

        Map<String, Object>map1 = new HashMap<String, Object>();
        map1.put("text0", "dog");
        map1.put("pic0", R.drawable.dog);
        dataList.add(map1);

        Map<String, Object>map2 = new HashMap<String, Object>();
        map2.put("text0", "elephant");
        map2.put("pic0", R.drawable.elephant);
        dataList.add(map2);

        Map<String, Object>map3 = new HashMap<String, Object>();
        map3.put("text0", "lion");
        map3.put("pic0", R.drawable.lion);
        dataList.add(map3);

        Map<String, Object>map4 = new HashMap<String, Object>();
        map4.put("text0", "monkey");
        map4.put("pic0", R.drawable.monkey);
        dataList.add(map4);

        Map<String, Object>map5 = new HashMap<String, Object>();
        map5.put("text0", "tiger");
        map5.put("pic0", R.drawable.tiger);
        dataList.add(map5);
        System.out.println(dataList);

        return dataList;
    }
}
