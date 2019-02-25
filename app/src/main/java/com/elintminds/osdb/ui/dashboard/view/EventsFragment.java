package com.elintminds.osdb.ui.dashboard.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.dashboard.adapters.EventsListAdapter;
import com.elintminds.osdb.ui.dashboard.beans.EventsAdapterBean;
import com.elintminds.osdb.ui.event_details.view.EventDetailsActivity;
import com.elintminds.osdb.utils.CardPaddingItemDecoration;

import java.util.ArrayList;

public class EventsFragment extends BaseFragment implements DashboardView.EventsItemsClickListener {

    public static final String TAG = "EventsFragment";

    private Context context;
    private ShimmerRecyclerView eventsRecyclerView;
    private ArrayList<EventsAdapterBean> eventsList = new ArrayList<>();
    private EventsListAdapter adapter;

    public static EventsFragment getInstance()
    {
        return new EventsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.events_fragment_view, container, false);
    }

    @Override
    protected void setUp(View view)
    {
        context = getContext();
        eventsRecyclerView = view.findViewById(R.id.events_recycler_view);

        setupRecyclerView();
    }


    private void setupRecyclerView()
    {
        CardPaddingItemDecoration itemDecoration = new CardPaddingItemDecoration(context, 10f, 10f, 20f,20f);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        adapter = new EventsListAdapter(context, eventsList, this);

        eventsRecyclerView.addItemDecoration(itemDecoration);
        eventsRecyclerView.setLayoutManager(layoutManager);
        eventsRecyclerView.setNestedScrollingEnabled(false);
        eventsRecyclerView.setAdapter(adapter);
        eventsRecyclerView.showShimmerAdapter();

        eventsRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadNewsData();
            }
        }, 3000);

    }

    private void loadNewsData()
    {
        String[] newsArray = context.getResources().getStringArray(R.array.sampl_events);
        for(String nws : newsArray)
        {
            EventsAdapterBean item = new EventsAdapterBean();
            item.setTitle(nws);
            eventsList.add(item);
        }

        adapter.setDataList(eventsList);
        eventsRecyclerView.hideShimmerAdapter();
    }

    @Override
    public void onShowDetailsClick(int position)
    {
        EventsAdapterBean item = eventsList.get(position);
        String[] titles = item.getTitle().split("VS");
        Intent intent = new Intent(context, EventDetailsActivity.class);
        if(titles.length > 1)
        {
            intent.putExtra("TITLE_1", titles[0]);
            String[] titles2 = titles[1].split("AT");
            intent.putExtra("TITLE_2", titles2[0]);
        }else {
            intent.putExtra("TITLE_1", titles[0]);
        }
        startActivity(intent);
    }
}
