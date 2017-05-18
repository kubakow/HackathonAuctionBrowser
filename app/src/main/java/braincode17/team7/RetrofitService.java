package braincode17.team7;

import io.reactivex.Observable;

import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface RetrofitService {

    @GET("/offers")
    @Headers({
            "Api-Key:eyJjbGllbnRJZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.ogVV_a9RUOMa1OWFZOTmgTkdk-U37vTliDCBUQ1YySU=",
            "User-Agent:hackaton2017 (Client-Id 656cbe47-b17d-46c2-bae1-3222c8777d5b) Platform",
            "Accept: application/vnd.allegro.public.v1+json"})
    Observable<OffersContainer> getOfferList(@Query("country.code") String country, @Query("phrase") String phrase, @Query("limit") int limit, @Query("category.id") String categoryId, @Query("price_from") String priceFrom, @Query("price_to") String priceTo);

    @GET("/offers")
    @Headers({
            "Api-Key:eyJjbGllbnRJZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.ogVV_a9RUOMa1OWFZOTmgTkdk-U37vTliDCBUQ1YySU=",
            "User-Agent:hackaton2017 (Client-Id 656cbe47-b17d-46c2-bae1-3222c8777d5b) Platform",
            "Accept: application/vnd.allegro.public.v1+json"})
    Observable<OffersContainer> getOfferList(@Query("country.code") String country, @Query("phrase") String phrase, @Query("limit") int limit, @Query("price_from") String priceFrom, @Query("price_to") String priceTo);

    @GET("/offers")
    @Headers({
            "Api-Key:eyJjbGllbnRJZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.ogVV_a9RUOMa1OWFZOTmgTkdk-U37vTliDCBUQ1YySU=",
            "User-Agent:hackaton2017 (Client-Id 656cbe47-b17d-46c2-bae1-3222c8777d5b) Platform",
            "Accept: application/vnd.allegro.public.v1+json"})
    Observable<OffersContainer> getOfferList(@Query("country.code") String country, @Query("phrase") String phrase, @Query("limit") int limit);

    @GET("/offers")
    @Headers({
            "Api-Key:eyJjbGllbnRJZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.ogVV_a9RUOMa1OWFZOTmgTkdk-U37vTliDCBUQ1YySU=",
            "User-Agent:hackaton2017 (Client-Id 656cbe47-b17d-46c2-bae1-3222c8777d5b) Platform",
            "Accept: application/vnd.allegro.public.v1+json"})
    Observable<OffersContainer> getOfferList(@Query("country.code") String country, @Query("phrase") String phrase, @Query("limit") int limit, @Query("category.id") String categoryId);

//    @GET("/v1/allegro/offers")
//    @Headers("authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGxlZ3JvX2FwaSJdLCJleHAiOjE0OTA0NDE2NDgsImp0aSI6IjA5Njg2ZmRhLWMzMWEtNGNiMy1iYjBkLTY3OGJjN2QyYjQwZSIsImNsaWVudF9pZCI6ImE0MWY1YjJhLThlODctNGI4Yi1iNmZlLTc0Y2M3NjM3MjBkNyJ9.wMicT7H3yO0GrhZlaSe_Ybqn13w21jurPoJtjinFGEjaRzU8LCwfgxLGw7qqZ_ggeGEdWSJlDLynGd7_4EJmX_npKOD5KQXiU_S0AgcM1fefQRJLdApA_Nf3Z3NUrclX90ySOKT0EDa5UsV1x3j7RrpI8CHDu8EJXxVbzTjYuycALTDBqspYyL_2Y6AGfD_lytI1e8xaTvXkw4jpnMxVLD40mBN3FlQ7h3RsPIal-LxRNT8nizLjH9Z8OhKKwxGiVjiEnM_d7ag0vwkE0KQRIj00C9cOIA8sW_QfJLoY0_VU1t9RPILyWc1TBeN7M1JeSnx6PIvGqG_0BLEE02S9fQ")
//    Observable<OffersContainer> getDetailOffer();
}
