package com.example.gabrielmoro.xyz_reader.api;

import com.example.gabrielmoro.xyz_reader.model.XyzReaderJson;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Defines the endpoints.
 * Reference: https://medium.com/3xplore/handling-api-calls-using-retrofit-2-and-rxjava-2-1871c891b6ae
 */
public interface APIService {

    @GET("xyz-reader.json")
    Observable<List<XyzReaderJson>> getRecipes();
}