package com.learning.vitaliylakusta.learnmixer1_phone;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaliy on 3/15/2015.
 */
public class ResourceAdapter extends ArrayAdapter<String> {

    String[] resources;
    Context context;

    public ResourceAdapter(Context context, String[] resources) {
        super(context, R.layout.learning_resource, resources);
        this.resources = resources;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.learning_resource, parent, false);

        final String resourceTitleText = getItem(position);
        TextView resourceTitle = (TextView) rowView.findViewById(R.id.resourceTitle);
        resourceTitle.setText(resourceTitleText);

        Button btnResource = (Button) rowView.findViewById(R.id.btnResource);
        btnResource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ResourceDetails.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("resourceTitle", resourceTitleText);
                context.startActivity(intent);
            }
        });

        return rowView;
    }


}
