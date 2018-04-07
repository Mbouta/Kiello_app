package com.example.gabriellekibouka.testguide.ws;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.antapp.flash_ws.config.GetObjectList;
import com.antapp.flash_ws.interfaces.AntappNetWorkHelper;
import com.antapp.flash_ws.interfaces.AntappObjectListListener;
import com.antapp.flash_ws.utils.AntappUtilsMethods;
import com.example.gabriellekibouka.testguide.adapters.AdapterRecycleVTimeLine;
import com.example.gabriellekibouka.testguide.objets.TimeLine;
import com.example.gabriellekibouka.testguide.utils.Const;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by lebeau BAFOUIDIZO on 07/04/2018.
 */

public class GetTimelineRequest implements AntappNetWorkHelper {

    private Context context;
    private String url;
    private Object progressObject;
    private RecyclerView recyclerViewTimeline;

    public GetTimelineRequest(Context context, String url, Object progressObject, RecyclerView recyclerViewTimeline) {
        this.context = context;
        this.url = url;
        this.progressObject = progressObject;
        this.recyclerViewTimeline = recyclerViewTimeline;
    }

    @Override
    public void onNetworkRequest() {
        GetObjectList list = new GetObjectList(context, Const.GET_TIMELINE,progressObject);
        list.getObjectListFromServer("timeline", TimeLine.class, new AntappObjectListListener() {
            @Override
            public void ifNoNetwork(RequestQueue queue, StringRequest request, JSONArray jsonArray, List<?> myObjectlist) {

                if (!AntappUtilsMethods.isNetworkAvailable(context)){
                    //si ya pas internet on selectionne dans le cache les element
                    //annullation de la requette
                    AntappUtilsMethods.cancelRequest(queue,request);
                    List<TimeLine> timeLinesList = (List<TimeLine>) myObjectlist;

                    recyclerViewTimeline.setAdapter(new AdapterRecycleVTimeLine(timeLinesList,context));

                    //passer a ladapter que vous pouvez passer dans le constructeur

                }

            }

            @Override
            public void onListResponse(JSONArray jsonArray, List<?> myObjectlist) {
                List<TimeLine> timeLinesList = (List<TimeLine>) myObjectlist;

            }

            @Override
            public void onError(VolleyError myError) {

            }
        });
    }
}
