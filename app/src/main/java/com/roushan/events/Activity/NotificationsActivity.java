package com.roushan.events.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.roushan.events.Adapter.NotificationAdapter;
import com.roushan.events.Model.Notification.NotificationModel;
import com.roushan.events.R;
import com.roushan.events.Model.Notification.TitleChild;
import com.roushan.events.Utils.TitleCreater1;
import com.roushan.events.Model.Notification.TitleParent;
/*import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;  */

import java.util.ArrayList;
import java.util.List;

public class NotificationsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView toolbar;
    NotificationAdapter adapter;
  //  DatabaseReference ref;
    public static ArrayList<NotificationModel> data;
    ProgressDialog p;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        toolbar = (TextView) findViewById(R.id.toolbarText);
    //    Typeface tf = Typeface.createFromAsset(getAssets(), "ToolbarText.ttf");
    //    toolbar.setTypeface(tf);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.events, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner.setAdapter(adapter);

        recyclerView=(RecyclerView)findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        data = new ArrayList<>();

    //    p=new ProgressDialog(this);
        // onItemSelect();




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            //    ((TextView)adapterView.getChildAt(0)).setTextColor(Color.WHITE);
            //    onItemSelect();
                  Toast.makeText(getApplication(),spinner.getSelectedItem().toString(),
                          Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
/*
    public void onItemSelect() {

        p.setMessage("Loading Feed....");
        p.setCancelable(true);
        p.show();
        ref= FirebaseDatabase.getInstance().getReference().child("feed").child(spinner.getSelectedItem().toString());
        ref.keepSynced(true);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                p.dismiss();
                data.clear();
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    NotificationModel q=ds.getValue(NotificationModel.class);
                    data.add(q);
                    // Toast.makeText(FAQActivity.this,"Q"+q.getQuestion()+"\nA:"+q.getAns(),Toast.LENGTH_SHORT).show();

                }

                adapter = new NotificationAdapter(NotificationsActivity.this, initData());
                adapter.setParentClickableViewAnimationDefaultDuration();
                adapter.setParentAndIconExpandOnClick(true);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }  */



    private List<ParentObject> initData() {
        TitleCreater1 titleCreater= new TitleCreater1(NotificationsActivity.this);
        //titleCreater= TitleCreater.get(this);
        List<TitleParent> titles = TitleCreater1._titleParents;
        List<ParentObject> parentObject = new ArrayList<>();
        //Toast.makeText(NotificationsActivity.this,"Title:"+titles.size(),Toast.LENGTH_SHORT).show();
        int i=data.size()-1;
        for(TitleParent title:titles)
        {
            List<Object> childList = new ArrayList<>();
            //childList.add(new TitleChild(("It is LSE web style to title a page of FAQs 'Frequently asked questions (FAQs)'. While the abbreviation is in quite common usage this ensures that there can be no mistaking what they are")));
            childList.add(new TitleChild(data.get(i--).getAns()));
            title.setChildObjectList(childList);
            parentObject.add(title);
        }
        return parentObject;
    }














}

