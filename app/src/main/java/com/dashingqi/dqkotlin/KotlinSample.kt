package com.dashingqi.dqkotlin

/**
 * @desc :
 * @author : zhangqi
 * @time : 2022/1/8 17:31
 */
sealed class Contact {
    data class PhoneCall(val number: String) : Contact()
    data class TextMessage(val number: String) : Contact()
}

fun sendMessage(contact: Contact, message: String) {

    when (message.isEmpty()) {
        true -> return
    }

    when (contact) {
        is Contact.PhoneCall -> {}
    }
}