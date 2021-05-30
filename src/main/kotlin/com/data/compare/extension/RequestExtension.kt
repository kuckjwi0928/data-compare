package com.data.compare.extension

import org.springframework.web.reactive.function.server.ServerRequest

fun ServerRequest.pathVariableOrNull(name: String): String? = pathVariables().getOrDefault(name, null)
