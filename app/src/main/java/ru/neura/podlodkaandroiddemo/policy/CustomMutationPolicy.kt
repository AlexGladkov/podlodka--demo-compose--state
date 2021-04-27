package ru.neura.podlodkaandroiddemo.policy

import android.util.Log
import androidx.compose.runtime.SnapshotMutationPolicy

object CustomMutationPolicy : SnapshotMutationPolicy<Any?> {
    override fun equivalent(a: Any?, b: Any?): Boolean  = a == b

    override fun merge(previous: Any?, current: Any?, applied: Any?): Any? {
        Log.e("TAG", "=================")
        Log.e("TAG", "Previous -> $previous")
        Log.e("TAG", "Current -> $current")
        Log.e("TAG", "Applied -> $applied")
        Log.e("TAG", "=================")
        return super.merge(previous, current, applied)
    }
}

fun <T> customMutationPolicy(): SnapshotMutationPolicy<T> =
    CustomMutationPolicy as SnapshotMutationPolicy<T>