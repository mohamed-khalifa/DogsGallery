package com.task.dogsgallery.data.constants

object NetworkConstants {
    const val BASE_URL = "https://dog.ceo/api/"

    // Network Messages
    const val SOCKET_TIME_OUT_EXCEPTION =
        "Request timed out while trying to connect. Please ensure you have a strong signal and try again."
    const val UNKNOWN_NETWORK_EXCEPTION =
        "An unexpected error has occurred. Please check your network connection and try again."
    const val CONNECT_EXCEPTION =
        "Could not connect to the server. Please check your internet connection and try again."
    const val UNKNOWN_HOST_EXCEPTION =
        "Couldn't connect to the server at the moment. Please try again in a few minutes."
    const val GENERAL_ERROR =
        "An unexpected error has occurred."

}

object MockedConstants {
    const val DOG_NAME = "Dog"
    const val SHORT_DESCRIPTION = "Really cute dog"
    const val Long_DESCRIPTION =
        "Dogs are sometimes referred to as man's best friend because they are kept as domestic pets and are usually loyal and like being around humans. Dogs like to be petted, but only when they can first see the petter's hand before petting one should never pet a dog from behind."
}