-if class com.example.network.MovieResponse
-keepnames class com.example.network.MovieResponse
-if class com.example.network.MovieResponse
-keep class com.example.network.MovieResponseJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
