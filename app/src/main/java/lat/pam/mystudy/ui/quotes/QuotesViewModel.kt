package lat.pam.mystudy.ui.quotes

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import lat.pam.mystudy.api.quotes.QuotesService
import lat.pam.mystudy.api.quotes.Quote
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuotesViewModel : ViewModel() {
    private val quotesService: QuotesService = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(QuotesService::class.java)

    val quote = mutableStateOf<Quote?>(null)

    init {
        fetchQuotes()
    }

    private fun fetchQuotes() {
        viewModelScope.launch {
            try {
                val response = quotesService.getAllQuotes()
                quote.value = response.quotes.random()
                println("Fetched quote: ${quote.value?.quote} by ${quote.value?.author}")
            } catch (e: Exception) {
                e.printStackTrace()
                quote.value = Quote(
                    quote = "Failed to fetch quote",
                    author = "Unknown"
                )
            }
        }
    }
}


