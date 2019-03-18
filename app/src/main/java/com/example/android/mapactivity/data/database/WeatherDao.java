package com.example.android.mapactivity.data.database;



import java.util.Date;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface WeatherDao {

    @Query("SELECT COUNT(id) FROM weather WHERE date >= :date")
    int countAllFutureWeather(Date date);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(WeatherEntry... weather);

    @Query("SELECT id, weatherIconId, date, min, max FROM weather WHERE date >= :date")
    LiveData<List<ListWeatherEntry>> getCurrentWeatherForecasts(Date date);

    @Query("DELETE FROM weather WHERE date < :date")
    void deleteOldWeather(Date date);

    @Query("SELECT * FROM weather WHERE date = :date")
    LiveData<WeatherEntry> getWeatherByDate(Date date);
}
