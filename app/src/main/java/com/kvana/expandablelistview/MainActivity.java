package com.kvana.expandablelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ExpandableListView;

import com.kvana.expandablelistview.network.RetrofitHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expListView = (ExpandableListView) findViewById(R.id.simpleExpandableListView);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousItem = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                Log.e("info >> ", "onGroupExpand: >> ");
                if (groupPosition != previousItem)
                    expListView.collapseGroup(previousItem);
                previousItem = groupPosition;
            }
        });

        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            int previousItem = -1;

            @Override
            public void onGroupCollapse(int groupPosition) {
                Log.e("info >> ", "onGroupCollapse: >> ");
                if (groupPosition != previousItem)
                    expListView.collapseGroup(previousItem);
                previousItem = groupPosition;
            }
        });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        RetrofitHandler.getInstance().getNamesList().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    List<String> top0 = new ArrayList<String>();
                    List<String> top1 = new ArrayList<String>();
                    List<String> top2 = new ArrayList<String>();
                    List<String> top3 = new ArrayList<String>();
                    List<String> top4 = new ArrayList<String>();
                    List<String> top5 = new ArrayList<String>();
                    List<String> top6 = new ArrayList<String>();
                    List<String> top7 = new ArrayList<String>();
                    List<String> top8 = new ArrayList<String>();
                    List<String> top9 = new ArrayList<String>();
                    List<String> top10 = new ArrayList<String>();
                    List<String> top11 = new ArrayList<String>();
                    try {
                        JSONObject jsonObject = new JSONObject(response.body());
                        JSONArray jsonArray = jsonObject.getJSONArray("android");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            String ver = jsonObject1.getString("ver");
                            String name = jsonObject1.getString("name");
                            String api = jsonObject1.getString("api");
                            if (i == 0) {
                                listDataHeader.add(String.valueOf(i) + "_" + ver);
                                top0.add(ver);
                                top0.add(name);
                                top0.add(api);
                            } else if (i == 1) {
                                listDataHeader.add(String.valueOf(i) + "_" + ver);
                                top1.add(ver);
                                top1.add(name);
                                top1.add(api);
                            } else if (i == 2) {
                                listDataHeader.add(String.valueOf(i) + "_" + ver);
                                top2.add(ver);
                                top2.add(name);
                                top2.add(api);
                            } else if (i == 3) {
                                listDataHeader.add(String.valueOf(i) + "_" + ver);
                                top3.add(ver);
                                top3.add(name);
                                top3.add(api);
                            } else if (i == 4) {
                                listDataHeader.add(String.valueOf(i) + "_" + ver);
                                top4.add(ver);
                                top4.add(name);
                                top4.add(api);
                            } else if (i == 5) {
                                listDataHeader.add(String.valueOf(i) + "_" + ver);
                                top5.add(ver);
                                top5.add(name);
                                top5.add(api);
                            } else if (i == 6) {
                                listDataHeader.add(String.valueOf(i) + "_" + ver);
                                top6.add(ver);
                                top6.add(name);
                                top6.add(api);
                            } else if (i == 7) {
                                listDataHeader.add(String.valueOf(i) + "_" + ver);
                                top7.add(ver);
                                top7.add(name);
                                top7.add(api);
                            } else if (i == 8) {
                                listDataHeader.add(String.valueOf(i) + "_" + ver);
                                top8.add(ver);
                                top8.add(name);
                                top8.add(api);
                            } else if (i == 9) {
                                listDataHeader.add(String.valueOf(i) + "_" + ver);
                                top9.add(ver);
                                top9.add(name);
                                top9.add(api);
                            } else if (i == 10) {
                                listDataHeader.add(String.valueOf(i) + "_" + ver);
                                top10.add(ver);
                                top10.add(name);
                                top10.add(api);
                            } else if (i == 11) {
                                listDataHeader.add(String.valueOf(i) + "_" + ver);
                                top11.add(ver);
                                top11.add(name);
                                top11.add(api);
                            }
                            Log.d("info >> ", "onResponse: >>> " + i + ver + name + api);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    listDataChild.put(listDataHeader.get(0), top0);
                    listDataChild.put(listDataHeader.get(1), top1);
                    listDataChild.put(listDataHeader.get(2), top2);
                    listDataChild.put(listDataHeader.get(3), top3);
                    listDataChild.put(listDataHeader.get(4), top4);
                    listDataChild.put(listDataHeader.get(5), top5);
                    listDataChild.put(listDataHeader.get(6), top6);
                    listDataChild.put(listDataHeader.get(7), top7);
                    listDataChild.put(listDataHeader.get(8), top8);
                    listDataChild.put(listDataHeader.get(9), top9);
                    listDataChild.put(listDataHeader.get(10), top10);
                    listDataChild.put(listDataHeader.get(11), top11);
                    expListView.setAdapter(listAdapter);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("info >> ", "onResponse: >>> " + t.getLocalizedMessage());
            }
        });
    }
}
