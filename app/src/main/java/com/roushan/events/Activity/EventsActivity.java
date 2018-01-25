package com.roushan.events.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.ramotion.foldingcell.FoldingCell;
import com.roushan.events.Fragments.BranchHeadDialogFragment;
import com.roushan.events.Adapter.FoldingCellListAdapter;
import com.roushan.events.Model.Item;
import com.roushan.events.R;


import java.util.ArrayList;

/**
 * Example of using Folding Cell with ListView and ListAdapter
 */
public class EventsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    TextView toolbar_tv;
    public static int SE;
    private ImageView notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        // get our list view
        final ListView theListView = (ListView) findViewById(R.id.mainListView);

        // prepare elements to display
        final ArrayList<Item> items = Item.getTestingList();
        final FoldingCellListAdapter adapter = new FoldingCellListAdapter(this, items);
//
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar_tv = (TextView) findViewById(R.id.title_toolbar);
//        toolbar_tv.setText("OJASS EVENTS");
//        Typeface customFontBold = Typeface.createFromAsset(getAssets(), "ToolbarText.ttf");
//        toolbar_tv.setTypeface(customFontBold);

        notifications = (ImageView) findViewById(R.id.notifications);
        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EventsActivity.this, NotificationsActivity.class);
                startActivity(i);
            }
        });

        for (int i = 0; i < 17; i++) {
            final int I = i;
            // add custom btn handler to first list item

            items.get(i).setRequestBtnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent subEvent =new Intent(EventsActivity.this,SubEventsActivity.class);
                    subEvent.putExtra("title",items.get(I).getSub1());
                    startActivity(subEvent);
                }
            });
            items.get(i).setRequestBtnClickListener2(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent subEvent =new Intent(EventsActivity.this,SubEventsActivity.class);
                    subEvent.putExtra("title",items.get(I).getSub2());
                    startActivity(subEvent);
                }
            });
            items.get(i).setRequestBtnClickListener3(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent subEvent =new Intent(EventsActivity.this,SubEventsActivity.class);
                    subEvent.putExtra("title",items.get(I).getSub3());
                    startActivity(subEvent);                }
            });
            items.get(i).setRequestBtnClickListener4(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent subEvent =new Intent(EventsActivity.this,SubEventsActivity.class);
                    subEvent.putExtra("title",items.get(I).getSub4());
                    startActivity(subEvent);
                }
            });
            items.get(i).setRequestBtnClickListener5(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent subEvent =new Intent(EventsActivity.this,SubEventsActivity.class);
                    subEvent.putExtra("title",items.get(I).getSub5());
                    startActivity(subEvent);
                }
            });
            items.get(i).setRequestBtnClickListener6(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent subEvent =new Intent(EventsActivity.this,SubEventsActivity.class);
                    subEvent.putExtra("title",items.get(I).getSub6());
                    startActivity(subEvent);
                }
            });
            items.get(i).setRequestBtnClickListener7(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent subEvent =new Intent(EventsActivity.this,SubEventsActivity.class);
                    subEvent.putExtra("title",items.get(I).getSub7());
                    startActivity(subEvent);
                }
            });
            items.get(i).setRequestBtnClickListener8(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent subEvent =new Intent(EventsActivity.this,SubEventsActivity.class);
                    subEvent.putExtra("title",items.get(I).getSub8());
                    startActivity(subEvent);
                }
            });
            items.get(i).setRequestBtnClickListener9(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent subEvent =new Intent(EventsActivity.this,SubEventsActivity.class);
                    subEvent.putExtra("title",items.get(I).getSub9());
                    startActivity(subEvent);
                }
            });
            items.get(i).setRequestBtnClickListener10(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent subEvent =new Intent(EventsActivity.this,SubEventsActivity.class);
                    subEvent.putExtra("title",items.get(I).getSub10());
                    startActivity(subEvent);
                }
            });
            items.get(i).setRequestBtnClickListener11(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SE=I;
                    BranchHeadDialogFragment dialogFragment=new BranchHeadDialogFragment();
                    dialogFragment.show(getFragmentManager(),"My Dialog");
                }
            });
        }
        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)


        // add default btn handler for each request btn on each item if custom handler not found
        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getApplicationContext(), "DEFAULT HANDLER FOR ALL BUTTONS", Toast.LENGTH_SHORT).show();
            }
        });

        // set elements to adapter
        theListView.setAdapter(adapter);
        // set on click event listener to list view
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(pos);
               /* if(v==null)
                {
                    p=pos;
                    v=view;
                }
                else if(view==v)
                {
                    p=-1;
                    v=null;
                }
                else
                {
                    ((FoldingCell) v).toggle(false);
                    adapter.registerToggle(p);
                    p=pos;
                    v=view;
                }*/

            }
        });

    }
}
