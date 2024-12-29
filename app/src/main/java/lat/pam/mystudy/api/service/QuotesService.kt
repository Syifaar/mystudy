package lat.pam.mystudy.api.service

import lat.pam.mystudy.api.model.QuotesResponse
import retrofit2.Call
import retrofit2.http.GET

interface QuotesService {
    @GET("quotes")
    fun getAll(): Call<QuotesResponse>
}