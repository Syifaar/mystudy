package lat.pam.mystudy.api.quotes

import retrofit2.Call
import retrofit2.http.GET

interface QuotesService {
    @GET("quotes")
    suspend fun getAllQuotes(): QuotesResponse
}


