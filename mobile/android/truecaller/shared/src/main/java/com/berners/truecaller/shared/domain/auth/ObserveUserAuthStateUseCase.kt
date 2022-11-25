package com.berners.truecaller.shared.domain.auth

import com.berners.truecaller.shared.data.signin.AuthenticatedUserInfo
import com.berners.truecaller.shared.data.signin.RegisteredUserInfo
import com.berners.truecaller.shared.di.ApplicationScope
import com.berners.truecaller.shared.di.IoDispatcher
import com.berners.truecaller.shared.domain.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject
import javax.inject.Singleton
import com.berners.truecaller.shared.result.Result
import com.berners.truecaller.shared.result.Result.Success
import com.berners.truecaller.shared.util.cancelIfActive
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.awaitClose

@Singleton
open class ObserveUserAuthStateUseCase @Inject constructor(
//    private val registeredUserDataSource: RegisteredUserDataSource,
//    private val authStateUserDataSource: AuthStateUserDataSource,
//    private val topicSubscriber: TopicSubscriber,
    @ApplicationScope private val externalScope: CoroutineScope,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : FlowUseCase<Any, AuthenticatedUserInfo>(ioDispatcher) {

    private var observeUserRegisteredChangesJob: Job? = null

    private val authStateChanges = callbackFlow<Result<AuthenticatedUserInfo>> {
        send(Success(RegisteredUserInfo(null, false)))
//        authStateUserDataSource.getBasicUserInfo().collect { userResult ->
//            // Cancel observing previous user registered changes
//            observeUserRegisteredChangesJob.cancelIfActive()
//
//            if (userResult is Success) {
//                if (userResult.data != null) {
//                    processUserData(userResult.data)
//                } else {
//                    send(Success(FirebaseRegisteredUserInfo(null, false)))
//                }
//            } else {
//                send(Result.Error(Exception("FirebaseAuth error")))
//            }
//        }
//
//        // Always wait for the flow to be closed. Specially important for tests.
        awaitClose { observeUserRegisteredChangesJob.cancelIfActive() }
    }
    .shareIn(externalScope, SharingStarted.WhileSubscribed())

    override fun execute(parameters: Any): Flow<Result<AuthenticatedUserInfo>> = authStateChanges
}