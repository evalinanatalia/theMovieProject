package com.example.bri.themoviesproject;


import com.example.bri.themoviesproject.Model.MovieModel;
import com.example.bri.themoviesproject.Model.PageModel;
import com.example.bri.themoviesproject.Retrofit.IMyAPI;
import com.example.bri.themoviesproject.Retrofit.RetrofitClient;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by BRI on 08/10/2018.
 */

public class MoviesDownloader implements Subscriber {
    PageModel pageModel;
    PublishSubject<Integer> r;

//    public Observable<Integer> getMovieList(){
//        r = PublishSubject.create();
//         IMyAPI service = RetrofitClient.getInstance().create(IMyAPI.class);
//        service.getMovies("3b561a9deada4994d60aa22b621966e9")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<PageModel>() {
//                    @Override
//                    public void accept(PageModel pageModel) throws Exception {
//                        setMoviewItems(pageModel);
//                    }
//                });
//        return r;
//
//    }

    public void setMoviewItems(PageModel pageModel) {
        this.pageModel = pageModel;
//        r.onCompleted();
    }

    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(Object o) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
