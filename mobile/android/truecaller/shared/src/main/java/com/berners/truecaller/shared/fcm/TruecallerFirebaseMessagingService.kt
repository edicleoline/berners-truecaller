package com.berners.truecaller.shared.fcm

//import android.app.job.JobInfo
//import android.app.job.JobScheduler
//import android.app.job.JobScheduler.RESULT_FAILURE
//import android.app.job.JobScheduler.RESULT_SUCCESS
//import android.content.ComponentName
//import android.content.Context
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
//import com.berners.truecaller.shared.data.job.ConferenceDataService
import timber.log.Timber
import java.util.concurrent.TimeUnit

class TruecallerFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Timber.d("New firebase token: $token")
        // Nothing to do, we update the user's firebase token via FirebaseAuthStateUserDataSource

    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Timber.d("Message data payload: ${remoteMessage.data}")
        val data = remoteMessage.data
        if (data[TRIGGER_EVENT_DATA_SYNC_key] == TRIGGER_TOP_SPAMMERS_DATA_SYNC) {
            // Schedule job on JobScheduler when FCM message with action `TRIGGER_EVENT_DATA_SYNC`
            // is received.
//            scheduleFetchEventData()
            Timber.d("LETS SYNC TOP_SPAMMERS NOW!!!!!")
        }
    }

//    private fun scheduleFetchEventData() {
//        val serviceComponent = ComponentName(this, ConferenceDataService::class.java)
//        val builder = JobInfo.Builder(ConferenceDataService.JOB_ID, serviceComponent)
//            .setMinimumLatency(MINIMUM_LATENCY) // wait at least
//            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED) // Unmetered if possible
//            .setOverrideDeadline(OVERRIDE_DEADLINE) // run by deadline if conditions not met
//
//        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
//
//        val result = jobScheduler.schedule(builder.build())
//
//        if (result == RESULT_FAILURE) {
//            Timber.e(
//                "Invalid param supplied to JobScheduler when starting ConferenceDataService job."
//            )
//        } else if (result == RESULT_SUCCESS) {
//            Timber.i("ConferenceDataService job scheduled..")
//        }
//    }

    companion object {
        private const val TRIGGER_TOP_SPAMMERS_DATA_SYNC = "SYNC_TOP_SPAMMER_DATA"
        private const val TRIGGER_EVENT_DATA_SYNC_key = "action"

        // Some latency to avoid load spikes
        private val MINIMUM_LATENCY = TimeUnit.SECONDS.toMillis(5)

        // Job scheduled to run only with Wi-Fi but with a deadline
        private val OVERRIDE_DEADLINE = TimeUnit.MINUTES.toMillis(15)
    }
}
