-if class com.example.network.Movie
-keepnames class com.example.network.Movie
-if class com.example.network.Movie
-keep class com.example.network.MovieJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
