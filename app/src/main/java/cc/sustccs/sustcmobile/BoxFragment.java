package cc.sustccs.sustcmobile;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import cc.sustccs.sustcmobile.R;
/**
 * Created by asus on 2017/5/24.
 */

public class BoxFragment extends Fragment{
    private int gridHeight,gridWidth;
    private RelativeLayout layout;
    private RelativeLayout tmpLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_box, container, false);

        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tmpLayout = (RelativeLayout) getActivity().findViewById(R.id.Monday);

        Button box_btn=(Button)getActivity().findViewById(R.id.box_btn_normal);
        box_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text="算法设计基础@W3502";
                Toast tot = Toast.makeText(
                        getActivity(),
                        "刷新课表",
                        Toast.LENGTH_LONG);
                tot.show();

                addView(1,1,2,text);
                addView(7,2,3,text);
                addView(5,9,10,text);
                addView(4,2,3,text);
                addView(3,5,5,text);
                addView(4,10,12,text);
            }
        });
//        String text="算法设计基础@W3502";
//        addView(1,1,2,text);
//        addView(7,2,3,text);
//        addView(5,9,10,text);
//        addView(4,2,3,text);
//        addView(3,5,5,text);
//        addView(4,10,12,text);

    }

    private TextView createTv(int start,int end,String text){
        TextView tv = new TextView(getContext());
        /*
         指定高度和宽度
         */
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(gridWidth,gridHeight*(end-start+1));
        /*
        指定位置
         */
        tv.setY(gridHeight*(start-1));
        tv.setLayoutParams(params);
        tv.setGravity(Gravity.CENTER);
        tv.setText(text);
        return tv;
    }
    public void addView(int i,int start,int end,String text){
        TextView tv;

        switch (i){
            case 1:
                layout = (RelativeLayout) getActivity().findViewById(R.id.Monday);
                break;
            case 2:
                layout = (RelativeLayout) getActivity().findViewById(R.id.Tuesday);
                break;
            case 3:
                layout = (RelativeLayout) getActivity().findViewById(R.id.Wednesday);
                break;
            case 4:
                layout = (RelativeLayout) getActivity().findViewById(R.id.Thursday);
                break;
            case 5:
                layout = (RelativeLayout) getActivity().findViewById(R.id.Friday);
                break;
            case 6:
                layout = (RelativeLayout) getActivity().findViewById(R.id.Saturday);
                break;
            case 7:
                layout = (RelativeLayout) getActivity().findViewById(R.id.Sunday);
                break;
        }
        tv= createTv(start,end,text);
        tv.setBackgroundColor(Color.argb(100,start*5,(start+end)*20,0));
        layout.addView(tv);
    }

}
