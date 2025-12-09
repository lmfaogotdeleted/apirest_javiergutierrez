package com.example.apirest_javiergutierrez.data.network;

import android.telecom.Call;

import com.example.apirest_javiergutierrez.data.model.Character;
import com.example.apirest_javiergutierrez.data.model.CharacterResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("character")
    Call<CharacterResponse> getCharacters(@Query("page") int page);

    @GET("character/{id}")
    Call<Character> getCharacter(@Path("id") int id);

    @GET("character")
    Call<CharacterResponse> searchCharacter(@Query("name") String name);
}
