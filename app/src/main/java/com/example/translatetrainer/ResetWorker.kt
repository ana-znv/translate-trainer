package com.example.translatetrainer

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class ResetWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {
    override fun doWork(): Result {
        val sharedPreferences = applicationContext.getSharedPreferences(
            "app_prefs",
            Context.MODE_PRIVATE
        )
        sharedPreferences.edit().putInt("solved", 0).apply()
        return Result.success()
    }
}