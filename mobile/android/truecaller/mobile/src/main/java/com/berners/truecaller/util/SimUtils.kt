package com.berners.truecaller.util

class SimUtils {
    companion object {
        fun multipleSims(): Boolean {
            return false
        }

        fun getSimByPhoneNumber(phone: String): Sim? {
            return Sim(slotIndex = 1)
//            return null
        }
    }
}

data class Sim(
    val slotIndex: Int
)