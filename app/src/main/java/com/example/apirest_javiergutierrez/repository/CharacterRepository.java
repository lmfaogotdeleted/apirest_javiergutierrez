package com.example.apirest_javiergutierrez.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apirest_javiergutierrez.data.model.Character;
import com.example.apirest_javiergutierrez.data.model.CharacterResponse;
import com.example.apirest_javiergutierrez.data.network.ApiClient;
import com.example.apirest_javiergutierrez.data.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterRepository {
    private ApiService apiService;

    public CharacterRepository() {
        apiService = ApiClient.getClient().create(ApiService.class);
    }

    public LiveData<CharacterResponse> getCharacters(int page) {
        MutableLiveData<CharacterResponse> data = new MutableLiveData<>();
        apiService.getCharacters(page).enqueue(new org.chromium.base.Callback<CharacterResponse>() {
            @Override
            public void onResponse(Call<CharacterResponse> call, androidx.tracing.perfetto.handshake.protocol.Response<CharacterResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CharacterResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

}
