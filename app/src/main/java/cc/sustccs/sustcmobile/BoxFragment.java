package cc.sustccs.sustcmobile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cc.sustccs.sustcmobile.R;
/**
 * Created by asus on 2017/5/24.
 */

public class BoxFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_box, container, false);

        return view;
    }

}
