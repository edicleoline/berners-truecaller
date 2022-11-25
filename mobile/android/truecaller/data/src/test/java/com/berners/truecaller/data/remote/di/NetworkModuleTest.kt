package com.berners.truecaller.data.remote.di

import android.content.Context
import com.berners.truecaller.data.BuildConfig
import com.berners.truecaller.data.di.RemoteModule
import com.berners.truecaller.data.di.LocalModule
import com.berners.truecaller.data.di.RepositoryModule
import com.berners.truecaller.data.Result
import com.berners.truecaller.data.Result.Error
import com.berners.truecaller.data.Result.Success
import com.berners.truecaller.data.Result.Loading
import com.berners.truecaller.model.IncomingType.CALL
import com.berners.truecaller.test.data.MainCoroutineRule
import kotlinx.coroutines.test.runTest
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.Rule
import org.mockito.Mockito.mock
//import io.mockk.every
//import io.mockk.mockk
//import io.mockk.slot
//import io.mockk.verify

class NetworkModuleTest {
    private lateinit var remoteModule: RemoteModule
    private lateinit var localModule: LocalModule
    private lateinit var repositoryModule: RepositoryModule
    private lateinit var context: Context

    @Before
    fun setUp() {
        remoteModule = RemoteModule()
        localModule = LocalModule()
        repositoryModule = RepositoryModule()
    }

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    @Test
    fun verifyProvidedHttpLoggingInterceptor() {
        val interceptor = remoteModule.provideHttpLoggingInterceptor()
        assertEquals(HttpLoggingInterceptor.Level.BODY, interceptor.level)
    }

//    @Test
//    fun verifyProvidedHttpClient() {
//        val interceptor = mockk<HttpLoggingInterceptor>()
//        val httpClient = networkModule.provideHttpClient(interceptor)
//
//        assertEquals(1, httpClient.interceptors.size)
//        assertEquals(interceptor, httpClient.interceptors.first())
//    }

    @Test
    fun verifyProvidedRetrofitBuilder() {
        val retrofit = remoteModule.provideRetrofitBuilder()
        assertEquals(BuildConfig.TRUECALLER_API_BASE_URL, retrofit.baseUrl().toString())
    }

    @Test
    fun remotePhoneDataSourceTest() = runTest {
        val retrofit = remoteModule.provideRetrofitBuilder()
        val phoneService = remoteModule.providePhoneService(retrofit)
        val phoneDataSource = remoteModule.provideRemotePhoneDataSource(phoneService)

        val phone = phoneDataSource.getPhoneByIdStream(1722004730021)
        phone.collect { result ->
            when (result) {
                is Loading -> { println("LOADING THIS SHIT") }
                is Success -> { println(result.data?.nationalFormat) }
                is Error -> { println(result.exception.message) }
            }
        }
    }

//    @Test
//    fun localPhoneDataSourceTest() = runTest {
//        val context = mock(Context::class.java)
//        val appDatabase = localModule.provideAppDatabase(context)
//        val phoneDataSource = localModule.provideLocalPhoneDataSource(appDatabase)
//
//        val phone = phoneDataSource.findById(1722004730021)
//        phone.collect { result ->
//            when (result) {
//                is Result.Loading -> { println("LOADING THIS SHIT") }
//                is Result.Success -> { println(result.data?.nationalFormat) }
//                is Result.Error -> { println(result.exception.message) }
//            }
//        }
//    }

    @Test
    fun phoneRepositoryTest() = runTest {
        val retrofit = remoteModule.provideRetrofitBuilder()
        val phoneService = remoteModule.providePhoneService(retrofit)
        val remotePhoneDataSource = remoteModule.provideRemotePhoneDataSource(phoneService)

        val context = mock(Context::class.java)
        val appDatabase = localModule.provideAppDatabase(context)
        val localPhoneDataSource = localModule.provideLocalPhoneDataSource(appDatabase)

        val phoneRepository = repositoryModule.providePhoneRepository(remotePhoneDataSource, localPhoneDataSource)

        val phone = phoneRepository.getPhoneByIdStream(1722004730021)
        phone.collect { result ->
            when (result) {
                is Result.Loading -> { println("LOADING THIS SHIT") }
                is Result.Success -> { println(result.data?.nationalFormat) }
                is Result.Error -> { println(result.exception.message) }
            }
        }
    }

    @Test
    fun remoteTopSpammerDataSourceTest() = runTest {
        val retrofit = remoteModule.provideRetrofitBuilder()
        val topSpammerService = remoteModule.provideTopSpammerService(retrofit)
        val topSpammerDataSource = remoteModule.provideTopSpammerDataSource(topSpammerService)

        val list = topSpammerDataSource.listByIncomingType(CALL,2000)
        list.collect { result ->
            when (result) {
                is Result.Loading -> { println("LOADING THIS SHIT") }
                is Result.Success -> {
                    println("successsssssss")
                    val list = result.data
                    val count = list.size
                }
                is Result.Error -> { println(result.exception.message) }
            }
        }
    }

    @Test
    fun remoteUserDataSourceTest() = runTest {
        val retrofit = remoteModule.provideRetrofitBuilder()
        val userService = remoteModule.provideUserService(retrofit)
        val userDataSource = remoteModule.provideUserDataSource(userService)

        val user = userDataSource.me()
        user.collect { result ->
            when (result) {
                is Result.Loading -> { println("LOADING THIS SHIT") }
                is Result.Success -> { println(result.data?.name) }
                is Result.Error -> { println(result.exception.message) }
            }
        }
    }
}