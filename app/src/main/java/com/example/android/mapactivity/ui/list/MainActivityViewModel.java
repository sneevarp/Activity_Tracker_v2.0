package com.example.android.mapactivity.ui.list;

import com.example.android.mapactivity.data.SunshineRepository;
import com.example.android.mapactivity.data.database.ListWeatherEntry;
import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

/**
 * {@link ViewModel} for {@link MainActivity}
 */
class MainActivityViewModel extends ViewModel {

    private final SunshineRepository mRepository;
    private final LiveData<List<ListWeatherEntry>> mForecast;

    public MainActivityViewModel(SunshineRepository repository) {
        mRepository = repository;
        mForecast = mRepository.getCurrentWeatherForecasts();
    }

    public LiveData<List<ListWeatherEntry>> getForecast() {
        return mForecast;
    }


}
