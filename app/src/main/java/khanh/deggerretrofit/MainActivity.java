package khanh.deggerretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import khanh.deggerretrofit.API.APISevices;
import khanh.deggerretrofit.App.MyApplication;
import khanh.deggerretrofit.Model.Hero;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication()).getApiComponent().inJection(this);
        initViews();
        getDataAPi();
    }
    private void initViews() {
        listView = (ListView) findViewById(R.id.lvMainActivity);
    }
    private void getDataAPi() {
        APISevices api = retrofit.create(APISevices.class);
        Call<List<Hero>> call = api.getHeroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                getListsData(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });
    }

    private void getListsData(List<Hero> body) {
        String[] heros = new String[body.size()];
        for (int i = 0; i < body.size(); i++){
            heros[i] = body.get(i).getBio();
        }
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, heros));
    }
}
