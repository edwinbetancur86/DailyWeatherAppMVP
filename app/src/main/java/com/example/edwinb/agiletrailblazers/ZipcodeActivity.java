package com.example.edwinb.agiletrailblazers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.edwinb.agiletrailblazers.Dagger.App;
import com.example.edwinb.agiletrailblazers.ZipCodeMVP.ZipCodeActivityMVP;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZipcodeActivity extends MotherActivity implements ZipCodeActivityMVP.View{

    @Inject
    ZipCodeActivityMVP.Presenter presenter;

    private EditText zipAndCountryCodeEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zipcode);
        ((App) getApplication()).getComponent().inject(this);
        zipAndCountryCodeEdit = (EditText) findViewById(R.id.editZipAndCountryCode);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    public String getZipAndCountryCode() {
        return zipAndCountryCodeEdit.getText().toString();
    }

    @Override
    public String getApiKey() {
        return BuildConfig.SERVICE_API_KEY;
    }

    @Override
    public void showInputError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    public void displayWeather(View view) {
        presenter.showWeatherButtonClicked(this, dataFacade);
    }
}
