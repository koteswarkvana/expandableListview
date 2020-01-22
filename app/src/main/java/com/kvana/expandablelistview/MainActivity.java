package com.kvana.expandablelistview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ExpandableListView;

import com.kvana.expandablelistview.network.RetrofitHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private int lastExpandedPosition = -1;

    HashMap<String, String> CHILD_NAME_DOB = new HashMap<>();
    String laptop, received_by, handedover_by, date;


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

//        RetrofitHandler.getInstance().getNamesList().enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                if (response.isSuccessful()) {
//                    List<String> top0 = new ArrayList<String>();
//                    List<String> top1 = new ArrayList<String>();
//                    List<String> top2 = new ArrayList<String>();
//                    List<String> top3 = new ArrayList<String>();
//                    List<String> top4 = new ArrayList<String>();
//                    List<String> top5 = new ArrayList<String>();
//                    List<String> top6 = new ArrayList<String>();
//                    List<String> top7 = new ArrayList<String>();
//                    List<String> top8 = new ArrayList<String>();
//                    List<String> top9 = new ArrayList<String>();
//                    List<String> top10 = new ArrayList<String>();
//                    List<String> top11 = new ArrayList<String>();
//                    try {
//                        JSONObject jsonObject = new JSONObject(response.body());
//                        JSONArray jsonArray = jsonObject.getJSONArray("android");
//                        for (int i = 0; i < jsonArray.length(); i++) {
//                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//                            String ver = jsonObject1.getString("ver");
//                            String name = jsonObject1.getString("name");
//                            String api = jsonObject1.getString("api");
//                            if (i == 0) {
//                                listDataHeader.add(String.valueOf(i) + "_" + ver);
//                                top0.add(ver);
//                                top0.add(name);
//                                top0.add(api);
//                            } else if (i == 1) {
//                                listDataHeader.add(String.valueOf(i) + "_" + ver);
//                                top1.add(ver);
//                                top1.add(name);
//                                top1.add(api);
//                            } else if (i == 2) {
//                                listDataHeader.add(String.valueOf(i) + "_" + ver);
//                                top2.add(ver);
//                                top2.add(name);
//                                top2.add(api);
//                            } else if (i == 3) {
//                                listDataHeader.add(String.valueOf(i) + "_" + ver);
//                                top3.add(ver);
//                                top3.add(name);
//                                top3.add(api);
//                            } else if (i == 4) {
//                                listDataHeader.add(String.valueOf(i) + "_" + ver);
//                                top4.add(ver);
//                                top4.add(name);
//                                top4.add(api);
//                            } else if (i == 5) {
//                                listDataHeader.add(String.valueOf(i) + "_" + ver);
//                                top5.add(ver);
//                                top5.add(name);
//                                top5.add(api);
//                            } else if (i == 6) {
//                                listDataHeader.add(String.valueOf(i) + "_" + ver);
//                                top6.add(ver);
//                                top6.add(name);
//                                top6.add(api);
//                            } else if (i == 7) {
//                                listDataHeader.add(String.valueOf(i) + "_" + ver);
//                                top7.add(ver);
//                                top7.add(name);
//                                top7.add(api);
//                            } else if (i == 8) {
//                                listDataHeader.add(String.valueOf(i) + "_" + ver);
//                                top8.add(ver);
//                                top8.add(name);
//                                top8.add(api);
//                            } else if (i == 9) {
//                                listDataHeader.add(String.valueOf(i) + "_" + ver);
//                                top9.add(ver);
//                                top9.add(name);
//                                top9.add(api);
//                            } else if (i == 10) {
//                                listDataHeader.add(String.valueOf(i) + "_" + ver);
//                                top10.add(ver);
//                                top10.add(name);
//                                top10.add(api);
//                            } else if (i == 11) {
//                                listDataHeader.add(String.valueOf(i) + "_" + ver);
//                                top11.add(ver);
//                                top11.add(name);
//                                top11.add(api);
//                            }
//                            Log.d("info >> ", "onResponse: >>> " + i + ver + name + api);
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                    listDataChild.put(listDataHeader.get(0), top0);
//                    listDataChild.put(listDataHeader.get(1), top1);
//                    listDataChild.put(listDataHeader.get(2), top2);
//                    listDataChild.put(listDataHeader.get(3), top3);
//                    listDataChild.put(listDataHeader.get(4), top4);
//                    listDataChild.put(listDataHeader.get(5), top5);
//                    listDataChild.put(listDataHeader.get(6), top6);
//                    listDataChild.put(listDataHeader.get(7), top7);
//                    listDataChild.put(listDataHeader.get(8), top8);
//                    listDataChild.put(listDataHeader.get(9), top9);
//                    listDataChild.put(listDataHeader.get(10), top10);
//                    listDataChild.put(listDataHeader.get(11), top11);
//                    expListView.setAdapter(listAdapter);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.d("info >> ", "onResponse: >>> " + t.getLocalizedMessage());
//            }
//        });
        RetrofitHandler.getInstance().getData("application/json", new Model("5")).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: ");
                    try {
                        JSONObject jsonObject = new JSONObject(response.body());
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            List<String> top = new ArrayList<String>();
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            CHILD_NAME_DOB.put(String.valueOf(i), jsonArray.getJSONObject(i).keys().next());
                            String headerDate = jsonArray.getJSONObject(i).keys().next();
                            JSONArray subJsonArray = jsonObject1.getJSONArray(CHILD_NAME_DOB.get(String.valueOf(i)));
                            listDataHeader.add(String.valueOf(i) + "_" + dateConverter(headerDate));
                            if (subJsonArray != null) {
                                for (int j = 0; j < subJsonArray.length(); j++) {
                                    JSONObject subjsonObject1 = subJsonArray.getJSONObject(j);
                                    if (subjsonObject1 != null) {
                                        laptop = subjsonObject1.getString("laptop");
                                        received_by = subjsonObject1.getString("received_by");
                                        handedover_by = subjsonObject1.getString("vault_history_id");
                                        date = subjsonObject1.getString("date");
                                            top.add(laptop);
                                            top.add(received_by);
                                            top.add(handedover_by);
                                        listDataChild.put(listDataHeader.get(i), top);
                                    } else {
                                        top.add(CHILD_NAME_DOB.get(String.valueOf(i)));
                                    }
                                }
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    expListView.setAdapter(listAdapter);
                } else {
                    Log.d(TAG, "fail: ");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    @SuppressLint("SimpleDateFormat")
    public String dateConverter(String date) {
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = null;
        try {
            newDate = spf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        spf = new SimpleDateFormat("dd MMM");
        String newDateString = spf.format(newDate);
        Log.d(TAG, "dateConverter: " + newDateString);
        return newDateString;
    }
}
