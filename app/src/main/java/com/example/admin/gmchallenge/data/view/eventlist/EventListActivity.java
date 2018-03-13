package com.example.admin.gmchallenge.data.view.eventlist;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.gmchallenge.R;
import com.example.admin.gmchallenge.data.GMApplication;
import com.example.admin.gmchallenge.data.model.Meetup;
import com.example.admin.gmchallenge.data.utils.Constants;
import com.example.admin.gmchallenge.data.view.eventdetail.EventDetailActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventListActivity extends AppCompatActivity implements EventListContract.View, EventListAdapter.OnItemClickListener {

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 10;
    @Inject
    EventListPresenter presenter;
    @BindView(R.id.eventList)
    RecyclerView eventListView;

    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        ButterKnife.bind(this);
        setupEventListView();
    }

    private void setupEventListView() {
        layoutManager = new LinearLayoutManager(this);
        eventListView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupDaggerComponent();
        presenter.attachView(this);
        presenter.checkPermission();
    }

    private void setupDaggerComponent() {
        GMApplication.get(this).getEventListComponent().inject(this);
    }


    @Override
    public void onEventsReceived(List<Meetup> meetupList) {

        EventListAdapter eventListAdapter = new EventListAdapter(this, meetupList, this);
        eventListView.setAdapter(eventListAdapter);
        // TODO: 3/13/18 Implement lazy loading for endless scrolling

    }

    @Override
    public void onPermissionCheck() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION
                                , Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
        } else {
            presenter.getCurrentLocation();
        }
    }


    @SuppressLint("MissingPermission")
    @Override
    public void onCurrentLocation() {


        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        String lat = String.valueOf(location.getLatitude());
                        String lon = String.valueOf(location.getLongitude());
                        Log.d("TAG", "onSuccess: " + location.toString());
                        presenter.getEventList(lat, lon);
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        presenter.showError(e.getMessage());
                    }
                });

    }

    @Override
    public void onErrorReceived(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(Meetup item) {

        Intent intent = new Intent(this, EventDetailActivity.class);
        intent.putExtra(Constants.EXTRA.EVENT, item);
        startActivity(intent);

    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
        GMApplication.get(this).clearEventListComponent();
    }
}
