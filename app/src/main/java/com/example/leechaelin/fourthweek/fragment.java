package com.example.leechaelin.fourthweek;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by leechaelin on 2017. 3. 30..
 */

public class fragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragview = inflater.inflate(R.layout.activity_fragement,container,false);
        TextView textView = (TextView)fragview.findViewById(R.id.textView);

        return fragview;
    }

}
