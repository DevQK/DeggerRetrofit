package khanh.deggerretrofit.API;

import java.util.List;

import khanh.deggerretrofit.Model.Hero;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APISevices {
    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
