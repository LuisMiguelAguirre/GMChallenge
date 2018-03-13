package com.example.admin.gmchallenge.data.data.remote;


import com.example.admin.gmchallenge.data.model.Meetup;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Luis on 3/13/18.
 */

public interface NetworkService {

    @GET("find/groups")
    Observable<List<Meetup>> getEventList(
            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("key") String key
    );
}
