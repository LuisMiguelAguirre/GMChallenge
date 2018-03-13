package com.example.admin.gmchallenge.data.view.eventdetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.gmchallenge.R;
import com.example.admin.gmchallenge.data.GMApplication;
import com.example.admin.gmchallenge.data.model.Meetup;
import com.example.admin.gmchallenge.data.utils.Constants;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventDetailActivity extends AppCompatActivity implements EventDetailContract.View {

    @Inject
    EventDetailPresenter presenter;
    @BindView(R.id.ivEvent)
    ImageView ivEvent;
    @BindView(R.id.tvEvent)
    TextView tvEvent;
    private Meetup meetup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        ButterKnife.bind(this);
        meetup = (Meetup) getIntent().getSerializableExtra(Constants.EXTRA.EVENT);

    }

    @Override
    protected void onStart() {
        super.onStart();
        setupDaggerComponent();
        presenter.attachView(this);
        presenter.getEventDetail(meetup);
    }

    private void setupDaggerComponent() {
        GMApplication.get(this).getEventDetailComponent().inject(this);

    }

    @Override
    public void onErrorReceived(String error) {

    }

    @Override
    public void onEventDetailReceived(Meetup meetup) {

        Picasso.with(this).load(meetup.getKeyPhoto().getHighresLink()).into(ivEvent);
        tvEvent.setText(meetup.getDescription());
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
        GMApplication.get(this).clearEventDetailComponent();
    }
}
