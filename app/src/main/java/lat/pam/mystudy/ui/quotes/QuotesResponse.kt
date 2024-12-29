package lat.pam.mystudy.api.quotes

data class QuotesResponse(
    val quotes: List<Quote>
)

data class Quote(
    val quote: String,
    val author: String
)

