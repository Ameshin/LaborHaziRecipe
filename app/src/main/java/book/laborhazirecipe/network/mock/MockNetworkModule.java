package book.laborhazirecipe.network.mock;

import java.io.IOException;

import javax.inject.Singleton;

import book.laborhazirecipe.network.RecipesApi;
import book.laborhazirecipe.network.prod.NetworkModule;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

/**
 * Created by mobsoft on 2016. 05. 09..
 */
@Module
public class MockNetworkModule {

    private NetworkModule networkModule = new NetworkModule();

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return networkModule.provideOkHttpClientBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        builder.interceptors().add(0, new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                return MockHttpServer.call(request);
            }
        });
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return networkModule.provideRetrofit(client);
    }

    @Provides
    @Singleton
    public RecipesApi provideDefaultApi(Retrofit retrofit) {
        return retrofit.create(RecipesApi.class);
    }

}
